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

public class newTaskDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField userID;
	public JTextField motorID;
	//public JTextField tech;
	public JTextField taskType;
	public JTextField taskDesc;
	public JTextField taskStart;
	public JTextField taskEnd;
	public JTextField taskStatus;
	public JTextField taskDeadline;
	public JTextField notesField;
	
	
	public newTaskDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 2, 0, 0));
		{
			JLabel lblNewLabel_2 = new JLabel("New Task");
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
			JLabel lblNewLabel7 = new JLabel("Start Date");
			contentPanel.add(lblNewLabel7);
		}
		{
			taskStart = new JTextField();
			contentPanel.add(taskStart);
			taskStart.setColumns(10);
		}
		
		{
			JLabel lblNewLabel8 = new JLabel("End Date");
			contentPanel.add(lblNewLabel8);
		}
		{
			taskEnd = new JTextField();
			contentPanel.add(taskEnd);
			taskEnd.setColumns(10);
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
						userID.setText("");
						motorID.setText("");
						//tech.setText("");
						taskType.setText("");
						taskDesc.setText("");
						taskStart.setText("");
						taskEnd.setText("");
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
