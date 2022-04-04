package Task7M;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaskAllocationDataBase {

	
	/** Declare a DB Connection **/
	private DBConnection database;
	
	public TaskAllocationDataBase(DBConnection newDB) {
		/** Fetch  a DB Connection from the TaskAllocationApp**/
		database= newDB;
	}
	
	/*** Assign a technician to a particular task in database ***/
	public void UpdateTech(int taskID, int techID) {
		// Should probably add a message if the student does not exist
		String sqlString = new String("UPDATE task SET tech_id= "+ techID +" WHERE task_id= "+ taskID+ ";");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	
	/*** Used to Remove a technician from a task and update the database ***/
	public void RemoveTech(int taskID) {
		// Should probably add a message if the student does not exist
		String sqlString = new String("UPDATE task SET tech_id= "+ null +" WHERE task_id= "+ taskID+ ";");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	

	
	/*** function to update the task in DB ***/
	public void updateTaskStatus(int taskID, String taskStatus) { 
		String sqlString = new String("UPDATE task SET task_status= '"+ taskStatus +"' WHERE task_id= "+ taskID+ ";");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
		
	}
	/*** Retrieve the Expected Days of a task to be completed***/
	public void updateExpectedDays(int taskID, int expectedDays) {
		
		String sqlString = new String("UPDATE task SET task_expectedDays = "+ expectedDays +" WHERE task_id= "+ taskID+ ";");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}

	/** Retrieve all the tasks and store it into an local array to display it for later on **/
	public ArrayList<Task> getAllTasks() {
		//String sqlStatement= new String(" SELECT task_id, task_type, task_desc, task_startDate, task_status, task_deadline, tech_id FROM task ;");
		String sqlStatement= new String(" SELECT task_id, task_type, task_desc, task_startDate, task_status, task_deadline, task_expectedDays , tech_id FROM task;");
		ResultSet taskList= database.RunSQLQuery(sqlStatement);
		ArrayList<Task> result = new ArrayList<>();
		try {
				while(taskList.next()) {
					Task newTask= new Task();
					newTask.setTaskId(taskList.getInt(1));
					newTask.setTask_type(taskList.getString(2));
					newTask.setTask_desc(taskList.getString(3));
					newTask.setTask_startDate(taskList.getString(4));
					newTask.setTask_status(taskList.getString(5));
					newTask.setTask_deadline(taskList.getString(6));
					
					/**** add the remaining days of the task******/
					LocalDate nowDate=LocalDate.now();
					long days=ChronoUnit.DAYS.between(nowDate, newTask.getTask_deadline());
				    updateExpectedDays(newTask.getTaskId(),(int)days);
	                /**** end of the algorithm***/
				    
					newTask.setRemainingDays(taskList.getInt(7));
					for(Technician t:getAllTech()) {
						if(taskList.getInt(8) == t.getTech_id()) {
						newTask.setTech(t);
						} 
					}
					result.add(newTask);
				}
		}catch(SQLException e) {
			System.out.println("Failed to process query in getAllTasks()");
			System.out.println("SQL attempted: "+sqlStatement);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());	
			e.printStackTrace();
		}
		return result;
	}
	
	/** Retrieve all the technicians and store them into an local array to display it for later **/
	public ArrayList<Technician> getAllTech(){
		String sqlStatement= new String("SELECT tech_id, tech_firstname, tech_lastname, tech_age, tech_skills, health_status FROM technician;");
		ResultSet techList= database.RunSQLQuery(sqlStatement);
		ArrayList<Technician> result= new ArrayList<>();
		
		try {
				while(techList.next()) {
					Technician newTech= new Technician();
					newTech.setTech_id(techList.getInt(1));
					newTech.setFirstName(techList.getString(2));
					newTech.setLastName(techList.getString(3));
					newTech.setAge(techList.getInt(4));
					newTech.setSkills(techList.getString(5));
					newTech.setHealth_status(techList.getString(6));
					result.add(newTech);
				}
		}catch(SQLException e) {
			System.out.println("Failed to process query in getAllTech()");
			System.out.println("SQL attempted: "+sqlStatement);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());	
			e.printStackTrace();
		}
		return result;
	}
	
	/*********************************************************************************/
//	public ArrayList<Task> getAssignedTech() {
//		//String sqlStatement= new String(" SELECT task_id, task_type, task_desc, task_startDate, task_status, task_deadline, tech_id FROM task ;");
//		String sqlStatement= new String(" SELECT ;");
//		ResultSet taskList= database.RunSQLQuery(sqlStatement);
//		ArrayList<Task> result = new ArrayList<>();
//		try {
//				while(taskList.next()) {
//					Task newTask= new Task();
//					newTask.setTaskId(taskList.getInt(1));
//					newTask.setTask_type(taskList.getString(2));
//					newTask.setTask_desc(taskList.getString(3));
//					newTask.setTask_startDate(taskList.getString(4));
//					newTask.setTask_status(taskList.getString(5));
//					newTask.setTask_deadline(taskList.getString(6));
//					
//					/**** add the remaining days of the task******/
//					LocalDate nowDate=LocalDate.now();
//					long days=ChronoUnit.DAYS.between(nowDate, newTask.getTask_deadline());
//				    updateExpectedDays(newTask.getTaskId(),(int)days);
//	                /**** end of the algorithm***/
//				    
//					newTask.setRemainingDays(taskList.getInt(7));
//					for(Technician t:getAllTech()) {
//						if(taskList.getInt(8) == t.getTech_id()) {
//						newTask.setTech(t);
//						} 
//					}
//					result.add(newTask);
//				}
//		}catch(SQLException e) {
//			System.out.println("Failed to process query in getAllTasks()");
//			System.out.println("SQL attempted: "+sqlStatement);	
//			System.out.println("Error: "+e.getErrorCode());
//			System.out.println("Message: "+e.getMessage());	
//			e.printStackTrace();
//		}
//		return result;
//	}
}
