package task5and9;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Task7.Task;
import task10.statisticsDialog;

import java.text.DateFormat;
//import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VSSGUI extends JFrame {

	//private DateFormat formatter;
	private JPanel contentPane;
	VSSApp motorHandler;
	

	private static final long serialVersionUID = 1L;
	
	private JTable motorTable;
	
	private VSSDatabase data;
	
	private Motor motor;
	
	public VSSGUI(VSSApp themotorHandler) {
		data = new VSSDatabase();
		
		motor = new Motor();
		
		//formatter = new SimpleDateFormat("yyyy-MM-dd");
		 motorHandler= themotorHandler;
		 
		
		 setBackground(Color.GREEN);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 734, 551);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("Filter");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("New");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMotorStatus("New");
				}
			});
			mnNewMenu.add(mntmNewMenuItem);
			
			JMenuItem mntmFilterItem = new JMenuItem("In Progress");
			mntmFilterItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMotorStatus("In Progress");
				}
			});
			mnNewMenu.add(mntmFilterItem);
			
			JMenuItem mntmCompleteItem = new JMenuItem("Complete");
			mntmCompleteItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayMotorStatus("Complete");
				}
			});
			mnNewMenu.add(mntmCompleteItem);
			
			
			
			// set motor statuses 
			JMenu mnHelpMenu = new JMenu("Set Status");
			menuBar.add(mnHelpMenu);
			
			JMenuItem mntmSetNewMenuItem = new JMenuItem("New");
			mntmSetNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow= motorTable.getSelectedRow();
					if(selectedRow>=0) {
						//int taskID=(int)motorTable.getValueAt(selectedRow, 0);
						String taskID= (String) motorTable.getValueAt(selectedRow, 0);
						data.updateMotorStatus(taskID, "New");
						displayTableData(data.GetAllMotors());
						motor.setStatus("New");
					}
				}
			});
			mnHelpMenu.add(mntmSetNewMenuItem);
			
			JMenuItem mntmSetInProgress = new JMenuItem("In Progress");
			mntmSetInProgress.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow= motorTable.getSelectedRow();
					if(selectedRow>=0) {
						//int taskID= (int)motorTable.getValueAt(selectedRow, 0);
						String taskID= (String) motorTable.getValueAt(selectedRow, 0);
						data.updateMotorStatus(taskID, "In Progress");
						displayTableData(data.GetAllMotors());
						motor.setStatus("In Progress");
					}
				}
			});
			mnHelpMenu.add(mntmSetInProgress);
			
			JMenuItem mntmSetComplete = new JMenuItem("Complete");
			mntmSetComplete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow= motorTable.getSelectedRow();
						if(selectedRow>=0) {
							//int taskID= (int)motorTable.getValueAt(selectedRow, 0);
							String taskID= (String) motorTable.getValueAt(selectedRow, 0);
							data.updateMotorStatus(taskID, "Complete");
							displayTableData(data.GetAllMotors());
							motor.setStatus("Complete");
						}
					}
			});
			mnHelpMenu.add(mntmSetComplete);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel bottomPanel = new JPanel();
			contentPane.add(bottomPanel, BorderLayout.SOUTH);
			
			
			JButton btnNewMotor = new JButton("Add Motor");
			btnNewMotor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Show the dialog
					newMotorDialog dialog = new newMotorDialog();
					dialog.setVisible(true);
					
					// Get the name from the dialog
					String newMotorName = dialog.nameField.getText();
					
					// If the name is empty, then Cancel was probably pressed
					if(!newMotorName.isEmpty()){
						// Get the rest from the fields
						String manufacturer;
						String client;
						String desc;
						String fault;
						String startDate;
						String endDate;
						int duration;
						String estimatedCompletion;
						String status;
						boolean delay;
						String replace;
						String notes;
						
						
						 manufacturer="";
						 client="";
						 desc="";
						 fault="";
						 startDate= "";
						 endDate="";
						 duration=0;
						 estimatedCompletion="";
						 status="New";
						 delay=false;
						 replace="";
						 notes="";
						 
						 
						try {
							 manufacturer = dialog.manuField.getText();
							 client = dialog.clientField.getText();
							 desc = dialog.descField.getText();
							 fault = dialog.faultField.getText();
								//startDate = dialog.startField.getText();
								//endDate = dialog.endField.getText();
								//duration = Integer.parseInt(dialog.durationField.getText());
								estimatedCompletion = dialog.estField.getText();
							 //status = dialog.statusField.getText();
							 //delay = Boolean.parseBoolean(dialog.delayField.getText());
							 replace = dialog.repField.getText();
							 notes = dialog.notesField.getText();
							 //System.out.println(manufacturer+client+desc+fault+ startDate+endDate+duration+estimatedCompletion+status+delay+replace+notes);
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
						}
						
						motorHandler.addMotor(newMotorName,
								manufacturer,
								 client,
								 desc,
								 fault,
								 
								 
								 
								 estimatedCompletion,
								 
								 status,
								 replace,
								notes);	
					}
					

				}
			});
			bottomPanel.add(btnNewMotor);
			
			JButton btnEditMotor = new JButton("Update Motor");
			btnEditMotor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Find the motor in the selected row.
					int rowToChange = motorTable.getSelectedRow();
					
					
					if(rowToChange>=0) {
						changeMotorDialog dialog = new changeMotorDialog();
						dialog.lblMotorNameLabel.setText((String) motorTable.getValueAt(rowToChange, 0));
						dialog.setVisible(true);
				
						String manufacturer;
						String client;
						String desc;
						String fault;
						String startDate;
						String endDate;
						int duration;
						String estimatedCompletion;
						String status;
						boolean delay;
						String replace;
						String notes;
						
						
						 manufacturer="";
						 client="";
						 desc="";
						 fault="";
						 startDate= "";
						 endDate="";
						 duration=0;
						 estimatedCompletion="";
						 status="";
						 delay=false;
						 replace="";
						 notes="";
						 
						 
						try {
							manufacturer = dialog.manuField.getText();
							 client = dialog.clientField.getText();
							 desc = dialog.descField.getText();
							 fault = dialog.faultField.getText();
								//startDate = dialog.startField.getText();
								//endDate = dialog.endField.getText();
							 //duration = Integer.parseInt(dialog.durationField.getText());						 
								estimatedCompletion = dialog.estField.getText();
							 //status = dialog.statusField.getText();
							 //delay = Boolean.parseBoolean(dialog.delayField.getText());
							 replace = dialog.repField.getText();
							 notes = dialog.notesField.getText();
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
						}
			
						
							motorHandler.updateMotor((String) motorTable.getValueAt(rowToChange, 0),
									
									manufacturer,
									 client,
									 desc,
									 fault,
									
									 
									 
									 estimatedCompletion,
									 
									 
									 replace,
									notes);
						
					}
				
				}
			});
			bottomPanel.add(btnEditMotor);
			
			JButton btnDeleteMotor = new JButton("Delete Motor");
			btnDeleteMotor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Find the student in the selected row.
					int rowToDelete = motorTable.getSelectedRow();
					
					// If row is selected, delete it
					if(rowToDelete>=0) {
						String nameToDelete = (String) motorTable.getValueAt(rowToDelete, 0);
						motorHandler.deleteMotor(nameToDelete);
					}
				}

			});
			bottomPanel.add(btnDeleteMotor);
			
			JButton btnInspection = new JButton("Inspections");
			btnInspection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Show the dialog
					allInspectionDialog dialog = new allInspectionDialog(themotorHandler);
					dialog.setVisible(true);
					dialog.displayTableData(data.GetAllInspections());

				}
			});
			bottomPanel.add(btnInspection);
			
			JButton btnTasks = new JButton("Tasks");
			btnTasks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					allTaskDialog dialog = new allTaskDialog(themotorHandler);
					dialog.setVisible(true);
					dialog.displayTableData(data.GetAllTasks());
				}
			});
			bottomPanel.add(btnTasks);
			
			JButton btnDelays = new JButton("Delays");
			btnDelays.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delayDialog dialog = new delayDialog(themotorHandler);
					dialog.setVisible(true);
					dialog.displayTableData(data.GetAllRemainingTasks());
				}
			});
			bottomPanel.add(btnDelays);
			
			JButton btnStatistics = new JButton("Statistics");
			btnStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					statisticsDialog dialog = new statisticsDialog(themotorHandler);
					dialog.setVisible(true);
					//dialog.displayTableData(data.GetAllRemainingTasks());
				}
			});
			bottomPanel.add(btnStatistics);
			
			JPanel topPanel = new JPanel();
			contentPane.add(topPanel, BorderLayout.NORTH);
			topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel topLabel = new JLabel("Motors");
			topLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			topPanel.add(topLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			
			motorTable = new JTable();
			motorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			motorTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Motor Name", "Manufacturer", "Client","Description","Fault","Start Date","End Date",
					"Duration","Estimated Completion","Status","Delay","Replacement","Notes"
				}
			));
			motorTable.getColumnModel().getColumn(0).setPreferredWidth(250);
			scrollPane.setViewportView(motorTable);
		}
		
		void displayTableData(ArrayList<Motor> tableData){
			
			// Empty the existing data
			DefaultTableModel tableModel = (DefaultTableModel) motorTable.getModel();
			tableModel.setRowCount(0);
			
			// Some safety code missing here
			for(Motor s: tableData) {
				tableModel.addRow(new Object[] {s.getMotorName(),
						s.getMotorManufacturer(),
						s.getClient(),
						s.getDesc(),
						s.getFault(),
						s.getStartDate(),
						s.getEndDate(),
						s.getDuration(),
						s.getEstimatedCompletion(),
						s.getStatus(),
						s.getDelay(),
						s.getRep(),
						s.getNotes()});
			}
		}
			
		//display motor status
		void displayMotorStatus(String status) {
			  DefaultTableModel tableModel = (DefaultTableModel) motorTable.getModel();
			  tableModel.setRowCount(0);
			  for(Motor t:data.GetAllMotors()) {
				 //if the parameter matches any of the tasks with that status, then display the tasks
				  if(t.getStatus().equals(status)) {
							
								tableModel.addRow(new Object[] {t.getMotorName(),
										t.getMotorManufacturer(),
										t.getClient(),
										t.getDesc(),
										t.getFault(),
										t.getStartDate(),
										t.getEndDate(),
										t.getDuration(),
										t.getEstimatedCompletion(),
										t.getStatus(),
										t.getDelay(),
										t.getRep(),
										t.getNotes()});
							}
					 }
				 
			  }
		}
	


