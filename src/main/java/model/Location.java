package model;


public class Location{
    private float getLatitude;
	private float getLongitude;
	private Address adress;
	
	public Location(float getLatitude, float getLongitude, Address adress) {
		super();
		this.getLatitude = getLatitude;
		this.getLongitude = getLongitude;
		this.adress = adress;
	}
	public float getGetLatitude() {
		return getLatitude;
	}
	public void setGetLatitude(float getLatitude) {
		this.getLatitude = getLatitude;
	}
	public float getGetLongitude() {
		return getLongitude;
	}
	public void setGetLongitude(float getLongitude) {
		this.getLongitude = getLongitude;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}


	


}