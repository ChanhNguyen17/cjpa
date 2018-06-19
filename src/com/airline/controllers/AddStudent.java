package com.airline.controllers;

import com.airline.models.Student;
import com.airline.service.StudentService;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    StudentService stuS;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = new Student();
        String body = request.getReader().lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(body);
            String name = (String) json.get("name");
            String ageRaw = (String) json.get("age");
            stu.setName(name);
            stu.setAge(Double.parseDouble(ageRaw));
            System.out.println(stu);
            stuS.addStudent(stu);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Students");
    }
}
