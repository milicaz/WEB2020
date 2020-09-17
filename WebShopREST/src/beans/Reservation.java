package beans;

import java.util.Date;

public class Reservation {
	
	private int id;
	private Apartments resApartment;
	private Date startDate;
	private int sleepNumber = 1;
	private double totalPrice;
	private String message;
	private User guest;
	private String status; //created, rejected, withdrawal, accepted, completed	

}
