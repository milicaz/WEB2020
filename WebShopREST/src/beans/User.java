package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	
	private int id;
	private String username;
	private String password;
	//private String repeatPass;
	private String firstName;
	private String lastName;
	private String gender;
	private String role; //administrator, domacin, gost
	
	
	/*//Za gosta
	private List<Reservation> reservations = new ArrayList<>();
	private List<Apartments> rentedApartments = new ArrayList<>();
	
	//Za domacina
	
	private List<Apartments> availableApartments = new ArrayList<>();
	*/
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		//this.repeatPass = repeatPass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public String getRepeatPass() {
		return repeatPass;
	}


	public void setRepeatPass(String repeatPass) {
		this.repeatPass = repeatPass;
	}*/


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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
