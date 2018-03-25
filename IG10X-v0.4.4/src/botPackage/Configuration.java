package botPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Configuration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int rangeMin;
	private int rangeMax;
	private int confirmations;
	private int waveMin;
	private int waveMax;
	private String fpath;
	private int waitAttempts;
	private int waitTime;
	private String profileUrl;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	
	/**
	 * Create the frame.
	 */
	public Configuration(String osName,String botName,String loginMethod,String username,String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblConfiguration = new JLabel("Configuration");
		lblConfiguration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfiguration.setBounds(12, 13, 287, 16);
		contentPane.add(lblConfiguration);
		
		JLabel lblTimerangeGiven = new JLabel("Time range for two consicutive follow/unfollow (generated randomly)");
		lblTimerangeGiven.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimerangeGiven.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblTimerangeGiven.setBounds(12, 42, 408, 16);
		contentPane.add(lblTimerangeGiven);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMin.setBounds(22, 71, 56, 16);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMax.setBounds(142, 71, 56, 16);
		contentPane.add(lblMax);
		
		JLabel lblNumberOfConfirmations = new JLabel("Number of confirmations in one wave");
		lblNumberOfConfirmations.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfConfirmations.setToolTipText("wave means number of confirmations in bulk(depends on time range given above) before waiting for a longer period, as instagram may block you if too many requests are made in short period of time. ");
		lblNumberOfConfirmations.setBounds(12, 110, 287, 16);
		contentPane.add(lblNumberOfConfirmations);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(311, 110, 109, 16);
		contentPane.add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setMaximum(60);
		slider.setMajorTickSpacing(5);
		slider.setValue(15);
		slider.setToolTipText("wave means number of confirmations in bulk(depends on time range given above) before waiting for a longer period, as instagram may block you if too many requests are made in short period of time. ");
		slider.setBounds(12, 139, 408, 47);
		contentPane.add(slider);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblSeconds.setBounds(265, 71, 100, 16);
		contentPane.add(lblSeconds);
		
		JLabel lblTimeRangeTo = new JLabel("Time range to wait between two waves.");
		lblTimeRangeTo.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblTimeRangeTo.setBounds(12, 199, 408, 16);
		contentPane.add(lblTimeRangeTo);
		
		JLabel label_1 = new JLabel("Min:");
		label_1.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		label_1.setBounds(12, 228, 56, 16);
		contentPane.add(label_1);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		textField_4.setText("20");
		textField_4.setColumns(10);
		textField_4.setBounds(188, 225, 65, 22);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Max:");
		label_2.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		label_2.setBounds(142, 228, 56, 16);
		contentPane.add(label_2);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMinutes.setBounds(265, 228, 100, 16);
		contentPane.add(lblMinutes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("you have to install latest version of firefox.paste in the path to firefox if you have not installed it in default directory");
		panel_1.setBorder(new TitledBorder(null, "Path to installed firefox browser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 505, 408, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField txtCprogramFilesxmozilla = new JTextField();
		if(osName=="windows")
			txtCprogramFilesxmozilla.setText("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		else if(osName=="linux") 
			txtCprogramFilesxmozilla.setText("/usr/bin/firefox");
		else if(osName=="mac") 
			txtCprogramFilesxmozilla.setText("/Applications/Firefox.app/Contents/MacOS/firefox-bin");
			
		txtCprogramFilesxmozilla.setBounds(6, 18, 396, 22);
		panel_1.add(txtCprogramFilesxmozilla);
		txtCprogramFilesxmozilla.setColumns(10);
		
		textField = new JTextField();
		textField.setText("3");
		textField.setBounds(63, 68, 65, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("5");
		textField_1.setBounds(188, 68, 65, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("15");
		textField_2.setBounds(63, 225, 65, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnExecute = new JButton("Execute >>");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rangeMin=Integer.parseInt(textField.getText());
					try {
						rangeMax=Integer.parseInt(textField_1.getText());
						confirmations=slider.getValue();
						try {
							waveMin=Integer.parseInt(textField_2.getText());
							try {
								waveMax=Integer.parseInt(textField_4.getText());
								fpath=txtCprogramFilesxmozilla.getText();
								if(rangeMin<rangeMax&&rangeMin>0&&confirmations>0&&waveMin<waveMax&&waveMin>0&&fpath.length()>3){
									try {
										waitAttempts=Integer.parseInt(textField_3.getText());
										waitTime=Integer.parseInt(textField_5.getText());
										profileUrl=textField_6.getText();
											if((botName.equals("IG103")&&textField_6.getText().length()>0)||(!botName.equals("IG103"))) {
												dispose();	
												Execute exec= new Execute(osName,botName,loginMethod,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,waitAttempts,waitTime,profileUrl);
												exec.setVisible(true);
											}else
												JOptionPane.showMessageDialog(null,"Error: IG103 is selected and profile url is blank!");
									
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null,"check unsuccessful attempts and time should be integer!");
									}
											
											
								}else 
									JOptionPane.showMessageDialog(null,"input all fields or check min<max!");
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null,"wave maximum range should be a whole number");
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,"wave minimum range should be a whole number");
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"maximum range should be a whole number");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"minimum range should be a whole number");
				}

			}
		});
		btnExecute.setBounds(142, 565, 128, 25);
		contentPane.add(btnExecute);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("When instagram bans you from follow/unfollw,you  need to stop for some time.");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Unsuccessful Attempts before cooldown", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 436, 408, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAttempts = new JLabel("Attempts:");
		lblAttempts.setBounds(12, 21, 80, 16);
		panel.add(lblAttempts);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("number of times to keep pressing follow/unfollow button before concluding that instagram has temporarily banned you.");
		textField_3.setBounds(104, 18, 80, 22);
		panel.add(textField_3);
		textField_3.setText("10");
		textField_3.setColumns(10);
		
		JLabel lblWaitFor = new JLabel("Wait for:");
		lblWaitFor.setBounds(196, 21, 73, 16);
		panel.add(lblWaitFor);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("when ban is detected,this is the amount of hours to wait before automatically continuing.");
		textField_5.setBounds(281, 18, 60, 22);
		panel.add(textField_5);
		textField_5.setText("2");
		textField_5.setColumns(10);
		
		JLabel lblHrs = new JLabel("hrs");
		lblHrs.setBounds(353, 21, 43, 16);
		panel.add(lblHrs);
					
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("Required only when IG103 is selected.Bot goes to this profile and follows all its followers.");
		panel_2.setBorder(new TitledBorder(null, "Target Profile url", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 367, 404, 56);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProfileUrl = new JLabel("Profile url:");
		if(botName.equals("IG101")||botName.equals("IG102"))
			lblProfileUrl.setEnabled(false);
		lblProfileUrl.setBounds(12, 21, 80, 16);
		panel_2.add(lblProfileUrl);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 18, 300, 22);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 257, 408, 96);
		contentPane.add(scrollPane);
		
		JTextPane txtpnInstagramLimitsHow = new JTextPane();
		txtpnInstagramLimitsHow.setEditable(false);
		scrollPane.setViewportView(txtpnInstagramLimitsHow);
		txtpnInstagramLimitsHow.setText("Please Note: Instagram limits how many profiles you can follow and unfollow in a certain time limt.Exceeding that won't give any warning it will simplly show no effect on your profile made by this bot or yourself.If this condition is detected by this bot it will go to cooldown mode.The default limit to my knowledege is about 15 follow/unfollow in 15 minutes.Some older accounts may have exceeded limit.You can always play around these default values and find what suits you best.");
		if(botName.equals("IG101")||botName.equals("IG102"))
			textField_6.setEnabled(false);
		
		
	}
}
