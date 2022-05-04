package task5and9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Inspection {
	
	int id;
	int userID;
	int motorID;
	String inspecResult;
	LocalDate inspecDate;
	String notes;
	
	
	public Inspection(){
		id=0;
		userID=0;
		motorID=0;
		 inspecResult="";
		Date inspecDate = null;
		String notes="";
		}
	
	
	//getters and setters
	
	public int getID() {
		return id;
	}
	
	public void setID(int newID) {
		id = newID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int newUserID) {
		userID = newUserID;
	}
	
	public int getMotorID() {
		return motorID;
	}
	
	public void setMotorID(int newMotorID) {
		motorID = newMotorID;
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
	
	public LocalDate getInspecDate() {
		return inspecDate;
	}
	
	
	public void setInspecDate(String newInspecDate) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		inspecDate = LocalDate.parse(newInspecDate,dtf);
	}

}
