package task5and9;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import Task7.Technician;

public class Task {
	
	private int taskId;
	private int userID;
	private int motorID;
	private String task_type;
	private String task_desc;
	private LocalDate task_startDate;
	private LocalDate task_endDate;
	private String task_status;
	private LocalDate task_deadline;
	private int remainingDays;
	public String notes;
	protected Technician tech; // declare tech inside task class
	
	/***Create an empty constructor***/
	public Task() {
		this.taskId = 0;
		this.userID = 0;
		this.motorID = 0;
		this.task_type = null;
		this.task_desc = null;
		this.task_startDate = null;
		this.task_status = null;
		this.task_deadline = null;
		this.remainingDays=0;
		this.task_endDate=null;
		this.notes=null;
		this.tech=null;
        
	}

	public Task(int taskId,int userID,int motorID, String task_type, String task_desc, LocalDate task_startDate,LocalDate task_endDate, String task_status,
			LocalDate task_deadline, int newRemainingDays, String notes, Technician newTech) {
		this.taskId = taskId;
		this.userID = userID;
		this.motorID = motorID;
		this.task_type = task_type;
		this.task_desc = task_desc;
		this.task_startDate = task_startDate;
		this.task_status = task_status;
		this.task_deadline = task_deadline;
		this.remainingDays=newRemainingDays;
		this.task_endDate=task_endDate;
		this.notes=notes;
		this.tech= newTech;
	}

	/***Getters&Settters***/
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getMotorID() {
		return motorID;
	}

	public void setMotorID(int motorID) {
		this.motorID = motorID;
	}
	
	
	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public LocalDate getTask_startDate() {
		return task_startDate;
	}

	public void setTask_startDate(String task_startDate) {

		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.task_startDate = LocalDate.parse(task_startDate,dtf);


	}
	
	public LocalDate getTask_endDate() {
		return task_endDate;
	}

	public void setTask_endDate(String task_endDate) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.task_endDate = LocalDate.parse(task_endDate,dtf);

	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public LocalDate getTask_deadline() { 
		return task_deadline;

	}
/***retrieve the data from DB and set  the deadline using LocalDate and DateTimeFormatter classes***/
	public void setTask_deadline(String task_deadline) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.task_deadline = LocalDate.parse(task_deadline,dtf);
	}
	
	public int getRemainingDays() {
		return this.remainingDays;
	}
	
	public void setRemainingDays(int newRemainingDays) {
		this.remainingDays= newRemainingDays;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	public void setNotes(String notes) {
		this.notes=notes;
	}
	
	
	public Technician getTech() {
		return tech;
	}
	
	public void setTech(Technician newTech) {
		this.tech=newTech;
	}
	/***End of Getters&Setters***/
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", task_type=" + task_type + ", task_desc=" + task_desc + ", task_startDate="
				+ task_startDate + ", task_status=" + task_status + ", task_deadline=" + task_deadline + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId, task_deadline, task_desc, task_startDate, task_status, task_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return taskId == other.taskId && Objects.equals(task_deadline, other.task_deadline)
				&& Objects.equals(task_desc, other.task_desc) && Objects.equals(task_startDate, other.task_startDate)
				&& Objects.equals(task_status, other.task_status) && Objects.equals(task_type, other.task_type);
	}

}

