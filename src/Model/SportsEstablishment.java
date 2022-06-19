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
	private float averageGrade;
	private WorkHours workingHours;
	
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
	public float getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(float averageGrade) {
		this.averageGrade = averageGrade;
	}
	public WorkHours getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(WorkHours workingHours) {
		this.workingHours = workingHours;
	}
	public SportsEstablishment(String name, EstablishmentType type, ArrayList<String> trainings, boolean open,
			Address location, float averageGrade) {
		super();
		this.name = name;
		this.type = type;
		this.trainings = trainings;
		this.open = open;
		this.location = location;
		this.averageGrade = averageGrade;
	}


}
