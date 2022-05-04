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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
//import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class allInspectionDialog extends JDialog {
	private JTable table;
	private DateFormat formatter;
	VSSApp motorHandler;
	


	public allInspectionDialog(VSSApp themotorHandler) {
		
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 motorHandler= themotorHandler;
		 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAddInspection = new JButton("Add Inspection");
				btnAddInspection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newInspectionDialog dialog = new newInspectionDialog();
						dialog.setVisible(true);
						
						// Get the name from the dialog
						String newInspecResult = dialog.inspecResult.getText();
						
						// If the name is empty, then Cancel was probably pressed
						if(!newInspecResult.isEmpty()){
							// Get the rest from the fields
							int userID;
							int motorID;
							String inspecResult;
							String inspecDate;
							String notes;
							
							userID=0;
							motorID=0;
							inspecResult="";
							inspecDate="";
							 notes="";
							 
							  userID = Integer.parseInt(dialog.userID.getText());
							  motorID = Integer.parseInt(dialog.motorID.getText());
								inspecResult = dialog.inspecResult.getText();
									 inspecDate = dialog.inspectionDate.getText();								 
								 notes = dialog.notesField.getText();
							
							motorHandler.addInspec(userID, motorID,inspecResult,
									inspecDate,
									notes);	
							
						}
						

					}
				});
				buttonPane.add(btnAddInspection);
				
				JButton btnDeleteMotor = new JButton("Delete Inspection");
				btnDeleteMotor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Find the student in the selected row.
						int rowToDelete = table.getSelectedRow();
						
						// If row is selected, delete it
						if(rowToDelete>=0) {
							int nameToDelete =(int) table.getValueAt(rowToDelete, 0);
							motorHandler.deleteInspec(nameToDelete);
						}
					}

				});
				buttonPane.add(btnDeleteMotor);
				
				
			}
			/*{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}*/
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
						"Inspection ID", "User ID", "Motor ID", "Result", "Date", "Notes"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
	}

	void displayTableData(ArrayList<Inspection> tableData){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for(Inspection s: tableData) {
			tableModel.addRow(new Object[] {s.getID(),
					s.getUserID(),
					s.getMotorID(),
					s.getInspecRes(),
					s.getInspecDate(),
					s.getNotes()});
		}
	}
	
}
