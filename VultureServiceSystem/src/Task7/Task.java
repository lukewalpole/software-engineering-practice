package Task7;

import java.util.Objects;

public class Task {
	
	private int taskId;
	private String task_type;
	private String task_desc;
	private String task_startDate;
	private String task_status;
	private String task_deadline;
	private Technician tech;
	
	
	public Task() {
		this.taskId = 0;
		this.task_type = null;
		this.task_desc = null;
		this.task_startDate = null;
		this.task_status = null;
		this.task_deadline = null;
		tech=null;
	}

	public Task(int taskId, String task_type, String task_desc, String task_startDate, String task_status,
			String task_deadline) {
		this.taskId = taskId;
		this.task_type = task_type;
		this.task_desc = task_desc;
		this.task_startDate = task_startDate;
		this.task_status = task_status;
		this.task_deadline = task_deadline;
		this.tech= new Technician();
	}

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

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getTask_deadline() {
		return task_deadline;
	}

	public void setTask_deadline(String task_deadline) {
		this.task_deadline = task_deadline;
	}
	
	public Technician getTech() {
		return tech;
	}
	
	public void setTech(Technician techX) {
		this.tech=techX;
	}
	
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
