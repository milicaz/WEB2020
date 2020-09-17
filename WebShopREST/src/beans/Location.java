package beans;

public class Location {
	
	private int id;
	private double longitude;
	private double latitude;
	private Address address;
	
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Location(int id, double longitude, double latitude, Address address) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
