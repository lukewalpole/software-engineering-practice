package task5and9;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 

public class VSSApp {
	
	VSSGUI theMainWindow;			// The GUI to communicate with user
	private VSSDatabase data;
	private DateFormat formatter;

	// This is just to run the program
	public static void main(String[] args) {
		VSSApp vd = new VSSApp();
	

	}
	
	/**
	* Constructs the App and a GUI. Makes the GUI visible and 
	* loads data from the database for display in the GUI
	*
	*/
	public VSSApp(){
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		data = new VSSDatabase();
		theMainWindow = new VSSGUI(this);
		theMainWindow.setVisible(true);
		theMainWindow.displayTableData(data.GetAllMotors());
	}
	
	/**
	* Deletes the student from the database with the specified name
	* If no matching student exists, will fail silently
	*
	* @param  studentName The name of the student to delete
	*/
	void deleteMotor(String motorName) {
		data.DeleteMotor(motorName);
		
		theMainWindow.displayTableData(data.GetAllMotors());
	}
	
	
	/**
	* 
	*/
	void updateMotor(String motorName,
			String manufacturer,
			String client,
			String desc,
			String fault,
			Date startDate,
			Date endDate,
			Date duration,
			Date estimatedCompletion,
			String status,
			boolean delay,
			String replace,
			String notes) {
		data.UpdateMotor(motorName,
				 manufacturer,
				 client,
				 desc,
				 fault,
				 startDate,
				 endDate,
				 duration,
				 status,
				 delay,
				 replace,
				notes);
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		theMainWindow.displayTableData(data.GetAllMotors());
	}
	
	
	/**
	* Adds a new student to the database
	*
	* @param  studentName The name of the student to add
	* @param mark The mark for the new student
	*/
	void addMotor(String motorName,
			String manufacturer,
			String client,
			String desc,
			String fault,
			Date startDate,
			Date endDate,
			Date duration,
			Date estimatedCompletion,
			String status,
			boolean delay,
			String replace,
			String notes) {
		Motor m = new Motor();
		m.setMotorName(motorName);
		m.setManufacturer(manufacturer);
		m.setClient(client);
		m.setDesc(desc);	
		m.setFault(fault);
		m.setStartDate(startDate);
		m.setEndDate(endDate);
		m.setDuration(duration);
	    m.setEstimatedCompletion(estimatedCompletion);
		m.setStatus(status);	
		m.setDelay(delay);	
		m.setRep(replace);	
		m.setNotes(notes);
		data.AddMotor(m);
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		theMainWindow.displayTableData(data.GetAllMotors());
	}
	

}
