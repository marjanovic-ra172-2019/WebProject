package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import enums.EstablishmentType;
import Model.Address;
import Model.SportsEstablishment;

public class EstablishmentDAO {

	private static ArrayList<SportsEstablishment> establishments = new ArrayList<SportsEstablishment>();
	private static ArrayList<SportsEstablishment> filteredEstablishments=new ArrayList<SportsEstablishment>();

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
	establishments=new ArrayList<SportsEstablishment>();
	try {
		File file = new File(contextPath + "/establishments.txt");
		
		System.out.println(file.getCanonicalPath());
		in = new BufferedReader(new FileReader(file));

		 String line,name="";
	     EstablishmentType type=null;
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
					String startTime=tokens[3];
					String endTime=tokens[4];
					String adresa[] =tokens[5].split(",");
					address=new Address(adresa[0],Double.parseDouble(adresa[1]));
					averageGrade=Double.parseDouble(tokens[6]);
					

					establishments.add(new SportsEstablishment(name, type, trainings,startTime,endTime,address,averageGrade));
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

	public SportsEstablishment GetByName(String name) {
		for (SportsEstablishment s : establishments) 
		{
			if(name.equals(s.getName())) {
				return s;
			}
		}
		return null;
	}


	public Collection<SportsEstablishment> searchNames(String name)
	{
		name=name.trim();
		if (!filteredEstablishments.isEmpty()) {
			filteredEstablishments= new ArrayList<SportsEstablishment>();
		}
		
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
		if (!filteredEstablishments.isEmpty()) {
			filteredEstablishments= new ArrayList<SportsEstablishment>();
		}
		
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
		if (!filteredEstablishments.isEmpty()) {
			filteredEstablishments= new ArrayList<SportsEstablishment>();
		}
		
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
		
		if (!filteredEstablishments.isEmpty()) {
			filteredEstablishments= new ArrayList<SportsEstablishment>();
		}
		
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

	public Collection<SportsEstablishment> searchOpen() {
		
		if (!filteredEstablishments.isEmpty()) {
			filteredEstablishments= new ArrayList<SportsEstablishment>();
		}

		for (SportsEstablishment s : establishments) 
		{


			if(s.getWorkingHours().IsOpen()) {
				filteredEstablishments.add(s);
			}
		} 
		return filteredEstablishments;
		}

	public Boolean add(SportsEstablishment establishment) {
		if(establishments.add(establishment))
			return true;
		return false;	}

	Comparator<SportsEstablishment> compareByName = new Comparator<SportsEstablishment>() {
		@Override
		public int compare(SportsEstablishment o1, SportsEstablishment o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};

	Comparator<SportsEstablishment> compareByType = new Comparator<SportsEstablishment>() {
		@Override
		public int compare(SportsEstablishment o1, SportsEstablishment o2) {
			return o1.getType().compareTo(o2.getType());
		}
	};
	Comparator<SportsEstablishment> compareByAdress = new Comparator<SportsEstablishment>() {
		@Override
		public int compare(SportsEstablishment o1, SportsEstablishment o2) {
			return o1.getLocation().getName().compareTo(o2.getLocation().getName());
		}
	};
	Comparator<SportsEstablishment> compareByGrade = new Comparator<SportsEstablishment>() {
		@Override
		public int compare(SportsEstablishment o1, SportsEstablishment o2) {
			return o1.getAverageGrade().compareTo(o2.getAverageGrade());
		}
	};

	public Collection<SportsEstablishment> sort(String field, String direction) {
		if (filteredEstablishments.isEmpty()) {
			filteredEstablishments=establishments;
		}
		if(direction.equals("asc")) {
			switch(field.toLowerCase()) {
			
			case "name":
				Collections.sort(filteredEstablishments,compareByName);
				break;
			case "type":
				Collections.sort(filteredEstablishments,compareByType);
				break;
			case "location":
				Collections.sort(filteredEstablishments,compareByAdress);
				break;
			case "averagegrade":
				Collections.sort(filteredEstablishments,compareByGrade);
				break;
			}

		} else if(direction.equals("desc"))
		{
			switch(field.toLowerCase()) {
			
			case "name":
				Collections.sort(filteredEstablishments,compareByName.reversed());
				break;
			case "type":
				Collections.sort(filteredEstablishments,compareByType.reversed());
				break;
			case "location":
				Collections.sort(filteredEstablishments,compareByAdress.reversed());
				break;
			case "averagegrade":
				Collections.sort(filteredEstablishments,compareByGrade.reversed());
				break;
			}
			
		}
		return filteredEstablishments;
	}
	
	
	
}
