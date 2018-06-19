package com.airline.controllers;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	FlightService fs;
	
	
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Flight f = new Flight();
		
		f.setFlightOrigin(FlightDestinations.Los_Angeles);
		
		f.setFlightDestination(FlightDestinations.London);
		
		f.setPrice(400);
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.MINUTE, 0);
		
		Date flightTime = cal.getTime();
		
		System.out.println(flightTime);
		
		f.setFlightTime(flightTime);
		
		Airplane a = new Airplane();
		
		a.setModelName("787");
		a.setPlaneMake("Boeing");
		a.setSeatingCapacity(250);
		
		f.setAirplaneDetail(a);
		
		System.out.println(f);
		System.out.println(a);
		
		fs.addFlight(f, a);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
