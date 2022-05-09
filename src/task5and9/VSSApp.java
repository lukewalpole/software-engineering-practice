package task5and9;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import Task7.Technician; 

public class VSSApp {
	
	allInspectionDialog InspecWindow;
	allTaskDialog TaskWindow;
	VSSGUI theMainWindow;	// The GUI to communicate with user
	delayDialog DelayWindow;
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
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		data = new VSSDatabase();
		theMainWindow = new VSSGUI(this);
		theMainWindow.setVisible(true);
		theMainWindow.displayTableData(data.GetAllMotors());
		//data.DeleteTask(0);
		
		//InspecWindow = new allInspectionDialog(this);
		//InspecWindow.setVisible(true);
		//InspecWindow.displayTableData(data.GetAllInspections());
		
		
		
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
			String startDate,
			String endDate,
			int duration,
			String estimatedCompletion,
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
	* Adds a new motor to the database
	*int id,
			int userID,
	* @param  studentName The name of the student to add
	* @param mark The mark for the new student
	*/
	void addMotor(String motorName,
			String manufacturer,
			String client,
			String desc,
			String fault,
			String startDate,
			String endDate,
			int duration,
			String estimatedCompletion,
			String status,
			boolean delay,
			String replace,
			String notes) {
		Motor m = new Motor();
		//m.setID(id);
		//m.setUserID(userID);
		m.setMotorName(motorName);
		m.setManufacturer(manufacturer);
		m.setClient(client);
		m.setDesc(desc);	
		m.setFault(fault);
		m.setStartDateAdding(LocalDate.now());
		m.setEndDate(endDate);
		m.setDuration(duration);
	    m.setEstimatedCompletion(estimatedCompletion);
		m.setStatus(status);	
		m.setDelay(delay);	
		m.setRep(replace);	
		m.setNotes(notes);
		data.AddMotor(m);
		//System.out.println(m);
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		theMainWindow.displayTableData(data.GetAllMotors());
		
	}
	
	void addInspec(int userID,
			int motorID,
			String inspecResult,
			String inspectionDate,
			String notes) {
		Inspection m = new Inspection();
		m.setMotorID(motorID);
		m.setUserID(userID);
		m.setInspecRes(inspecResult);
		m.setInspecDate(inspectionDate);
		m.setNotes(notes);
		data.AddInspec(m);
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		
		InspecWindow = new allInspectionDialog(this);
		InspecWindow.setVisible(true);
		InspecWindow.displayTableData(data.GetAllInspections());
	}
	
	void deleteInspec(int ID) {
		data.DeleteInspec(ID);
		
		InspecWindow = new allInspectionDialog(this);
		InspecWindow.setVisible(true);
		InspecWindow.displayTableData(data.GetAllInspections());
	}

	
	//task
	
	void addTask(
			int motorID,
			//String tech,
			String taskType,
			String taskDesc,
			String taskStart,
			String taskEnd,
			String taskStatus,
			String taskDeadline,
			String notes) {
		Task m = new Task();
		m.setMotorID(motorID);
		//m.setUserID(userID);
		m.setTask_type(taskType);
		m.setTask_desc(taskDesc);
		m.setTask_startDate(taskStart);
		m.setTask_endDate(taskEnd);
		m.setTask_status(taskStatus);
		m.setTask_deadline(taskDeadline);
		//m.setTech(tech);
		m.setNotes(notes);
		data.AddTask(m);
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		
		TaskWindow = new allTaskDialog(this);
		TaskWindow.setVisible(true);
		TaskWindow.displayTableData(data.GetAllTasks());
	}
	
	void deleteTask(int ID) {
		data.DeleteTask(ID);
		
		TaskWindow = new allTaskDialog(this);
		TaskWindow.setVisible(true);
		TaskWindow.displayTableData(data.GetAllTasks());
	}
	
	void suspendTask(int ID) {
		data.suspendTask(ID);
		
		DelayWindow = new delayDialog(this);
		DelayWindow.setVisible(true);
		DelayWindow.displayTableData(data.GetAllRemainingTasks());
	}
	
	void resumeTask(int ID) {
		data.resumeTask(ID);
		
		DelayWindow = new delayDialog(this);
		DelayWindow.setVisible(true);
		DelayWindow.displayTableData(data.GetAllRemainingTasks());
	}
	
	void completeTask(int ID) {
		data.completeTask(ID);
		
		DelayWindow = new delayDialog(this);
		DelayWindow.setVisible(true);
		DelayWindow.displayTableData(data.GetAllRemainingTasks());
	}
	
	void sendAlerts(int ID) {
		data.sendAlerts(ID);
		
		DelayWindow = new delayDialog(this);
		DelayWindow.setVisible(true);
		DelayWindow.displayTableData(data.GetAllRemainingTasks());
	}
}
