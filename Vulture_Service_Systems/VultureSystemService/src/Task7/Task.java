package Task7;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task {
	
	private int taskId;
	private String task_type;
	private String task_desc;
	private String task_startDate;
	private String task_endDate;
	private String task_status;
	private LocalDate task_deadline;
	private int remainingDays;
	public String notes;
	private int motor_id;
	protected Technician tech; // declare tech inside task class
	
	/***Create an empty constructor***/
	public Task() {
		this.taskId = 0;
		this.task_type = null;
		this.task_desc = null;
		this.task_startDate = null;
		this.task_status = null;
		this.task_deadline = null;
		this.remainingDays=0;
		this.task_endDate=null;
		this.notes=null;
		this.tech=null;
		this.motor_id=0;
        
	}

	public Task(int taskId, String task_type, String task_desc, String task_startDate,String task_endDate, String task_status,
			LocalDate task_deadline, int newRemainingDays, String notes, Technician newTech, int motor_id) {
		this.taskId = taskId;
		this.task_type = task_type;
		this.task_desc = task_desc;
		this.task_startDate = task_startDate;
		this.task_status = task_status;
		this.task_deadline = task_deadline;
		this.remainingDays=newRemainingDays;
		this.task_endDate=task_endDate;
		this.notes=notes;
		this.tech= newTech;
		this.motor_id=motor_id;
	}

	public int getMotor_id() {
		return motor_id;
	}

	public void setMotor_id(int motor_id) {
		this.motor_id = motor_id;
	}

	/***Getters&Settters***/
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
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

	public String getTask_startDate() {
		return task_startDate;
	}

	public void setTask_startDate(String task_startDate) {
		this.task_startDate = task_startDate;
	}
	
	public String getTask_endDate() {
		return task_endDate;
	}

	public void setTask_endDate(String task_endDate) {
		this.task_endDate = task_endDate;
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
