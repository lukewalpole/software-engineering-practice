package task5and9;

import java.util.*;



public class Motor {
	
	String motorName;
	String manufacturer;
	String client;
	String desc;
	String fault;
	Date startDate;
	Date endDate;
	Date duration;
	Date estimatedCompletion;
	String status;
	boolean delay;
	String replace;
	String notes;
	
	
	public Motor(){
		 motorName="";
		 manufacturer="";
		 client="";
		 desc="";
		 fault="";
		 startDate= new Date();
		 endDate=new Date();
		 duration=new Date();
		 estimatedCompletion=new Date();
		 status="";
		 delay=false;
		 replace="";
		 notes="";
	}
	
	
	//getters and setters
	
	
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
	
	
	public void setDelay(boolean newDelay) {
		delay = newDelay;
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
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	
	public void setStartDate(Date newStartDate) {
		startDate = newStartDate;
	}
	
	//
	
	public Date getEndDate() {
		return endDate;
	}
	
	
	public void setEndDate(Date newEndDate) {
		endDate = newEndDate;
	}
	
	//
	
	public Date getDuration() {
		return duration;
	}
	
	
	public void setDuration(Date newDuration) {
		duration = newDuration;
	}
	
	//
	
	public Date getEstimatedCompletion() {
		return estimatedCompletion;
	}
	
	
	public void setEstimatedCompletion(Date newEstimatedCompletion) {
		estimatedCompletion = newEstimatedCompletion;
		
	}
	
	
	
	
	//check if job has taken longer than estimated
	
	public boolean isLate() {
		delay=false;
		if (endDate.after(estimatedCompletion)){
			delay = true;
		}
		return delay;
	}
	
}
