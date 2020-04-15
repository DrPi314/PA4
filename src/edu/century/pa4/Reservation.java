package edu.century.pa4;
import java.util.Date;

//to store reservation details for passengers
public class Reservation extends Passenger{
	
	//instance variables
	private Object seat;
	private String from;
	private String to;
	private Date departureDate;
	private Date returnDate;
	
	//Default Constructor
	public Reservation() {
		super();
		this.setSeat(null);
		this.setFrom(null);
		this.setTo(null);
		this.setDepartureDate(null);
		this.setReturnDate(null);
	}
	
	//constructor with input
	public Reservation(String fName, String lName, int reservationNo, Object seat, String from, String to, Date departureDate, Date returnDate) {
		super(fName, lName, reservationNo);
		this.setSeat(seat);
		this.setFrom(from);
		this.setTo(to);
		this.setDepartureDate(departureDate);
		this.setReturnDate(returnDate);
	}
	
	//toString override
	@Override
	public String toString() {
		String reserveOut = super.toString() + "Seat: " + this.getSeat() + "\nFrom: " + this.getFrom() + "\nTo: " + this.getTo() + "\nDeparture: " + this.getDepartureDate() + "\nReturn: " + this.getReturnDate();
		return reserveOut;
	}

	//getters and setters
	public Object getSeat() {
		return seat;
	}

	public void setSeat(Object seat) {
		this.seat = seat;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
		
}
