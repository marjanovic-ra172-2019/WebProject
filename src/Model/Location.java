package Model;


public class Location{
    private Double getLatitude;
	private Double getLongitude;
	private Address adress;
	
	public Location(Double getLatitude, Double getLongitude, Address adress) {
		super();
		this.getLatitude = getLatitude;
		this.getLongitude = getLongitude;
		this.adress = adress;
	}
	public Double getGetLatitude() {
		return getLatitude;
	}
	public void setGetLatitude(Double getLatitude) {
		this.getLatitude = getLatitude;
	}
	public Double getGetLongitude() {
		return getLongitude;
	}
	public void setGetLongitude(Double getLongitude) {
		this.getLongitude = getLongitude;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}


	


}