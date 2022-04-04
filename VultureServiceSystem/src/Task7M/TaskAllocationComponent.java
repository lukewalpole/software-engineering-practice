 package Task7M;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;

public class TaskAllocationComponent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int limitTaskLife;
	protected JTable table;
	protected TaskAllocationDataBase data;
	protected TaskAllocationApp app;
	


	/*** Connect the main window with TaskAllocationApp ***/
	public TaskAllocationComponent(TaskAllocationApp newApp) {
		setForeground(SystemColor.text);
		setBackground(new Color(0, 0, 0));
		app= newApp;
		data= new TaskAllocationDataBase(app.database);
		limitTaskLife=-30;
		setTitle("Task Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 846, 641);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnFilterMenu = new JMenu("Filter");
		menuBar.add(mnFilterMenu);
		
		JMenuItem mntmAllTasks = new JMenuItem("All");
		mntmAllTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTableData(data.getAllTasks());
			}
		});
		mnFilterMenu.add(mntmAllTasks);
		
		JMenuItem mntmHighPriorityTasks = new JMenuItem("High Priority");
		mntmHighPriorityTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				displayTaskStatus("High Priority"); // display all High Priority Tasks
			}
		});
		mnFilterMenu.add(mntmHighPriorityTasks);
		
		JMenuItem mntmInProgressTask = new JMenuItem("In Progress");// display In Progress tasks
		mntmInProgressTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTaskStatus("In Progress");
			}
		});
		
		JMenuItem mntmNormalPriority = new JMenuItem("Normal Priority");// display Normal Priority tasks
		mntmNormalPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTaskStatus("Normal Priority");
			}
		});
		mnFilterMenu.add(mntmNormalPriority);
		mnFilterMenu.add(mntmInProgressTask);
		
		JMenuItem mntmCompleted = new JMenuItem("Completed");// display Completed tasks
		mntmCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTaskStatus("Completed");
			}
		});
		mnFilterMenu.add(mntmCompleted);
		
		JMenuItem mntmAssignedTasks = new JMenuItem("Assigned");// display assigned tasks
		mntmAssignedTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				 tableModel.setRowCount(0);
				for(Task t:data.getAllTasks()) {
					if(t.getRemainingDays()>=limitTaskLife){ // display the tasks younger than 31 days
						if(!(t.getTech()==null)) {
						 tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(), t.getTech().getFirstName()+" "+t.getTech().getLastName()});
						}
					}
				}
			}
		});
		mnFilterMenu.add(mntmAssignedTasks);
		
		JMenuItem mntmUnassignedTasks = new JMenuItem("Unassigned");// display Unassigned tasks
		mntmUnassignedTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				 tableModel.setRowCount(0);
				for(Task t:data.getAllTasks()) {
					if(t.getRemainingDays()>=limitTaskLife){ // display the tasks younger than 31 days
						if(t.getTech()==null) {
						 tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(),  " "});
						}
					}
				}
			}
		});
		mnFilterMenu.add(mntmUnassignedTasks);
		
		JMenuItem mntmOverdueItem = new JMenuItem("Overdue");// display Overdue tasks
		mntmOverdueItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			  tableModel.setRowCount(0);
			  for(Task t:data.getAllTasks()) {
				  if(t.getRemainingDays()>=limitTaskLife){ // display the tasks younger than 31 days
				  if(t.getRemainingDays()<0) {
					  if(t.getTech()!=null) {
							tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(),  t.getTech().getFirstName()+" "+t.getTech().getLastName()});
						    }
							else {
							tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(), " "});
						}
					 }
				 }
			  }
			}
		});
		mnFilterMenu.add(mntmOverdueItem);
		
		JMenu mnSetStatusMenu = new JMenu("Set Status");// set the status
		menuBar.add(mnSetStatusMenu);
		
		JMenuItem mntmHighPriority2 = new JMenuItem("High Priority"); // set task status to High Priority
		mntmHighPriority2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= table.getSelectedRow();
				if(selectedRow>=0) {
					int taskID= (int)table.getValueAt(selectedRow, 0);
					data.updateTaskStatus(taskID, "High Priority");
					displayTableData(data.getAllTasks());
				}
			}
		});
		mnSetStatusMenu.add(mntmHighPriority2);
		
		JMenuItem mntmNormalPriority2 = new JMenuItem("Normal Priority");// set task status to Normal Priority
		mntmNormalPriority2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= table.getSelectedRow();
				if(selectedRow>=0) {
					int taskID= (int)table.getValueAt(selectedRow, 0);
					data.updateTaskStatus(taskID, "Normal Priority");
					displayTableData(data.getAllTasks());
				}
			}
		});
		mnSetStatusMenu.add(mntmNormalPriority2);
		
		JMenuItem mntmInProgress2 = new JMenuItem("In Progress");// set task status to In Progress
		mntmInProgress2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= table.getSelectedRow();
				if(selectedRow>=0) {
					int taskID= (int)table.getValueAt(selectedRow, 0);
					data.updateTaskStatus(taskID, "In Progress");
					displayTableData(data.getAllTasks());
				}
			}
		});
		mnSetStatusMenu.add(mntmInProgress2);
		
		JMenuItem mntmCompleted2 = new JMenuItem("Completed");// set task status to Completed
		mntmCompleted2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= table.getSelectedRow();
				if(selectedRow>=0) {
					int taskID= (int)table.getValueAt(selectedRow, 0);
					data.updateTaskStatus(taskID, "Completed");
					displayTableData(data.getAllTasks());
				}
			}
		});
		mnSetStatusMenu.add(mntmCompleted2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonPanelSouth = new JPanel();
		buttonPanelSouth.setBackground(new Color(0, 0, 0));
		contentPane.add(buttonPanelSouth, BorderLayout.SOUTH);
		
		JButton btnDescriptionButton = new JButton("Description"); // display description of each task
		btnDescriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowToShow= table.getSelectedRow();
				if(rowToShow>=0) {
						for(Task s:data.getAllTasks()){
						
							if(((int)table.getValueAt(rowToShow, 0))== s.getTaskId()) {
							
			                TaskDescription taskDescription= new TaskDescription();
			                taskDescription.txtrDisplayDesc.setText(s.getTask_desc());
							taskDescription.setVisible(true);	
						}	
					}
				}
			}
		});
		buttonPanelSouth.add(btnDescriptionButton);
		
		JButton btnAssignButton = new JButton("Assign Tech");//Assigning a technician
		btnAssignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				//set the assign tech dialog visible once the button is pressed
				int rowToShow= table.getSelectedRow();
				if(rowToShow>=0) {
					AssignTechDialog techDialog = new AssignTechDialog(app);
					techDialog.setVisible(true);
					//pass the value at the selected row and column 0 to the AssignTechDialog Class
					techDialog.taskID=(int)table.getValueAt(rowToShow, 0);
				}
               }	
			});
		
		buttonPanelSouth.add(btnAssignButton);
		
		
		JButton btnRemoveButton = new JButton("Remove Tech");// remove technician from a task
		btnRemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= table.getSelectedRow();
				if(selectedRow>=0) {
					int selectedTaskID=(int)table.getValueAt(selectedRow, 0);
					for(Task t:data.getAllTasks()) {
						if(t.getTaskId()==selectedTaskID) {
						app.removeTech(selectedTaskID);
						}
					}
					
 				}
			}
		});
		buttonPanelSouth.add(btnRemoveButton);
		
		JButton btnAutoAssign = new JButton("Auto-Assign"); // assigned technicians automatically 
		btnAutoAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				for(Task t:data.getAllTasks()) {
	                	app.updateTechList(t.getTaskId(), data.getAllTech().get(i).getTech_id());
	                	i++;
	                	if(i>data.getAllTech().size()-1) {
	                		
	                		i=0;
	                	}
	                	
	                }
			}
		});
		buttonPanelSouth.add(btnAutoAssign);
		
		JButton btnTechTaskButton = new JButton("Tech/Task"); // display the Technician/Task schedule
		btnTechTaskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				AssignedTechFilter atf=new AssignedTechFilter(app);
				atf.setVisible(true);
				}catch(Exception m) {
					m.printStackTrace();
					System.out.println("Error: "+m.getMessage());
				}
			}
		});
		buttonPanelSouth.add(btnTechTaskButton);
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(0, 0, 0));
		northPanel.setForeground(Color.BLACK);
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("List Of Tasks");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setForeground(Color.BLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TaskID", "Task", "Status", "Deadline", "Days", "Tech"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(26);
		scrollPane.setViewportView(table);
	}
	/** Display the data **/
	void displayTableData(ArrayList<Task> tableData){
		
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for( Task s: tableData) {
			if(s.getRemainingDays()>=limitTaskLife){ // display the tasks younger than 31 days
				if(s.getTech()!=(null)) {
				tableModel.addRow(new Object[] {s.getTaskId(), s.getTask_type(), s.getTask_status(), s.getTask_deadline(), s.getRemainingDays(),  s.getTech().getFirstName()+" "+s.getTech().getLastName()});
			    }
				else {
					tableModel.addRow(new Object[] {s.getTaskId(), s.getTask_type(), s.getTask_status(), s.getTask_deadline(), s.getRemainingDays(), " "});
				
				}
			}
		}	
	}
	
	void displayTaskStatus(String status) {
		  DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		  tableModel.setRowCount(0);
		  for(Task t:data.getAllTasks()) {
			 if(t.getRemainingDays()>=limitTaskLife){ // display the tasks younger than 31 days
			  if(t.getTask_status().equals(status)) {
				  if(t.getTech()!=null) {
						tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(),  t.getTech().getFirstName()+" "+t.getTech().getLastName()});
					    }
						else {
							tableModel.addRow(new Object[] {t.getTaskId(), t.getTask_type(), t.getTask_status(), t.getTask_deadline(), t.getRemainingDays(), " "});
						}
				 }
			 }
		  }
	}

}
