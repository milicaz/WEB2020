package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

public class UserDAOJson {
	
private HashMap<Integer, User> users=new HashMap<>();
	
	public HashMap<Integer, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<Integer, User> users) {
		this.users = users;
	}

	public UserDAOJson() {
		
	}
	
	public  UserDAOJson(String contextPath) {

		loadUsers(contextPath);
	}
	
	public Collection<User> findAll(){
		return users.values();
	}
	
	public User find(String username, String password) {
		if (!users.containsKey(username)) {
			return null;
		}
		User user = users.get(username);
		if (!user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}

	
	public void loadUsers(String contextPath) {
	System.out.println("ucitavanjee: "+contextPath);

		try {
			File file=new File(contextPath+ "/json/user.json");
			ObjectMapper objectMapper=new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

			
			User[] usersA=objectMapper.readValue(file, User[].class);
			
			for(User u:usersA) {
				users.put(u.getId(), u);
				System.out.println(users);
			}
			System.out.println(usersA.length+"a=velicina");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public int generateNewId() {
		int id=1;
		for(User u:users.values()) {
			if(u.getId()==id) {
				id++;
			}
		}
		return id;
	}
	
	public User saveUser(User user) {
		int id=generateNewId();
		user.setId(id);
		user.setRole("guest");
		users.put(user.getId(), user);
		return  user;
	}
	
	public User saveHost(User user) {
		int id=generateNewId();
		user.setId(id);
		user.setRole("host");
		users.put(user.getId(), user);
		return user;
	}
	
	public void saveUsers(String contextPath) {
		System.out.println("kthhh  "+contextPath);
		try {
			File file=new File(contextPath+"/json/user.json");
			ObjectMapper objectMapper=new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

			ArrayList<User> usersArray=new ArrayList<>();
			
			for(User u: users.values()) {
				usersArray.add(u);
			}
			
			System.out.println("aaaaa"+usersArray.size());
			objectMapper.writeValue(new File(contextPath+"/json/user.json"), usersArray);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public User checkLogin(String username,String password) {
		
		for(User u:users.values()) {
			if(u.getUsername().equals(username)) {
				if(u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		
		return null;
		
	}
	
	public User findUser(String username) {
		return users.containsKey(username) ? users.get(username):null;
	}

}
