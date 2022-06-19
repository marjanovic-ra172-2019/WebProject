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
		 ArrayList<String> trainings=new ArrayList<String>();
		 Boolean open=false;
		 Address address;
		 float averageGrade;
		 WorkHours workingHours;
		 StringTokenizer st;

		 while ((line = in.readLine()) != null) {
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
					address=new Address(adresa[0],Float.parseFloat(adresa[1]));
					averageGrade=Float.parseFloat(tokens[5]);
					

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

}
