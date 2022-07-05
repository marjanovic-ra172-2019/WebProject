package Model;

import java.util.ArrayList;

import enums.EstablishmentType;

public class SportsEstablishment {

	private String name;
	private EstablishmentType type;
	private ArrayList<String> trainings;
	private boolean open;
	private Address location;
	// private Image logoObject;
	private Double averageGrade;
	private WorkHours workingHours;
	
	public SportsEstablishment() {
		super();
		this.name = null;
		this.type = EstablishmentType.GYM;
		this.trainings = null;
		this.workingHours = null;
		this.location = null;
		this.averageGrade = 0.0;
	}

	public SportsEstablishment(String name, EstablishmentType type, String location) {
		super();
		this.name = name;
		this.type = type;
		this.location = new Address(location);
	}
	
	public SportsEstablishment(String name, EstablishmentType type, Address location, String StartTime, String EndTime) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.workingHours = new WorkHours(StartTime,EndTime);
	}
	
	public SportsEstablishment(String name, EstablishmentType type, ArrayList<String> trainings, WorkHours hours,
			Address location, Double averageGrade) {
		super();
		this.name = name;
		this.type = type;
		this.trainings = trainings;
		this.workingHours =hours;
		this.location = location;
		this.averageGrade = averageGrade;
	}
	
	
	public SportsEstablishment(String name2, EstablishmentType type2, ArrayList<String> trainings2, String startTime,
			String endTime, Address address, Double averageGrade2) {
		this.name = name2;
		this.type = type2;
		this.trainings = trainings2;
		this.workingHours=new WorkHours(startTime,endTime);
		this.location = address;
		this.averageGrade = averageGrade2;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EstablishmentType getType() {
		return type;
	}
	public void setType(EstablishmentType type) {
		this.type = type;
	}
	public ArrayList<String> getTrainings() {
		return trainings;
	} 
	public void setTrainings(ArrayList<String> trainings) {
		this.trainings = trainings;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Address getLocation() {
		return location;
	}
	public void setLocation(Address location) {
		this.location = location;
	}
	public Double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public WorkHours getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(WorkHours workingHours) {
		this.workingHours = workingHours;
	}
	


}
