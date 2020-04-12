package edu.century.pa4;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

//create gui
public class BookingGUI extends JFrame implements ActionListener {
	
	//instance variables
	private Passenger[] passengers;
	private int numPassengers;
	private int numReservation;
	private JLabel fNameL = new JLabel("First Name");
	private JLabel lNameL = new JLabel("Last Name");
	private JLabel fromL = new JLabel("From");
	private JLabel toL = new JLabel("To");
	private JLabel departDateL = new JLabel("Departure");
	private JLabel returnDateL = new JLabel("Return");
	private JLabel seatL = new JLabel("Seat");
	private JTextField fNameE = new JTextField(16);
	private JTextField lNameE = new JTextField(16);
	private JTextField fromE = new JTextField(16);
	private JTextField toE = new JTextField(16);
	private JTextField departDateE = new JTextField(10);
	private JTextField returnDateE = new JTextField(10);
	private JComboBox seatE = new JComboBox(createSeats());
	private JButton bookBtn = new JButton("Book");
	private JButton listResBtn = new JButton("List Reservations");
	private JButton clearBtn = new JButton("Clear Console");
	private JTextArea console = new JTextArea(8,64);
	private JPanel topPanel = new JPanel(new GridLayout(4,4));
	private JPanel btnPanel = new JPanel(new FlowLayout());
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JScrollPane consolePane = new JScrollPane(console);
	
	//define gui basics
	public BookingGUI(String title) {
		super(title);
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		createTopPanel();
		createBtnPanel();
		createBottomPanel();
		addPanelsToFrame();
		setListeners();
		setVisible(true);
	}
	
	//set listeners
	private void setListeners() {
		bookBtn.addActionListener(this);
		listResBtn.addActionListener(this);
		clearBtn.addActionListener(this);
	}
	
	//create the main gui frame
	private void addPanelsToFrame() {
		add(topPanel);
		add(btnPanel);
		add(bottomPanel);
	}

	//create the bottom panel, with the buttons and the console in border layout
	private void createBottomPanel() {
		bottomPanel.add(btnPanel,BorderLayout.NORTH);
		bottomPanel.add(consolePane,BorderLayout.CENTER);
	}

	//create the button panel in flow layout
	private void createBtnPanel() {
		btnPanel.add(bookBtn);
		btnPanel.add(listResBtn);
		btnPanel.add(clearBtn);
	}

	//create top panel in grid layout
	private void createTopPanel() {
		topPanel.add(fNameL);
		topPanel.add(fNameE);
		topPanel.add(lNameL);
		topPanel.add(lNameE);
		topPanel.add(fromL);
		topPanel.add(fromE);
		topPanel.add(toL);
		topPanel.add(toE);
		topPanel.add(departDateL);
		topPanel.add(departDateE);
		topPanel.add(returnDateL);
		topPanel.add(returnDateE);
		topPanel.add(seatL);
		topPanel.add(seatE);
	}
	
	//handle all actions for buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Book")) {
			seatCheck(seatE.getSelectedItem());
			Date departDate = dateCheck(departDateE.getText());
			Date returnDate = dateCheck(returnDateE.getText());
			createBooking(fNameE.getText(), lNameE.getText(), numReservation, String.valueOf(seatE.getSelectedItem()), fromE.getText(), toE.getText(), departDate, returnDate);
		} else if (callingBtn.equalsIgnoreCase("List Reservations")) {
			listReservations();
		} else if (callingBtn.equalsIgnoreCase("Clear Console")) {
			console.setText(null);
		}
	}
	
	//create the new booking
	private void createBooking(String fName, String lName, int numRes, String seat, String from, String to, Date departDate, Date returnDate) {
		passengers[numPassengers] = new Passenger(fName, lName, numRes, seat, from, to, departDate, returnDate);
		numPassengers++;
		numReservation++;
		System.out.println("Reservation completed for " + fNameE.getText() + "!");	
	}
	
	//check date format
	private Date dateCheck(String date) {
		Date dateGood = new Date();
		try {
			dateGood = new SimpleDateFormat("dd/mm/yyyy").parse(date);
		} catch (ParseException e1) {
			System.out.println("Invalid Date Format!  Please use dd/mm/yyyy");
		}		
		return dateGood;
	}

	//check for repeated seats
	private void seatCheck(Object seat) {
		if(numPassengers != 0) {
			for (int i = 0; i < numPassengers; i++) {
				int j = passengers[i].getReservationNo();
				if(passengers[i].reservation[j].getSeat().equals(seat)) {
					System.out.println("This seat has already been reserved.  Please choose another.");
					return;
				}
				else
					continue;
			}
		}		
	}

	//output a reservation list
	private void listReservations() {
		if (numPassengers != 0) {
			for (int i = 0; i < numPassengers; i++)
				System.out.println(passengers[i].toString());
		} else {
			System.out.println("There are no passengers currently reserved.");
		}
	}

	//create the seat choices for the combobox
	private String[] createSeats() {
		String[] seats = new String[28];
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
	
	//start the gui
	public static void main(String[] args) {
		BookingGUI gui = new BookingGUI("Fly AnyWhere");
	}
}
