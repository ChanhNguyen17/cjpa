package com.airline.controllers;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.persistence.descriptors.*;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cjpa");
	private EntityManager em = emf.createEntityManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Passenger p = new Passenger();

		p.setFirstName("Daniel");
		p.setLastName("Chermetz");
		
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, 1986);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 10);

		Date dob = cal.getTime();

		p.setDob(dob);

		p.setGender(Gender.Male);

		p.setFlightClass(FlightClass.Coach);
		
		System.out.println(p);

//		ps.addPassenger(p);
		em.persist(p);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
