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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class delayDialog extends JDialog {
	private JTable table;
	VSSApp motorHandler;
	
	public delayDialog(VSSApp themotorHandler) {
		motorHandler= themotorHandler;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton btnSuspend = new JButton("Suspend");
					btnSuspend.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// Find the student in the selected row.
							int rowToDelete = table.getSelectedRow();
							
							// If row is selected, delete it
							if(rowToDelete>=0) {
								int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
								motorHandler.suspendTask(nameToDelete);
						}
						}
					});
					{
						JButton btnSendAlerts = new JButton("Send Alerts");
						btnSendAlerts.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								alertDialog dialog = new alertDialog();
								dialog.setVisible(true);
								int rowToDelete = table.getSelectedRow();
								
								// If row is selected, delete it
								if(rowToDelete>=0) {
									int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
									motorHandler.sendAlerts(nameToDelete);
							}
							}
						});
						buttonPane.add(btnSendAlerts);
					}
					buttonPane.add(btnSuspend);
				}
				{
					JButton btnResume = new JButton("Resume");
					btnResume.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// Find the student in the selected row.
							int rowToDelete = table.getSelectedRow();
							
							// If row is selected, delete it
							if(rowToDelete>=0) {
								int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
								motorHandler.resumeTask(nameToDelete);
							}
						}
					});
					buttonPane.add(btnResume);
				}
				{
					JButton btnComplete = new JButton("Complete");
					btnComplete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// Find the student in the selected row.
							int rowToDelete = table.getSelectedRow();
							
							// If row is selected, delete it
							if(rowToDelete>=0) {
								int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
								motorHandler.completeTask(nameToDelete);
							}
						}
					});
					buttonPane.add(btnComplete);
				}
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
						"Task ID", "Type", "Start Date", "End Date", "Status", "Deadline"
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
					s.getTask_type(),
					s.getTask_startDate(),
					s.getTask_endDate(),
					s.getTask_status(),
					s.getTask_deadline()});
		}
	}
	
}
