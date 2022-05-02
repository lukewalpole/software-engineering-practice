package task5and9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
//import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.time.temporal.ChronoUnit;




public class VSSDatabase {
private DBConnection database;
private DateFormat formatter;

	public  VSSDatabase() {
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		database = new DBConnection();
		database.Connect("C:\\Users\\User\\Documents\\GitHub\\software-engineering-practice\\VultureServiceSystem\\database.db");
	}
	
	
	// functions to set motor status
	
		public void updateMotorStatus (int motorID, String motorStatus) {
			String sqlString = new String("UPDATE motor SET job_status= '"+ motorStatus +"' WHERE motor_id= "+ motorID+ ";");

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
	/**
	* Adds a new student to the DBConnection database
	* Sends error string to System.out if the DBConnection reports a failure
	*
	* @param  sm  A StudentMark object with the name and mark
	* sqlString = sqlString + formatter.format(m.getEstimatedCompletion())+"', ";
	*/
	public void AddMotor(Motor m) {
		String sqlString = new String("INSERT INTO motor(user_id, motor_name, motor_manufacturer, motor_client, motor_desc, motor_fault, job_startDate, job_endDate, job_duration, job_status, job_delay, replacement_parts, notes) VALUES('");
		//sqlString = sqlString + m.getID()+"', '";
		sqlString = sqlString + m.getUserID()+"', '";
		sqlString = sqlString + m.getMotorName()+"', '";
		sqlString = sqlString + m.getMotorManufacturer()+"', '";
		sqlString = sqlString + m.getClient()+"', '";
		sqlString = sqlString + m.getDesc()+"', '";
		sqlString = sqlString + m.getFault()+"', '";
		sqlString = sqlString + m.getStartDate()+"', '";
		sqlString = sqlString + m.getEndDate()+"', '";
		sqlString = sqlString + m.getDuration()+"', '";
		sqlString = sqlString + m.getStatus()+"', '";
		sqlString = sqlString + m.getDelay()+"', '";
		sqlString = sqlString + m.getRep()+"', '";
		sqlString = sqlString+   m.getNotes();
		sqlString = sqlString+  "');";
		
		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	/**
	* Deletes a  student from the DBConnection database
	* Sends error string to System.out if the DBConnection reports a failure
	* Fails silently if the student does not exist
	* @param  studentName  The name of the student to delete
	*/
	public void DeleteMotor(String motorName) {
		// Should probably add a message if the motor does not exist.
		
		//"DELETE FROM motor WHERE motor_name = '"+motorName+"';"
		String sqlString = new String("DELETE FROM motor;");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	public void suspendTask(int ID) {
		// Should probably add a message if the motor does not exist.
		
		
		String sqlString = new String("UPDATE task SET task_status='Suspended' WHERE task_id='"+ID+"';");
		
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	public void resumeTask(int ID) {
		// Should probably add a message if the motor does not exist.
		
		String sqlString = new String("UPDATE task SET task_status='In Progress' WHERE task_id='"+ID+"';");
		
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	public void completeTask(int ID) {
		// Should probably add a message if the motor does not exist.
		
		
		String sqlString = new String("UPDATE task SET task_status='Complete' WHERE task_id='"+ID+"';");
		
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	/**
	 * send alerts to manager or customer service
	 */
	public void sendAlerts(int ID) {
		// Should probably add a message if the motor does not exist.
		Task t = new Task();
		
		//Duration dayBetween =Duration.between(t.getTask_startDate(),t.getTask_startDate());
		long daysBetween =ChronoUnit.DAYS.between(t.getTask_startDate(),t.getTask_endDate());
		//long days = t.getTask_startDate().until(t.getTask_startDate(),DAYS);
		
		if(!t.getTask_status().equals("suspended") && daysBetween>2 ) {
		String sqlString = new String("UPDATE task SET task_status='manager alerted' WHERE task_id='"+ID+"';");
		}else if(t.getTask_deadline().isBefore(LocalDate.now())) {
			String sqlString = new String("UPDATE task SET task_status='customer service alerted' WHERE task_id='"+ID+"';");
		}
		
		String sqlString = new String("UPDATE task SET task_status='alerted' WHERE task_id='"+ID+"';");
		
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	
	/**
	* Changes the mark of a student in the DBConnection database
	* Sends error string to System.out if the DBConnection reports a failure
	* fails silently if the student does not exist
	* @param  sm  A StudentMark object with the name and mark
	*/
	public void UpdateMotor(String motorName,
			String manufacturer,
			String client,
			String desc,
			String fault,
			String startDate,
			String endDate,
			int duration,
			String status,
			boolean delay,
			String replace,
			String notes) {
		
		
		String sqlString = new String("UPDATE motor SET motor_manufacturer='" + manufacturer 
				+"', motor_client= '" + client 
				+"', motor_desc='" + desc
				+"', motor_fault='" + fault
				+"', job_startDate='" + startDate
				+"', job_endDate='" + endDate
				+"', job_duration='" + desc
				+"', job_status='" + desc
				+"', job_delay='" + desc
				+"', replacement_parts='" + desc
				+"', notes='" + notes
				+"' WHERE motor_name='"+motorName+"';");

		boolean success = database.RunSQL(sqlString);
		
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	public void AddInspec(Inspection m) {
		String sqlString = new String("INSERT INTO inspection(user_id, motor_id, inspection_result, inspection_date, notes) VALUES('");
	    //sqlString = sqlString + m.getID()+"', '";
		sqlString = sqlString + m.getUserID()+"', '";
		sqlString = sqlString + m.getMotorID()+"', '";
		sqlString = sqlString + m.getInspecRes()+"', '";
		sqlString = sqlString + m.getInspecDate()+"', '";
		sqlString = sqlString+   m.getNotes();
		sqlString = sqlString+  "');";
		
			boolean success = database.RunSQL(sqlString);
					
					if(!success) {
						System.out.println("Failed to run query: "+sqlString);
					}
		}
	
	//delete inspection
	
	public void DeleteInspec(int ID) {
		// Should probably add a message if the motor does not exist.
		
		//"DELETE FROM inspection WHERE inspection_id = '"+ID+"';"
		String sqlString = new String("DELETE FROM inspection WHERE inspection_id = '"+ID+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	
	//add task
	//"INSERT INTO task(user_id,
	public void AddTask(Task m) {
		String sqlString = new String("INSERT INTO task( motor_id, task_type, task_desc,task_startDate,task_endDate,task_status,task_deadline, notes) VALUES('");
	    //sqlString = sqlString + m.getID()+"', '";
		//sqlString = sqlString + m.getUserID()+"', '";
		sqlString = sqlString + m.getMotorID()+"', '";
		sqlString = sqlString + m.getTask_type()+"', '";
		sqlString = sqlString + m.getTask_desc()+"', '";
		sqlString = sqlString + m.getTask_startDate()+"', '";
		sqlString = sqlString + m.getTask_endDate()+"', '";
		sqlString = sqlString + m.getTask_status()+"', '";
		sqlString = sqlString + m.getTask_deadline()+"', '";
		sqlString = sqlString+   m.getNotes();
		sqlString = sqlString+  "');";
		
			boolean success = database.RunSQL(sqlString);
					
					if(!success) {
						System.out.println("Failed to run query: "+sqlString);
					}
		}
	
	//delete task
	
	public void DeleteTask(int ID) {
		// Should probably add a message if the motor does not exist.
		
		//"DELETE FROM task WHERE task_id = '"+ID+"';"
		
		String sqlString = new String("DELETE FROM task WHERE task_id = '"+ID+"';");
		boolean success = database.RunSQL(sqlString);
		if(!success) {
			System.out.println("Failed to run query: "+sqlString);
		}
	}
	/**
	* Returns an array list of all students in the database
	* Sends error string to System.out if the DBConnection reports a failure
	* @return  An arraylist containing StudentMark objects for all students in the database
	*/
	//motor_name,
	public ArrayList<Motor> GetAllMotors(){
		
		String sqlString = new String("SELECT "
				+"motor_id"
				+", user_id"
				+", motor_name"
				+", motor_manufacturer"
				+", motor_client"  
				+", motor_desc" 
				+", motor_fault"
				+", job_startDate" 
				+", job_endDate" 
				+", job_duration" 
				+", job_status" 
				+", job_delay"
				+", replacement_parts"
				+", notes "
				+ "FROM motor;");
		ResultSet motorList = database.RunSQLQuery(sqlString);
		ArrayList<Motor> answer = new ArrayList<Motor>();
		
		try {
			while(motorList.next()) {
				Motor m = new Motor();
				m.setID(motorList.getInt(1));
				m.setUserID(motorList.getInt(2));
				m.setMotorName(motorList.getString(3));
				m.setManufacturer(motorList.getString(4));
				m.setClient(motorList.getString(5));
				m.setDesc(motorList.getString(6));	
				m.setFault(motorList.getString(7));	
					m.setStartDate(motorList.getString(8));
					m.setEndDate(motorList.getString(9));
					m.setDuration(motorList.getInt(10));	
				//m.setEstimatedCompletion(motorList.getString(doesnt exist on database));
				m.setStatus(motorList.getString(11));	
				m.setDelay(Boolean.parseBoolean((motorList.getString(12))));	
				m.setRep(motorList.getString(13));	
				m.setNotes(motorList.getString(14));	
				answer.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllMotors()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}
	
public ArrayList<Inspection> GetAllInspections(){
		
		String sqlString = new String("SELECT "
				+"inspection_id"
				+", user_id"
				+", motor_id"
				+", inspection_result"
				+", inspection_date"  
				+", notes "
				+ "FROM inspection;");
		ResultSet inspecList = database.RunSQLQuery(sqlString);
		ArrayList<Inspection> answer = new ArrayList<Inspection>();
		
		try {
			while(inspecList.next()) {
				Inspection m = new Inspection();
				m.setID(inspecList.getInt(1));
				m.setUserID(inspecList.getInt(2));
				m.setMotorID(inspecList.getInt(3));
				m.setInspecRes(inspecList.getString(4));
				m.setInspecDate(inspecList.getString(5));
				m.setNotes(inspecList.getString(6));	
				answer.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Failed to process query in GetAllInspections()");
			System.out.println("SQL attempted: "+sqlString);	
			System.out.println("Error: "+e.getErrorCode());
			System.out.println("Message: "+e.getMessage());			
			e.printStackTrace();
		}
		return answer;
	}

//get all tasks
public ArrayList<Task> GetAllTasks(){
	
	String sqlString = new String("SELECT "
			+"task_id"
			//+", user_id"
			+", motor_id"
			+", tech_id"
			+", task_type"  
			+", task_desc" 
			+", task_startDate" 
			+", task_endDate" 
			+", task_status" 
			+", task_deadline" 
			+", notes "
			+ "FROM task;");
	ResultSet taskList = database.RunSQLQuery(sqlString);
	ArrayList<Task> answer = new ArrayList<Task>();
	
	try {
		while(taskList.next()) {
			Task m = new Task();
			m.setTaskId(taskList.getInt(1));
			//m.setUserID(taskList.getInt(2));
			m.setMotorID(taskList.getInt(3));
			//m.setTech(taskList.getString(4));
			m.setTask_type(taskList.getString(5));
			m.setTask_desc(taskList.getString(6));
			m.setTask_startDate(taskList.getString(7));
			m.setTask_endDate(taskList.getString(8));
			m.setTask_status(taskList.getString(9));
			m.setTask_deadline(taskList.getString(10));
			m.setNotes(taskList.getString(11));
			answer.add(m);
		}
	} catch (SQLException e) {
		System.out.println("Failed to process query in GetAllTasks()");
		System.out.println("SQL attempted: "+sqlString);	
		System.out.println("Error: "+e.getErrorCode());
		System.out.println("Message: "+e.getMessage());			
		e.printStackTrace();
	}
	return answer;
}


public ArrayList<Task> GetAllRemainingTasks(){
	
	String sqlString = new String("SELECT "
			+"task_id"
			+", task_type"   
			+", task_startDate" 
			+", task_endDate" 
			+", task_status" 
			+", task_deadline " 
			+ "FROM task WHERE task_status IN ('High Priority', 'Normal Priority','In Progress','Suspended', 'Alerted Manager','Alerted Customer Service');");
	ResultSet taskList = database.RunSQLQuery(sqlString);
	ArrayList<Task> answer = new ArrayList<Task>();
	
	try {
		while(taskList.next()) {
			Task m = new Task();
			m.setTaskId(taskList.getInt(1));
			m.setTask_type(taskList.getString(2));
			m.setTask_startDate(taskList.getString(3));
			m.setTask_endDate(taskList.getString(4));
			m.setTask_status(taskList.getString(5));
			//m.setTask_deadline(taskList.getString(6));
			answer.add(m);
		}
	} catch (SQLException e) {
		System.out.println("Failed to process query in GetAllTasks()");
		System.out.println("SQL attempted: "+sqlString);	
		System.out.println("Error: "+e.getErrorCode());
		System.out.println("Message: "+e.getMessage());			
		e.printStackTrace();
	}
	return answer;
}

}


