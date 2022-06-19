package Model;

public class Address {
	private String name;
	private float number;
	private String city;
	private int postalNum;
	
	public Address(String name, float number) {
		super();
		this.name = name;
		this.number = number;
		this.city = "";
		this.postalNum = 0;
	}
	public Address(String name, float number, String city, int postalNum) {
		super();
		this.name = name;
		this.number = number;
		this.city = city;
		this.postalNum = postalNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalNum() {
		return postalNum;
	}
	public void setPostalNum(int postalNum) {
		this.postalNum = postalNum;
	}
	
	
	
}
