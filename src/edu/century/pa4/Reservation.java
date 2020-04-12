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

	
	//constructor with input
	public Reservation(String fName, String lName, int reservationNo, Object seat, String from, String to, Date departureDate, Date returnDate) {
		super(fName, lName, reservationNo);
		this.setSeat(seat);
		this.setFrom(from);
		this.setTo(to);
		this.setDepartureDate(departureDate);
		this.setReturnDate(departureDate, returnDate);
	}
	
	//toString override
	@Override
	public String toString() {
		String reserveOut = "Seat: " + this.getSeat() + "\nFrom: " + this.getFrom() + "\nTo: " + this.getTo() + "\nDeparture: " + this.getDepartureDate() + "\nReturn: " + this.getReturnDate();
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

	public void setReturnDate(Date departureDate, Date returnDate) {
		if(returnDate.after(departureDate)) {
			this.returnDate = returnDate;
		} else {
			System.out.println("Invalid return date, please try another...");
		}
	}
		
}
