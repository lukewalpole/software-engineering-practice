package task10;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import task5and9.VSSApp;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class statisticsDialog extends JDialog {
	VSSApp motorHandler;
	
	private final JPanel contentPanel = new JPanel();

	public statisticsDialog(VSSApp themotorHandler) {
		motorHandler= themotorHandler;
		setBounds(100, 100, 495, 85);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnJobDurationChart = new JButton("Job Duration Chart");
				btnJobDurationChart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
			            var ex = new JobCharts();
			            ex.setVisible(true);
					}
				});
				
				buttonPane.add(btnJobDurationChart);
			}
			{
				JButton btnTaskDurationChart = new JButton("Task Duration Chart");
				btnTaskDurationChart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						var ex = new taskCharts();
			            ex.setVisible(true);
					}
				});
				
				buttonPane.add(btnTaskDurationChart);
			}
			{
				JButton btnDelayChart = new JButton("Delay Frequency Chart");
				btnDelayChart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						var ex = new delayChart();
			            ex.setVisible(true);
					}
				});
				
				buttonPane.add(btnDelayChart);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
