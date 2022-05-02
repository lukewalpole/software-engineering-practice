package task5and9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class newMotorDialog extends JFrame {

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
		setTitle("New Motor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setModal(true);
		setBounds(100, 100, 419, 523);
		getContentPane().setLayout(null);
		contentPanel.setBounds(350, 127, 45, 192);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new GridLayout(4, 2, 0, 0));
		{
			notesField = new JTextField();
			notesField.setBounds(111, 424, 220, 20);
			getContentPane().add(notesField);
			notesField.setColumns(10);
		}
		{
			JLabel lblNewLabel15 = new JLabel("Notes");
			lblNewLabel15.setBounds(20, 421, 81, 26);
			getContentPane().add(lblNewLabel15);
		}
		{
			repField = new JTextField();
			repField.setBounds(111, 401, 220, 20);
			getContentPane().add(repField);
			repField.setColumns(10);
		}
		{
			JLabel lblNewLabel14 = new JLabel("Replacement Parts");
			lblNewLabel14.setBounds(10, 398, 94, 26);
			getContentPane().add(lblNewLabel14);
		}
		{
			delayField = new JTextField();
			delayField.setBounds(111, 378, 215, 20);
			getContentPane().add(delayField);
			delayField.setColumns(10);
		}
		{
			JLabel lblNewLabel13 = new JLabel("Delay");
			lblNewLabel13.setBounds(20, 378, 94, 20);
			getContentPane().add(lblNewLabel13);
		}
		{
			statusField = new JTextField();
			statusField.setBounds(111, 347, 215, 20);
			getContentPane().add(statusField);
			statusField.setColumns(10);
		}
		{
			JLabel lblNewLabel12 = new JLabel("Status");
			lblNewLabel12.setBounds(20, 347, 113, 20);
			getContentPane().add(lblNewLabel12);
		}
		{
			estField = new JTextField();
			estField.setBounds(141, 313, 185, 20);
			getContentPane().add(estField);
			estField.setColumns(10);
		}
		{
			JLabel lblNewLabel16 = new JLabel("Estimated Completion");
			lblNewLabel16.setBounds(10, 310, 110, 26);
			getContentPane().add(lblNewLabel16);
		}
		{
			durationField = new JTextField();
			durationField.setBounds(106, 282, 220, 20);
			getContentPane().add(durationField);
			durationField.setColumns(10);
		}
		{
			JLabel lblNewLabel10 = new JLabel("Duration");
			lblNewLabel10.setBounds(23, 282, 103, 20);
			getContentPane().add(lblNewLabel10);
		}
		{
			endField = new JTextField();
			endField.setBounds(111, 251, 215, 20);
			getContentPane().add(endField);
			endField.setColumns(10);
		}
		{
			JLabel lblNewLabel9 = new JLabel("End Date");
			lblNewLabel9.setBounds(23, 251, 98, 20);
			getContentPane().add(lblNewLabel9);
		}
		
			
			
				
				
				
				
				{
					JPanel buttonPane = new JPanel();
					buttonPane.setBounds(121, 449, 152, 37);
					getContentPane().add(buttonPane);
					buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
					{
						JButton okButton = new JButton("OK");
						okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								 //setModal(false);
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
								 //setModal(false);
						         dispose();
							}
						});
						cancelButton.setActionCommand("Cancel");
						buttonPane.add(cancelButton);
					}
				}
				{
					startField = new JTextField();
					startField.setBounds(111, 211, 215, 20);
					getContentPane().add(startField);
					startField.setColumns(10);
				}
				{
					JLabel lblNewLabel8 = new JLabel("Start Date");
					lblNewLabel8.setBounds(23, 212, 81, 18);
					getContentPane().add(lblNewLabel8);
				}
				{
					faultField = new JTextField();
					faultField.setBounds(106, 181, 220, 20);
					getContentPane().add(faultField);
					faultField.setColumns(10);
				}
				{
					JLabel lblNewLabel7 = new JLabel("Fault");
					lblNewLabel7.setBounds(23, 181, 68, 20);
					getContentPane().add(lblNewLabel7);
				}
				{
					JLabel lblNewLabel = new JLabel("Motor Name");
					lblNewLabel.setBounds(23, 42, 68, 20);
					getContentPane().add(lblNewLabel);
				}
				{
					nameField = new JTextField();
					nameField.setBounds(106, 42, 220, 20);
					getContentPane().add(nameField);
					nameField.setColumns(10);
				}
				{
					JLabel lblNewLabel4 = new JLabel("Manufacturer");
					lblNewLabel4.setBounds(23, 76, 98, 20);
					getContentPane().add(lblNewLabel4);
				}
				{
					manuField = new JTextField();
					manuField.setBounds(106, 73, 220, 20);
					getContentPane().add(manuField);
					manuField.setColumns(10);
				}
				{
					JLabel lblNewLabel5 = new JLabel("Client");
					lblNewLabel5.setBounds(23, 107, 81, 20);
					getContentPane().add(lblNewLabel5);
				}
				{
					clientField = new JTextField();
					clientField.setBounds(106, 102, 220, 20);
					getContentPane().add(clientField);
					clientField.setColumns(10);
				}
				{
					JLabel lblNewLabel6 = new JLabel("Description");
					lblNewLabel6.setBounds(23, 138, 94, 20);
					getContentPane().add(lblNewLabel6);
				}
				{
					descField = new JTextField();
					descField.setBounds(106, 138, 220, 20);
					getContentPane().add(descField);
					descField.setColumns(10);
				}
	}

}
