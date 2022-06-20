package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import enums.EstablishmentType;
import Model.Address;
import Model.Location;
import Model.SportsEstablishment;
import Model.Training;
import Model.WorkHours;

public class EstablishmentDAO {

	private static ArrayList<SportsEstablishment> establishments = new ArrayList<SportsEstablishment>();

public EstablishmentDAO() {
	}

public EstablishmentDAO(String contextPath) {
	loadEstablishments(contextPath);
}
public Collection<SportsEstablishment> findAll() {
	return establishments;
	}

private void loadEstablishments(String contextPath){
	BufferedReader in = null;
	try {
		File file = new File(contextPath + "/establishments.txt");
		
		System.out.println(file.getCanonicalPath());
		in = new BufferedReader(new FileReader(file));

		 String line,name="";
	     EstablishmentType type=null;
		 Boolean open=false;
		 Address address;
		 Double averageGrade;
		 
		 while ((line = in.readLine()) != null) {
			 	ArrayList<String> trainings=new ArrayList<String>();
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				String tokens[] =line.split(";");
				
					name = tokens[0].trim();
					type = EstablishmentType.valueOf(tokens[1].trim().toUpperCase());
					String training[] =tokens[2].split(",");
					for(String tr:training) {
						trainings.add(tr);
					}
					open=Boolean.parseBoolean(tokens[3]);
					String adresa[] =tokens[4].split(",");
					address=new Address(adresa[0],Double.parseDouble(adresa[1]));
					averageGrade=Double.parseDouble(tokens[5]);
					

					establishments.add(new SportsEstablishment(name, type, trainings, open, address,averageGrade));
			}
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if ( in != null ) {
			try {
				in.close();
			}
			catch (Exception e) { }
		}
	}
}

	public Collection<SportsEstablishment> searchNames(String name)
	{
		name=name.trim();
		ArrayList<SportsEstablishment> filteredEstablishments = new ArrayList<SportsEstablishment>();

		
		for (SportsEstablishment s : establishments) 
		{
			if(validateSearchNames(s, name))
			filteredEstablishments.add(s);
		} 
		return filteredEstablishments;
	}
	private boolean validateSearchNames(SportsEstablishment establishment, String name) {
		if(establishment.getName().toLowerCase().contains(name.toLowerCase()))
		return true;
		else return false;
		}

	public Collection<SportsEstablishment> searchType(String type) {

		type=type.trim();
		ArrayList<SportsEstablishment> filteredEstablishments = new ArrayList<SportsEstablishment>();

		
		for (SportsEstablishment s : establishments) 
		{
			if(validateSearchType(s, type))
			filteredEstablishments.add(s);
		} 
		return filteredEstablishments;
	
	}
	private boolean validateSearchType(SportsEstablishment establishment, String type) {
		if(establishment.getType().toString().toLowerCase().contains(type.toLowerCase()))
		return true;
		else return false;
		}

	public Collection<SportsEstablishment> searchAddress(String address) {

		address=address.trim();
		ArrayList<SportsEstablishment> filteredEstablishments = new ArrayList<SportsEstablishment>();

		
		for (SportsEstablishment s : establishments) 
		{
			if(validateSearchAddress(s, address))
			filteredEstablishments.add(s);
		} 
		return filteredEstablishments;
		}
	
	private boolean validateSearchAddress(SportsEstablishment establishment, String address) {
		if(establishment.getLocation().getName().toLowerCase().contains(address.toLowerCase()))
		return true;
		else if(establishment.getLocation().getNumber().toString().toLowerCase().contains(address.toLowerCase()))
			return true;
		else
			return false;
		}

	public Collection<SportsEstablishment> searchGrade(String grade) {
		
		ArrayList<SportsEstablishment> filteredEstablishments = new ArrayList<SportsEstablishment>();

		
		for (SportsEstablishment s : establishments) 
		{
			if(validateSearchGrade(s, grade))
			filteredEstablishments.add(s);
		} 
		return filteredEstablishments;
		}
	
	private boolean validateSearchGrade(SportsEstablishment establishment, String grade) {
		if(establishment.getAverageGrade().toString().toLowerCase().contains(grade.toLowerCase()))
		return true;
		else
		return false;
		}
}
