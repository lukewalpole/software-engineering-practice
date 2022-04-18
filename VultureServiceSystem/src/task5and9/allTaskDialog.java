package task5and9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class allTaskDialog extends JDialog {
	private JTable table;
	private DateFormat formatter;
	VSSApp motorHandler;
	
	public allTaskDialog(VSSApp themotorHandler) {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		motorHandler= themotorHandler;
		
		setBounds(100, 100, 633, 410);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAddTask = new JButton("Add Task");
				btnAddTask.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newTaskDialog dialog = new newTaskDialog();
						dialog.setVisible(true);
						
						// Get the name from the dialog
						String taskType = dialog.taskType.getText();
						
						// If the name is empty, then Cancel was probably pressed
						if(!taskType.isEmpty()){
							// Get the rest from the fields
							int userID=0;
							int motorID=0;
							//String tech="";
							String tasktype="";
							String taskDesc="";
							String taskStart="";
							String taskEnd="";
							String taskStatus="";
							String taskDeadline = "";
							String notes="";
							
							 
							try {
								userID = Integer.parseInt(dialog.userID.getText());
								  motorID = Integer.parseInt(dialog.motorID.getText());
								 // tech = dialog.tech.getText();
								  tasktype = dialog.taskType.getText();
								  taskDesc = dialog.taskDesc.getText();
								  taskStart = dialog.taskStart.getText();
								  taskEnd = dialog.taskEnd.getText();
								  taskStatus = dialog.taskStatus.getText();
								 taskDeadline = dialog.taskDeadline.getText();
								 notes = dialog.notesField.getText();
							} catch (NumberFormatException ex) {
								ex.printStackTrace();
							}
							
							motorHandler.addTask(userID,
									motorID,
									//tech,
									tasktype,
									taskDesc,
									taskStart,
									taskEnd,
									taskStatus,
									taskDeadline,
									notes);	
							
						}
						

					}
				});
				buttonPane.add(btnAddTask);
			}
			{
				JButton btnDeleteTask = new JButton("Delete Task");
				btnDeleteTask.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Find the student in the selected row.
						int rowToDelete = table.getSelectedRow();
						
						// If row is selected, delete it
						if(rowToDelete>=0) {
							int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
							motorHandler.deleteTask(nameToDelete);
						}
					}

				});
				buttonPane.add(btnDeleteTask);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Task ID","User ID","Motor ID", "Tech ID", "Task Type", "Description", "Start Date", "End Date", "Status", "Deadline", "Notes"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
	}

	
void displayTableData(ArrayList<Task> tableData){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for(Task s: tableData) {
			tableModel.addRow(new Object[] {s.getTaskId(),
					s.getUserID(),
					s.getMotorID(),
					s.getTech(),
					s.getTask_type(),
					s.getTask_desc(),
					s.getTask_startDate(),
					s.getTask_endDate(),
					s.getTask_status(),
					s.getTask_deadline(),
					s.getNotes()});
		}
	}
	
	
}
