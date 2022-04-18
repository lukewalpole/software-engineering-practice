package task5and9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class newInspectionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField userID;
	public JTextField motorID;
	public JTextField inspecResult;
	public JTextField inspectionDate;
	public JTextField notesField;
	
	
	public newInspectionDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 2, 0, 0));
		{
			JLabel lblNewLabel_2 = new JLabel("New Inspection");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel1 = new JLabel("User ID");
			contentPanel.add(lblNewLabel1);
		}
		{
			userID = new JTextField();
			contentPanel.add(userID);
			userID.setColumns(10);
		}
		{
			JLabel lblNewLabel2 = new JLabel("Motor ID");
			contentPanel.add(lblNewLabel2);
		}
		{
			motorID = new JTextField();
			contentPanel.add(motorID);
			motorID.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Inspection Result");
			contentPanel.add(lblNewLabel);
		}
		{
			inspecResult = new JTextField();
			contentPanel.add(inspecResult);
			inspecResult.setColumns(10);
		}
		{
			JLabel lblNewLabel4 = new JLabel("Inspection Date");
			contentPanel.add(lblNewLabel4);
		}
		{
			inspectionDate = new JTextField();
			contentPanel.add(inspectionDate);
			inspectionDate.setColumns(10);
		}
		
		{
			JLabel lblNewLabel15 = new JLabel("Notes");
			contentPanel.add(lblNewLabel15);
		}
		{
			notesField = new JTextField();
			contentPanel.add(notesField);
			notesField.setColumns(10);
		}

	
	
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 setModal(false);
				         dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inspecResult.setText("");
						inspectionDate.setText("");
						notesField.setText("");
						 setModal(false);
				         dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}