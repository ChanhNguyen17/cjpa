package com.airline.service;

import com.airline.models.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class PassengerService {

	/**
	 * Default constructor.
	 */
	public PassengerService() {
		// TODO Auto-generated constructor stub
	}

//	@PersistenceContext(unitName = "cjpa")
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cjpa");
	private EntityManager em = emf.createEntityManager();

	public void addPassenger(Passenger p) {
		System.out.println("test " +em);
		em.persist(p);
	}

}
