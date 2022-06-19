package Model;

import java.util.Date;

import enums.Gender;
import enums.Role;

public class User {

	private String username;
	private String password;
	private String name;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
	private Role role;
	
	
	public User() {
		super();
		this.username = null;
		this.password = null;
		this.name = null;
		this.lastName = null;
		this.gender = null;
		this.dateOfBirth = null;
		this.role = null;
		}

	public User(String username, String password, String name, String lastName, Gender gender, Date dateOfBirth,
			Role role) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
