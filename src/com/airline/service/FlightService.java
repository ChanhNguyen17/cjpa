package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {

    /**
     * Default constructor. 
     */
    public FlightService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "cjpa")
    EntityManager em;
    
    public void addFlight(Flight f, Airplane a) {
    	
    	em.persist(f);
    	em.persist(a);
    	
    }

}
