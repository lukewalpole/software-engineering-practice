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

public class newMotorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField nameField;
	public JTextField manuField;
	public JTextField clientField;
	public JTextField descField;
	public JTextField faultField;
	public JTextField startField;
	public JTextField endField;
	public JTextField durationField;
	public JTextField estField;
	public JTextField statusField;
	public JTextField delayField;
	public JTextField repField;
	public JTextField notesField;

	public newMotorDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 2, 0, 0));
		{
			JLabel lblNewLabel_2 = new JLabel("New Motor");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel = new JLabel("Motor Name");
			contentPanel.add(lblNewLabel);
		}
		{
			nameField = new JTextField();
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		{
			JLabel lblNewLabel4 = new JLabel("Manufacturer");
			contentPanel.add(lblNewLabel4);
		}
		{
			manuField = new JTextField();
			contentPanel.add(manuField);
			manuField.setColumns(10);
		}
		{
			JLabel lblNewLabel5 = new JLabel("Client");
			contentPanel.add(lblNewLabel5);
		}
		{
			clientField = new JTextField();
			contentPanel.add(clientField);
			clientField.setColumns(10);
		}
		{
			JLabel lblNewLabel6 = new JLabel("Description");
			contentPanel.add(lblNewLabel6);
		}
		{
			descField = new JTextField();
			contentPanel.add(descField);
			descField.setColumns(10);
		}
		{
			JLabel lblNewLabel7 = new JLabel("Fault");
			contentPanel.add(lblNewLabel7);
		}
		{
			faultField = new JTextField();
			contentPanel.add(faultField);
			faultField.setColumns(10);
		}
		{
			JLabel lblNewLabel8 = new JLabel("Start Date");
			contentPanel.add(lblNewLabel8);
		}
		{
			startField = new JTextField();
			contentPanel.add(startField);
			startField.setColumns(10);
		}
		{
			JLabel lblNewLabel9 = new JLabel("End Date");
			contentPanel.add(lblNewLabel9);
		}
		{
			endField = new JTextField();
			contentPanel.add(endField);
			endField.setColumns(10);
		}
		{
			JLabel lblNewLabel10 = new JLabel("Duration");
			contentPanel.add(lblNewLabel10);
		}
		{
			durationField = new JTextField();
			contentPanel.add(durationField);
			durationField.setColumns(10);
		}
		{
			JLabel lblNewLabel16 = new JLabel("Estimated Completion");
			contentPanel.add(lblNewLabel16);
		}
		{
			estField = new JTextField();
			contentPanel.add(estField);
			estField.setColumns(10);
		}
		{
			JLabel lblNewLabel12 = new JLabel("Status");
			contentPanel.add(lblNewLabel12);
		}
		{
			statusField = new JTextField();
			contentPanel.add(statusField);
			statusField.setColumns(10);
		}
		{
			JLabel lblNewLabel13 = new JLabel("Delay");
			contentPanel.add(lblNewLabel13);
		}
		{
			delayField = new JTextField();
			contentPanel.add(delayField);
			delayField.setColumns(10);
		}
		{
			JLabel lblNewLabel14 = new JLabel("Replacement Parts");
			contentPanel.add(lblNewLabel14);
		}
		{
			repField = new JTextField();
			contentPanel.add(repField);
			repField.setColumns(10);
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
						nameField.setText("");
						manuField.setText("");
						clientField.setText("");
						descField.setText("");
						faultField.setText("");
						startField.setText("");
						endField.setText("");
						durationField.setText("");
						statusField.setText("");
						delayField.setText("");
						repField.setText("");
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
