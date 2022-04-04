package Task7M;


public class TaskAllocationApp {

	
	public static void main(String[] args) {
		
	  new TaskAllocationApp();
	  

	}
	
	protected TaskAllocationComponent theMainWindow;
	protected DBConnection database;
	protected TaskAllocationDataBase data;
	
	
	public TaskAllocationApp() {
		/**Crete database connection to avoid multiple connections**/
		database= new DBConnection();
		database.Connect("D:\\sqlite-tools-win32-x86-3370200\\sqlite-tools-win32-x86-3370200\\newDB2.db");
		
		/**pass the database connection variable to the DB execution class to execute queries**/
		data= new TaskAllocationDataBase(database);
		
		/**define and connect the TaskAllocationComponent to TaskAllocationApp**/
		theMainWindow= new TaskAllocationComponent(this);
		theMainWindow.setVisible(true);
		theMainWindow.displayTableData(data.getAllTasks());
	}
	
	/*** Assign a technician to a task ***/
	public  void updateTechList(int taskID, int techID) {
		data.UpdateTech(taskID, techID);
	
		theMainWindow.displayTableData(data.getAllTasks());
	}
	
	/*** Remove a technician from a task ***/
	public void removeTech(int taskID) {
		data.RemoveTech(taskID);
		
		theMainWindow.displayTableData(data.getAllTasks());
	}
	

	
}
