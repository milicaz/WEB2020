package beans;

import java.util.Date;

import com.sun.prism.Image;

public class Apartments {
	
	private int id;
	private String type; //apartment, room
	private int roomNum;
	private int guestNum;
	private Location location;
	//zadaje domacin
	private Date freeDate;
	//ne znam kako da dodam dostupnost po datumima
	private User host;
	private AComment comment;
	private Image image;
	private double nightPrice;
	

}
