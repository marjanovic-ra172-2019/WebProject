package Model;

import enums.TrainingType;

public class Training {
	private String name;
	private TrainingType type;
	private SportsEstablishment establisment;
	private int Duration;
	//Trainer trainer;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TrainingType getType() {
		return type;
	}
	public void setType(TrainingType type) {
		this.type = type;
	}
	public SportsEstablishment getEstablisment() {
		return establisment;
	}
	public void setEstablisment(SportsEstablishment establisment) {
		this.establisment = establisment;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
