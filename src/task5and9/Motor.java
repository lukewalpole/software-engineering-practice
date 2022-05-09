package task5and9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit ;



public class Motor {
	
	int id;
	int userID;
	String motorName;
	String manufacturer;
	String client;
	String desc;
	String fault;
	LocalDate startDate;
	LocalDate endDate;
	int duration;
	LocalDate estimatedCompletion;
	String status;
	boolean delay;
	String replace;
	String notes;
	
	
	public Motor(){
		int id=0;
		int userID=0;
		 motorName="";
		 manufacturer="";
		 client="";
		 desc="";
		 fault="";
		 startDate= null;
		 endDate=null;
		 duration=0;
		 estimatedCompletion=null;
		 status="";
		 delay=false;
		 replace="";
		 notes="";
	}
	
	
	//getters and setters
	public int getID() {
		return id;
	}
	public void setID(int newMotorid) {
		id = newMotorid;
	}
	//
	public int getUserID() {
	return userID;
}
	public void setUserID(int newUserid) {
		userID = newUserid;
	}
	
	//
	
	
	public String getMotorName() {
		return motorName;
	}
	
	
	public void setMotorName(String newMotor) {
		motorName = newMotor;
	}
	
	//
	
	public String getMotorManufacturer() {
		return manufacturer;
	}
	
	
	public void setManufacturer(String newManufacturer) {
		manufacturer = newManufacturer;
	}
	
	//
	
	public String getClient() {
		return client;
	}
	
	
	public void setClient(String newClient) {
		client = newClient;
	}
	
	//
	
	public String getDesc() {
		return desc;
	}
	
	
	public void setDesc(String newDesc) {
		desc = newDesc;
	}
	
	//
	
	public String getFault() {
		return fault;
	}
	
	
	public void setFault(String newFault) {
		fault = newFault;
	}
	
	//
	
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	
	//
	
	public boolean getDelay() {
		return delay;
	}
	
	
	public void setDelay() {
		//delay = newDelay;
		//delay=false;
		if (endDate.isAfter(estimatedCompletion) && status!=("Complete")){
			delay = true;
		}
	}
	
	public void setdbDelay(boolean delay) {
		//delay = newDelay;
		//delay=false;
		if (endDate.isAfter(estimatedCompletion) && status!=("Complete")){
			delay = true;
		}
	}
	
//
	
	public String getRep() {
		return replace;
	}
	
	
	public void setRep(String newRep) {
		replace = newRep;
	}
	//
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String newNotes) {
		notes = newNotes;
	}
	
	//
	
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	
	public void setStartDate(String newStartDate) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate tempStartDate = LocalDate.parse(newStartDate,dtf);
		startDate = LocalDate.now();
		
		/*if (tempStartDate==null) {
			startDate=LocalDate.now();
		}else {
			startDate=tempStartDate;
		}*/

	}
	
	public void setStartDateAdding() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		startDate = LocalDate.now();

	}
	//
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	
	public void setEndDate(String newEndtDate) {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//endDate = LocalDate.parse(newEndDate,dtf);
		endDate=LocalDate.now();
	}
	
public void setEndDateAdding() {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//endDate = LocalDate.parse(newEndDate,dtf);
		endDate=LocalDate.now();
	}
	
	//
	
	public int getDuration() {
		return duration;
	}
	
	
	public void setDuration(int newDuration) {
	    long daysBetween =ChronoUnit.DAYS.between(startDate,endDate);
	    duration=(int)daysBetween;
	}
	
	public void setDurationAdding() {
	    long daysBetween =ChronoUnit.DAYS.between(startDate,endDate);
	    duration=(int)daysBetween;
	}
	
	//
	
	public LocalDate getEstimatedCompletion() {
		return estimatedCompletion;
	}
	
	
	public void setEstimatedCompletion(String newEstimatedCompletion) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		estimatedCompletion = LocalDate.parse(newEstimatedCompletion,dtf);
		
	}
	
	
	
	
	//check if job has taken longer than estimated
	
	public boolean isLate() {
		delay=false;
		if (endDate.isAfter(estimatedCompletion)){
			delay = true;
		}
		return delay;
	}
	
}
