package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import Model.User;
import enums.Gender;
import enums.Role;


public class UserDao {
	private static ArrayList<User> users = new ArrayList<User>();

	public UserDao() {
	}
	
	public UserDao(String contextPath) {
		loadUsers(contextPath);
	}
	public Collection<User> findAll() {
		return users;
	}
	
	private void loadUsers(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/users.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));

			String line,username=null,password=null,firstName=null,lastName=null;
			Gender gender=null;
			Role role=null;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				
				String tokens[] =line.split(";");
				
					 username = tokens[0].trim();
					 password = tokens[1].trim();
					 firstName = tokens[2].trim();
					 lastName = tokens[3].trim();
					 gender=Gender.valueOf(tokens[4].trim().toUpperCase());
					 role=Role.valueOf(tokens[6].trim().toUpperCase());
					 users.add(new User(username, password,firstName,lastName,gender,null,role));
					
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
	}

	public User find(String username, String password) {
			for(User user:users) 
			{
				if(user.getUsername().toLowerCase().equals(username.toLowerCase()))
					if(user.getPassword().toLowerCase().equals(password.toLowerCase()))
						{
						return user;
						}
			}
			return null;
		
		}

	public Boolean searchForUsername(String username) {
		for(User user:users) 
		{
			if(user.getUsername().toLowerCase().equals(username.toLowerCase()))
				return true;
		}
		return false;
	}

	public Boolean add(User user) {
		System.out.println(1);
		if(users.add(user))
			return true;
		return false;
	}
}
