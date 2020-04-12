package edu.century.pa4;

import java.util.Date;

//to store passenger information
public class Passenger {
	private String fName;
	private String lName;
	private int reservationNo;
	Reservation[] reservation;
	
	//default constructor
	public Passenger() {
		super();
		this.fName = null;
		this.lName = null;
		this.reservationNo = 0;
		this.reservation[reservationNo] = new Reservation();
	}
	
	//constructor with input
	public Passenger(String fName, String lName, int reservationNo, String seat, String from, String to, Date departureDate, Date returnDate) {
		super();
		this.setfName(fName);
		this.setlName(lName);
		this.setReservationNo(reservationNo);
		this.reservation[reservationNo] = new Reservation(seat, from, to, departureDate, returnDate);
	}
	
	//toString override
	@Override
	public String toString() {
		String passengerOut = "****Reservation " + this.getReservationNo() + "****\nFirst Name: " + this.getfName() + "\nLast Name: " + this.getlName() + "\n" + reservation[this.getReservationNo()].toString();
		return passengerOut;
	}

	//getters and setters
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	
	
}
