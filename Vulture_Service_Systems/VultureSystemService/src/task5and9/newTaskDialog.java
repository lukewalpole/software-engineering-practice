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

public class newTaskDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField motorID;
	//public JTextField tech;
	public JTextField taskType;
	public JTextField taskDesc;
	public JTextField taskStatus;
	public JTextField taskDeadline;
	public JTextField notesField;
	
	
	public newTaskDialog() {
		setTitle("Add Task");
		setModal(true);
		
		setBounds(100, 100, 921, 530);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 890, 440);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
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
			JLabel lblNewLabel6 = new JLabel("Task Type");
			contentPanel.add(lblNewLabel6);
		}
		{
			taskType = new JTextField();
			contentPanel.add(taskType);
			taskType.setColumns(10);
		}
		
		{
			JLabel lblNewLabel4 = new JLabel("Task Description");
			contentPanel.add(lblNewLabel4);
		}
		{
			taskDesc = new JTextField();
			contentPanel.add(taskDesc);
			taskDesc.setColumns(10);
		}
		
		{
			JLabel lblNewLabel9 = new JLabel("Status");
			contentPanel.add(lblNewLabel9);
		}
		{
			taskStatus = new JTextField();
			contentPanel.add(taskStatus);
			taskStatus.setColumns(10);
		}
		
		{
			JLabel lblNewLabel10 = new JLabel("Deadline");
			contentPanel.add(lblNewLabel10);
		}
		{
			taskDeadline = new JTextField();
			contentPanel.add(taskDeadline);
			taskDeadline.setColumns(10);
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
		
		
		/*{
			JLabel lblNewLabel = new JLabel("Tech");
			contentPanel.add(lblNewLabel);
		}
		{
			tech = new JTextField();
			contentPanel.add(tech);
			tech.setColumns(10);
		}*/
		
		{

	
	
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 451, 912, 33);
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 setModal(false);
				         dispose();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//userID.setText("");
						motorID.setText("");
						//tech.setText("");
						taskType.setText("");
						taskDesc.setText("");
						taskStatus.setText("");
						taskDeadline.setText("");
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
}
