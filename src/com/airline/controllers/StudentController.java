package com.airline.controllers;

import com.airline.models.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() { super(); }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cjpa");
    private EntityManager em = emf.createEntityManager();

    public List<Student> getStudents() throws ServletException, IOException {
        TypedQuery<Student> query = em.createQuery("SELECT e FROM Student e", Student.class);
        return query.getResultList();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String ageRaw = request.getParameter("age");
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(Double.parseDouble(ageRaw));
        System.out.println(stu);
        em.getTransaction().begin();
        if (!em.contains(stu)) {
            // persist object - add to entity manager
            em.persist(stu);
            // flush em - save to DB
            em.flush();
        }
        // commit transaction at all
        em.getTransaction().commit();
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
