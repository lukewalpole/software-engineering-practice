package task5and9;

import java.util.*;

public class Inspection {
	
	int id;
	int userID;
	int motorID;
	String inspecResult;
	Date inspecDate;
	String notes;
	
	
	public Inspection(){
		id=0;
		userID=0;
		motorID=0;
		 inspecResult="";
		Date inspecDate = new Date();
		String notes="";
		}
	
	
	//getters and setters
	
	public int getID() {
		return id;
	}
	public int getUserID() {
		return userID;
	}
	public int getMotorID() {
		return motorID;
	}
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String newNotes) {
		notes = newNotes;
	}
	
	
	//
	public String getInspecRes() {
		return inspecResult;
	}
	
	
	public void setInspecRes(String newInspecRes) {
		inspecResult = newInspecRes;
	}
	
	//
	
	public Date getInspecDate() {
		return inspecDate;
	}
	
	
	public void setInspecDate(Date newInspecDate) {
		inspecDate = newInspecDate;
	}

}
