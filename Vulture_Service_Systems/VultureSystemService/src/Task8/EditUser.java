package Task8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldUsername;
	protected JTextField textFieldNewPassword;
	protected JTextField textFieldPassword;
	protected JTextField textFieldFirstName;
	protected JTextField textFieldLastName;
	protected JComboBox comboBoxUserJob;
	protected int userID;
    private LogInLauncher launcher;

	public EditUser(LogInLauncher newLauncher) {
        launcher= newLauncher;
		
		setTitle("Edit User");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblJobTitleLabel = new JLabel("Job Title");
			contentPanel.add(lblJobTitleLabel);
		}
		{
			comboBoxUserJob = new JComboBox();
			comboBoxUserJob.setModel(new DefaultComboBoxModel(new String[] {"Tech", "HR", "Cs"}));
			contentPanel.add(comboBoxUserJob);
		}
		{
			JLabel lblNewLabeFirstName = new JLabel("First Name");
			contentPanel.add(lblNewLabeFirstName);
		}
		{
			textFieldFirstName = new JTextField();
			contentPanel.add(textFieldFirstName);
			textFieldFirstName.setColumns(10);
		}
		{
			JLabel lblNewLabelLastName = new JLabel("Last Name");
			contentPanel.add(lblNewLabelLastName);
		}
		{
			textFieldLastName = new JTextField();
			contentPanel.add(textFieldLastName);
			textFieldLastName.setColumns(10);
		}
		{
			JLabel lblNewLabelUserName = new JLabel("Username");
			contentPanel.add(lblNewLabelUserName);
		}
		{
			textFieldUsername = new JTextField();
			contentPanel.add(textFieldUsername);
			textFieldUsername.setColumns(10);
		}
		{
			JLabel lblNewLabelPassword = new JLabel("Password");
			contentPanel.add(lblNewLabelPassword);
		}
		{
			textFieldPassword = new JTextField();
			contentPanel.add(textFieldPassword);
			textFieldPassword.setColumns(10);
		}
		{
			JLabel lblNewLabelNewPassword = new JLabel("Set New  Password");
			contentPanel.add(lblNewLabelNewPassword);
		}
		{
			textFieldNewPassword = new JTextField();
			contentPanel.add(textFieldNewPassword);
			textFieldNewPassword.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//Method to edit the user account info
				JButton okButton = new JButton("Edit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//retrieve the data passed from HRAccount
					  String username= textFieldUsername.getText();
					  String password= textFieldPassword.getText();
					  String newPassword= textFieldNewPassword.getText();
					  String jobTitle= (String) comboBoxUserJob.getItemAt(comboBoxUserJob.getSelectedIndex());
					  String firstName= textFieldFirstName.getText();
				      String lastName= textFieldLastName.getText();
				      
				      
				      //If the fields are empty when submitting, display a message dialog
				      if( username.isEmpty() ||password.isEmpty()|| jobTitle.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
				    	  JOptionPane.showMessageDialog(null, "Please complete all the fields!", "WARNING", JOptionPane.PLAIN_MESSAGE);
				    	  
				      } else {
                              //if new password field is empty, don't change the current password
						      if(!(newPassword.equals(""))) {
						    	  launcher.editUser(userID, username, newPassword, firstName, lastName, jobTitle);
						      }else {
						    	  //if the new password field is filled, change the password in DB
						          launcher.editUser(userID, username, password, firstName, lastName, jobTitle);
						      }
						      setModal(false);
						      dispose();
				         }
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
