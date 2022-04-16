package task5and9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
//import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class VSSDatabase {
private DBConnection database;
private DateFormat formatter;

	public  VSSDatabase() {
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		database = new DBConnection();
		database.Connect("C:\\Users\\User\\Documents\\GitHub\\software-engineering-practice\\VultureServiceSystem\\database.db");
	}
	
	/**
	* Adds a new student to the DBConnection database
	* Sends error string to System.out if the DBConnection reports a failure
	*
	* @param  sm  A StudentMark object with the name and mark
	* sqlString = sqlString + formatter.format(m.getEstimatedCompletion())+"', ";
	*/
	public void AddMotor(Motor m) {
		String sqlString = new String("INSERT INTO motor VALUES('");
		sqlString = sqlString + m.getID()+"', '";
		sqlString = sqlString + m.getUserID()+"', '";
		sqlString = sqlString + m.getMotorName()+"', '";
		sqlString = sqlString + m.getMotorManufacturer()+"', '";
		sqlString = sqlString + m.getClient()+"', '";
		sqlString = sqlString + m.getDesc()+"', '";
		sqlString = sqlString + m.getFault()+"', '";
		sqlString = sqlString + formatter.format(m.getStartDate())+"', '";
		sqlString = sqlString + formatter.format(m.getEndDate())+"', '";
		sqlString = sqlString + formatter.format(m.getDuration())+"', '";
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
		
		String sqlString = new String("DELETE FROM motor WHERE motor_name = '"+motorName+"';");
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
			Date startDate,
			Date endDate,
			Date duration,
			String status,
			boolean delay,
			String replace,
			String notes) {
		
		/*
		 * motor_manufacturer TEXT,
motor_client TEXT,
motor_desc TEXT,
motor_fault TEXT,
job_startDate TEXT,
job_endDate TEXT NULL,
job_duration TEXT,
job_status TEXT,
job_delay TEXT NULL,
replacement_parts TEXT NULL,
notes TEXT NULL,
		 */
		
		String sqlString = new String("UPDATE motor SET motor_manufacturer="+ manufacturer 
				+", motor_client=" + client 
				+", motor_desc=" + desc
				+", motor_fault=" + fault
				+", job_startDate=" + startDate
				+", job_endDate=" + endDate
				+", job_duration=" + desc
				+", job_status=" + desc
				+", job_delay=" + desc
				+", replacement_parts=" + desc
				+", notes=" + notes
				+" WHERE motor_name='"+motorName+"';");

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
				try {
					m.setStartDate(formatter.parse(motorList.getString(8)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				try {
					m.setEndDate(formatter.parse(motorList.getString(9)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				try {
					m.setDuration(formatter.parse(motorList.getString(10)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				//m.setEstimatedCompletion(formatter.parse(motorList.getString(2)));
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
}


