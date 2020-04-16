package edu.century.pa4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//to store reservation details for passengers
public class Reservation extends Passenger{
	
	//instance variables
	private String seat;
	static String[] comboSeats = createSeats(28);
	private String from;
	private String to;
	private Date departureDate;
	private Date returnDate;
	public static boolean reservationError = false;
	
	//Default Constructor
	public Reservation() {
		super();
		this.seatCheck(null, 0);
		this.setFrom(null);
		this.setTo(null);
		this.setDepartureDate(null);
		this.setReturnDate(null);
	}
	
	//constructor with input
	public Reservation(String fName, String lName, String seat, String from, String to, String departureDate, String returnDate) {
		super(fName, lName, BookingGUI.numReservation);
		this.setSeat(seatCheck(seat, BookingGUI.numReservation));
		this.setFrom(from);
		this.setTo(to);
		this.setDepartureDate(dateCreate(departureDate));
		this.setReturnDate(dateCreate(returnDate));
	}
	
	//toString override
	@Override
	public String toString() {
		String reserveOut = super.toString() + "Seat: " + this.getSeat() + "\nFrom: " + this.getFrom() + "\nTo: " + this.getTo() + "\nDeparture: " + this.getDepartureDate() + "\nReturn: " + this.getReturnDate() + "\n";
		return reserveOut;
	}
	
	//create array to keep track of occupied seats
	static String[][] setSeatAssign() {
		String[] seats = comboSeats;
		String[][] seatAssign = new String[28][2];
		for(int i = 0; i < 28; i++) {
			seatAssign[i][0] = seats[i];
			seatAssign[i][1] = "empty";
		}
		return seatAssign;
	}
	
	//create the seat choices for the combobox
	public static String[] createSeats(int size) {
		String[] seats = new String[size];
		String[] seat = {"a", "b", "c", "d"};
		String[] row = {"1", "2", "3", "4", "5", "6", "7"};
		int k = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				String chair = row[i] + seat[j];
				seats[k] = chair;
				k++;
			}
		}
		return seats;
	}
	
	//check for empty seat and assign if previously empty
	public String seatCheck(String seat, int r) {
		String setSeat = null;
		if(seat != null) {
			String[][] s = BookingGUI.getSeatAssign();
			for(int i = 0; i < 28; i++) {
				if(s[i][0].equalsIgnoreCase(seat))
					if(s[i][1].equalsIgnoreCase("empty")) {
						s[i][1] = "" + r;
						return setSeat;
				} else {
					reservationError = true;
				}
			}
			BookingGUI.consoleAppend("Seat is taken, try another.\n");
		} else {
			BookingGUI.consoleAppend("Please choose a seat.\n");
		}
		return setSeat;
	}
	
	//check date format
	private void dateCheck(String date) {
		if(date.isEmpty()) {
			BookingGUI.consoleAppend("Date is missing\n");
			reservationError = true;
		} else {
			try {
				new SimpleDateFormat("MM-dd-yyyy").parse(date);
			} catch (ParseException e1) {
				reservationError = true;
			}		
		}
	}
	
	//check date order
	public boolean checkReturnDate(Date departureDate, Date returnDate) {
		boolean returnGood = false;
		if(returnDate != null) {
			if(returnDate.after(departureDate)) {
				returnGood = true;
			} else {
				BookingGUI.consoleAppend("Return must follow Departure.\n");
				reservationError = true;
			}
		}
		return returnGood;
	}
	
	//create date variable
	Date dateCreate(String date) {
		dateCheck(date);
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		try {
			Date goodDate = formatter.parse(date);
			return goodDate;
		} catch (ParseException e1) {
			BookingGUI.consoleAppend("Invalid Date Format!  Please use mm-dd-yyyy\n");
			return null;
		}		
	}

	//getters and setters
	public boolean getReservationError() {
		return reservationError;
	}
	
	public static void setReservationError(boolean re) {
		reservationError = re;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
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
