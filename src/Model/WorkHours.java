package Model;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class WorkHours {
	private String startTime;
	private String endTime;

	
	public WorkHours(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public boolean IsOpen() {
		 
	    String CurrentTime=getCurrentTime();
	    if(Compare(CurrentTime,endTime))
	    {}
	    else if(Compare(startTime,CurrentTime)) {}
	    else 
	    	return true;
	    
		return false;
	}
	
	

	private String getCurrentTime() {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");  
	    
	    String formattedDate = myDateObj.format(myFormatObj); 
	    return formattedDate;
	}
	
	private boolean Compare(String time1,String time2) 
	{
	    String time_1[]=time1.split(":");
	    String time_2[]=time2.split(":");

	    
		int Hour1=Integer.parseInt(time_1[0]);
		int minutes1=Integer.parseInt(time_1[1]);
		int Hour2=Integer.parseInt(time_2[0]);
		int minutes2=Integer.parseInt(time_2[1]);
		
		if(Hour1>Hour2) 
		{
			return true;
		}
		else if(Hour1==Hour2) 
		{
			if(minutes1>=minutes2)
				return true;
		}
		
		return false;
	}
}
