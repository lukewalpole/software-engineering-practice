package task5and9;

import java.util.*;

public class Inspection {
	

	String inspecResult;
	Date inspecDate;
	String notes;
	
	
	public Inspection(){
		 inspecResult="";
		Date inspecDate = new Date();
		String notes="";
		}
	
	
	//getters and setters
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String newNotes) {
		notes = newNotes;
	}
	
	
	//
	
	public Date getInspecDate() {
		return inspecDate;
	}
	
	
	public void setInspecDate(Date newInspecDate) {
		inspecDate = newInspecDate;
	}

}
