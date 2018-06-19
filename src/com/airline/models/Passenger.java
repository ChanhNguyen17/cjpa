package com.airline.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: Passenger
 *
 */
@Entity
public class Passenger implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Passenger() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private FlightClass flightClass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", gender="
				+ gender + ", flightClass=" + flightClass + "]";
	}

}
