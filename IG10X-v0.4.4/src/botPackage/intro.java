package botPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class intro {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField txtSpongebobcpagmailcom;
	private JPasswordField passwordField;
	private String osName="windows";
	private String botName="IG101";
	private String loginMethod="facebook";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro window = new intro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public intro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIgxv = new JLabel("IG10X-v0.4.4");
		lblIgxv.setHorizontalAlignment(SwingConstants.CENTER);
		lblIgxv.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblIgxv.setBounds(12, 13, 378, 69);
		frame.getContentPane().add(lblIgxv);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select Operating System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 95, 378, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setToolTipText("windows");
		rdbtnWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				osName="windows";
			}
		});
		rdbtnWindows.setBounds(6, 18, 127, 25);
		panel.add(rdbtnWindows);
		rdbtnWindows.setSelected(true);
		buttonGroup.add(rdbtnWindows);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setToolTipText("linux");
		rdbtnLinux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			osName="linux";
			}
		});
		rdbtnLinux.setBounds(137, 18, 127, 25);
		panel.add(rdbtnLinux);
		buttonGroup.add(rdbtnLinux);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mac");
		rdbtnNewRadioButton.setToolTipText("mac os x");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				osName="mac";
			}
		});
		rdbtnNewRadioButton.setBounds(268, 18, 102, 25);
		panel.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Select bot", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 158, 378, 142);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("IG101 - Follow profiles in suggestion");
		rdbtnNewRadioButton_1.setToolTipText("follow profiles in exlplore page");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botName="IG101";
			}
		});
		rdbtnNewRadioButton_1.setBounds(6, 18, 364, 25);
		panel_1.add(rdbtnNewRadioButton_1);
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setSelected(true);
		
		JRadioButton rdbtnIgUnfolow = new JRadioButton("IG102 - Unfolow currently following profiles");
		rdbtnIgUnfolow.setToolTipText("unfollow currently following profiles");
		rdbtnIgUnfolow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botName="IG102";
			}
		});
		rdbtnIgUnfolow.setBounds(6, 48, 364, 25);
		panel_1.add(rdbtnIgUnfolow);
		buttonGroup_1.add(rdbtnIgUnfolow);
		
		JRadioButton rdbtnIgUnfolow_1 = new JRadioButton("IG103 - Folow followers of a profile");
		rdbtnIgUnfolow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					botName="IG103";
			}
		});
		buttonGroup_1.add(rdbtnIgUnfolow_1);
		rdbtnIgUnfolow_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnIgUnfolow_1.setToolTipText("follow all the profiles that follows a prfile specified by you on next step");
		rdbtnIgUnfolow_1.setBounds(6, 78, 364, 25);
		panel_1.add(rdbtnIgUnfolow_1);
		
		JRadioButton rdbtnIgFollow = new JRadioButton("IG104 - Follow profiles following a given profile");
		rdbtnIgFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botName="IG104";
			}
			
		});
		buttonGroup_1.add(rdbtnIgFollow);
		rdbtnIgFollow.setBounds(6, 108, 364, 25);
		panel_1.add(rdbtnIgFollow);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Select login method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 313, 378, 50);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnUsingFacebook = new JRadioButton("Using facebook");
		rdbtnUsingFacebook.setToolTipText("select this if you have creadted the account using facebook");
		rdbtnUsingFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginMethod="facebook";
			}
		});
		rdbtnUsingFacebook.setBounds(8, 18, 160, 25);
		panel_2.add(rdbtnUsingFacebook);
		rdbtnUsingFacebook.setSelected(true);
		buttonGroup_2.add(rdbtnUsingFacebook);
		
		JRadioButton rdbtnUsingUsername = new JRadioButton("Using username");
		rdbtnUsingUsername.setToolTipText("select this if you have created account using email and password");
		rdbtnUsingUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginMethod="username";
			}
		});
		rdbtnUsingUsername.setBounds(172, 18, 160, 25);
		panel_2.add(rdbtnUsingUsername);
		buttonGroup_2.add(rdbtnUsingUsername);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Login credentials", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 376, 378, 76);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtSpongebobcpagmailcom = new JTextField();
		txtSpongebobcpagmailcom.setToolTipText("username for above selected login method");
		txtSpongebobcpagmailcom.setBounds(112, 18, 254, 22);
		panel_3.add(txtSpongebobcpagmailcom);
		txtSpongebobcpagmailcom.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(6, 21, 100, 16);
		panel_3.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 50, 100, 16);
		panel_3.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("password for above selected login method");
		passwordField.setBounds(112, 47, 254, 22);
		panel_3.add(passwordField);
		
		JButton btnConfigure = new JButton("Configure >>");
		btnConfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=txtSpongebobcpagmailcom.getText().trim();
				String password =new String(((JPasswordField) passwordField).getPassword()).trim();
				if (username.length()<1 || password.length()<1){
					JOptionPane.showMessageDialog(null,"username and password required!"); 
				}else{
				frame.dispose();	
				Configuration config= new Configuration(osName,botName,loginMethod,username,password);
				config.setVisible(true);
				}
			}
		});
		btnConfigure.setBounds(133, 465, 149, 25);
		frame.getContentPane().add(btnConfigure);
	}
}
