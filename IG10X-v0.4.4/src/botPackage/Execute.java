package botPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Execute extends JFrame {

	private JPanel contentPane;
	private JLabel statusLabel;
	private JTextArea textArea;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel lblRequested_1;
	private JLabel lblFollowing_1;
	private JLabel label_4;
	static FirefoxDriver driver = null;
	WebDriverWait wait;
	/**
	 * Create the frame.
	 */
	public Execute(String osName,String botName,String loginMethod,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,int waitAttempts,int waitTime,String profileUrl) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Configurations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 418, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(16, 18, 100, 16);
		panel.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel(username);
		lblNewLabel.setBounds(148, 18, 248, 16);
		panel.add(lblNewLabel);
		
		JLabel lblIg = new JLabel(botName);
		lblIg.setBounds(148, 47, 248, 16);
		panel.add(lblIg);
		
		JLabel lblBotName = new JLabel("Bot name:");
		lblBotName.setBounds(16, 47, 100, 16);
		panel.add(lblBotName);
		
		JLabel lblConfirmTime = new JLabel("Confirm time:");
		lblConfirmTime.setBounds(16, 76, 100, 16);
		panel.add(lblConfirmTime);
		
		JLabel label = new JLabel(rangeMin+" - "+rangeMax+" seconds");
		label.setToolTipText("randomly  generated time range between two consecutive follow/unfollow");
		label.setBounds(148, 76, 248, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel(waveMin+" - "+waveMax+" minutes");
		label_1.setToolTipText("randomly  generated time range between two consecutive waves");
		label_1.setBounds(148, 105, 248, 16);
		panel.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("Wave time:");
		lblNewLabel_1.setBounds(16, 105, 100, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblWavesPassed = new JLabel("Waves passed:");
		lblWavesPassed.setBounds(16, 247, 100, 16);
		panel.add(lblWavesPassed);
		
		label_2 = new JLabel("0");
		label_2.setBounds(148, 247, 248, 16);
		panel.add(label_2);
		
		label_3 = new JLabel("0");
		label_3.setToolTipText("confirmations in present wave");
		label_3.setBounds(148, 276, 80, 16);
		panel.add(label_3);
		
		JLabel lblConfirmations = new JLabel("Confirmations:");
		lblConfirmations.setBounds(16, 276, 100, 16);
		panel.add(lblConfirmations);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(16, 305, 100, 16);
		panel.add(lblStatus);
		
		statusLabel = new JLabel("opening new browser session...");
		statusLabel.setBounds(148, 305, 248, 16);
		panel.add(statusLabel);
		
		JLabel lblNewLabel_2 = new JLabel("out of "+confirmations);
		lblNewLabel_2.setToolTipText("number of confirmation per wave");
		lblNewLabel_2.setBounds(241, 276, 159, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblRequested = new JLabel("Requested:");
		if (botName.equals("IG102"))
			lblRequested.setEnabled(false);
		lblRequested.setBounds(16, 163, 100, 16);
		panel.add(lblRequested);
		
		lblRequested_1 = new JLabel("0");
		if (botName.equals("IG102"))
			lblRequested_1.setEnabled(false);
		lblRequested_1.setBounds(148, 163, 248, 16);
		panel.add(lblRequested_1);
		
		JLabel lblFollowing = new JLabel();
		if(botName.equals("IG102"))
			lblFollowing.setText("Unfollowed:");
		else
			lblFollowing.setText("Following:");
		lblFollowing.setBounds(16, 192, 100, 16);
		panel.add(lblFollowing);
		
		lblFollowing_1 = new JLabel("0");
		lblFollowing_1.setBounds(148, 192, 248, 16);
		panel.add(lblFollowing_1);
		
		JLabel lblUnsuccessful = new JLabel("Unsuccessful:");
		lblUnsuccessful.setBounds(16, 218, 100, 16);
		panel.add(lblUnsuccessful);
		
		label_4 = new JLabel("0");
		label_4.setBounds(148, 218, 80, 16);
		panel.add(label_4);
		
		JLabel lblOutOf = new JLabel("out of "+waitAttempts);
		lblOutOf.setBounds(237, 218, 159, 16);
		panel.add(lblOutOf);
		
		JLabel lblCooldown = new JLabel("Cooldown:");
		lblCooldown.setBounds(16, 134, 100, 16);
		panel.add(lblCooldown);
		
		JLabel label_5 = new JLabel(Integer.toString(waitTime)+" hrs");
		label_5.setBounds(148, 134, 56, 16);
		panel.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Logs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(442, 13, 418, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 384, 261);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					driver.quit();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				statusLabel.setText("exiting program");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setBounds(596, 355, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Copyright \u00A9 2017 zxcV32 | Email: c34r534w@gmail.com");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(452, 326, 408, 16);
		contentPane.add(lblNewLabel_3);

		
		if(botName=="IG101"){
			Thread ig101=new Thread(){
				public void run(){
					try {
						IG101(osName,botName,loginMethod,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,waitAttempts,waitTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			ig101.start();					
		}
			
		else if(botName=="IG102"){
			Thread ig102=new Thread(){
				public void run(){
					try {
						IG102(osName,botName,loginMethod,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,waitAttempts,waitTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			ig102.start();	
		}
		else if(botName=="IG103"){
			Thread ig103=new Thread(){
				public void run(){
					try {
						IG103(osName,botName,loginMethod,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,waitAttempts,waitTime,profileUrl);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			ig103.start();	
		}
		else if(botName=="IG104"){
			Thread ig104=new Thread(){
				public void run(){
					try {
						IG104(osName,botName,loginMethod,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,waitAttempts,waitTime,profileUrl);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			ig104.start();	
		}
		
	}

	void IG101(String osName,String botName,String loginMethod,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,int waitAttempts,int waitTime) throws InterruptedException{

		BufferedWriter br2 = null;
		String executableLocation=null;
		statusLabel.setText("Opening new browser session...");
		textArea.append("opening new browser session.\n");
	System.setProperty("webdriver.firefox.bin", fpath);
	if(osName=="windows")
		//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
		executableLocation="data"+File.separator+osName+File.separator+"geckodriver.exe";

	else 
		//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
		executableLocation="data"+File.separator+osName+File.separator+"geckodriver";
	try{ 
		System.setProperty("webdriver.firefox.bin", fpath);
				System.setProperty("webdriver.gecko.driver",executableLocation);
				driver=new FirefoxDriver();
			}
	catch(IllegalStateException x){
		try {
			br2 = new BufferedWriter(new FileWriter("error_log", true));
			br2.write(">>"+x.toString()+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
		textArea.append("FireFox Path: "+fpath);
		statusLabel.setText("firefox error");
		return;
	}
	statusLabel.setText("Logging In.");
	textArea.append("**Do not resize browser window less than half the screen in width**\n");
	textArea.append("logging in.\n");
	try {
		if (loginMethod=="facebook"){		
			driver.get("https://www.instagram.com/");
			Thread.sleep(5000);	
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/span/button")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
			driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
			Thread.sleep(5000);
		}else{			
			driver.get("https://www.instagram.com/accounts/login/");
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[1]/div/input")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[2]/div/input")).sendKeys(password);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button")).click();
			Thread.sleep(2000);
		}
	} catch (Exception e3) {
		e3.printStackTrace();
		try{
		br2 = new BufferedWriter(new FileWriter("error_log", true));
		br2.write(">>"+e3.toString()+"\n");
		br2.close();
		statusLabel.setText("not able to login");
		textArea.append("Not able to login may be slow network try restarting the bot.\n");
		driver.quit();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}

		Thread.sleep(2000);


  	statusLabel.setText("redirecting...");
	long timec = 0;int timew = 0;
	int following=0;
  	int requested=0;
  	int abort_counter=0;
  	int abort=waitAttempts;
  	int counter=0;
  	int listEndCounter=0;			  
	WebElement element;		  
	
	
	  while(counter++>-1) {
			 if(listEndCounter>10) {
				  textArea.append("Calculated Total:"+(requested+following)+"\n");	 
				  listEndCounter=0;
				  counter=0;
				  statusLabel.setText("reloading...");
				 driver.get("https://www.instagram.com/explore/people/");
				 Thread.sleep(5000);
			 }
			 
		  if(Integer.parseInt(label_3.getText())>=confirmations) {
			  label_2.setText(Integer.toString(Integer.parseInt(label_2.getText())+1));
			  label_3.setText("0");
			  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
			  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
			  for(;timew>0;--timew){
				  statusLabel.setText("Next wave starts in "+timew);
				  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			  }  
		  }

		  try {
			if(abort_counter>=abort) {
				  abort_counter=0;
				  counter=counter-abort-1;
				  timew=waitTime*60*60;
				  textArea.append("----------------------------------------\nCool down:Waiting for "+waitTime+" hrs\n");
				  for(;timew>0;--timew){
					  statusLabel.setText("cool down ends in "+timew);
					  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				  } 
				  continue;
			  }
			
			  element = driver.findElement(By.xpath("/html/body/span/section/main/div/ul/div/li["+counter+"]/div/div[1]/div[2]/span/button"));

				if (counter-2>1) 
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/ul/li["+ (counter-2) +"]/div/div[1]/div[2]/span/button")));			

					  		
				 if(element.getText().equals("Follow")) {
					element.click();
				  	Thread.sleep(1000);
				  	if(element.getText().equals("Requested")) {
						++requested;
						lblRequested_1.setText(Integer.toString(requested));
						abort_counter=0;
						label_4.setText("0");
						label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
				  	}
				  	else if(element.getText().equals("Following")) {
						++following;
						lblFollowing_1.setText(Integer.toString(following));
						abort_counter=0;
						label_4.setText("0");
						label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
					}
				  	else if(element.getText().equals("Follow")) 
			  			++abort_counter;	  		
				}
				 	label_4.setText(Integer.toString(abort_counter));
					statusLabel.setText("waiting for next confirmation...");
					timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
					textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
					Thread.sleep(timec);
				 
		} catch (Exception e) {
			++listEndCounter;
		}
		  textArea.setCaretPosition(textArea.getDocument().getLength());
	  }
}
	
	void IG102(String osName,String botName,String loginMethod,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,int waitAttempts,int waitTime) throws InterruptedException{
		BufferedWriter br2 = null;
		String executableLocation=null;
		statusLabel.setText("Opening new browser session...");
		textArea.append("opening new browser session.\n");
	System.setProperty("webdriver.firefox.bin", fpath);
	if(osName=="windows")
		//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
		executableLocation="data"+File.separator+osName+File.separator+"geckodriver.exe";

	else 
		//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
		executableLocation="data"+File.separator+osName+File.separator+"geckodriver";
	try{ 
				System.setProperty("webdriver.gecko.driver",executableLocation);
				driver=new FirefoxDriver();
			}
	catch(IllegalStateException x){
		try {
			br2 = new BufferedWriter(new FileWriter("error_log", true));
			br2.write(">>"+x.toString()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
		textArea.append("FireFox Path: "+fpath);
		statusLabel.setText("firefox error");
		return;
	}
	statusLabel.setText("Logging In.");
	textArea.append("**Do not resize browser window less than half the screen in width**\n");
	textArea.append("logging in.\n");
	try {
		if (loginMethod=="facebook"){		
			driver.get("https://www.instagram.com/");
			Thread.sleep(5000);	
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/span/button")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
			driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
			Thread.sleep(5000);
		}else{			
			driver.get("https://www.instagram.com/accounts/login/");
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[1]/div/input")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[2]/div/input")).sendKeys(password);
			driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button")).click();
			Thread.sleep(2000);
		}
	} catch (Exception e3) {
		try{
		br2 = new BufferedWriter(new FileWriter("error_log", true));
		br2.write(">>"+e3.toString()+"\n");
		br2.close();
		statusLabel.setText("not able to login");
		textArea.append("Not able to login may be slow network try restarting the bot.\n");
		driver.quit();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}
		Thread.sleep(2000);
  	statusLabel.setText("reloading...");
  	driver.get("https://www.instagram.com/");
	Thread.sleep(2000);			 
  	driver.findElement(By.xpath(".//*[@id='react-root']/section/nav/div[2]/div/div/div[3]/div/div[3]/a")).click();
	
	Thread.sleep(4000);
  	int i=0;
  	int total=0;
  	int unfollow=0;
  	int abort_counter=0;
  	int abort=10;
  	int counter=0;
  	int listEndCounter=0;
  	String buff="";
  	String strTotal = "";  
  	long timec = 0;
  	int timew;
  	statusLabel.setText("getting follower list");
  	buff=driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[3]/a")).getText();
  for(i=0;i<buff.length();++i) {
	  if(Character.isDigit(buff.charAt(i)))
		  strTotal=strTotal+buff.charAt(i);
  }
  total=Integer.parseInt(strTotal);
  textArea.append("Total followers at present: "+total+"\n");
  WebElement element;
  driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[3]/a")).click();
  Thread.sleep(2000);
  
  while(counter++<total) {
	  
	 if(listEndCounter>10) {
		 textArea.append("List ended...\nexiting\n");
		 statusLabel.setText("List ended...");
		 driver.quit();
		 break;
	 }
	  try {
		  
		  if(Integer.parseInt(label_3.getText())>=confirmations) {
			  label_2.setText(Integer.toString(Integer.parseInt(label_2.getText())+1));
			  label_3.setText("0");
			  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
			  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
			  for(;timew>0;--timew){
				  statusLabel.setText("Next wave starts in "+timew);
				  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			  }   
		  }
		  
		if(abort_counter>=abort) {;
			  abort_counter=0;
			  counter=counter-abort-1;
			  timew=waitTime*60*60;
			  textArea.append("----------------------------------------\nCool down:Waiting for "+waitTime+" hrs\n");
			  for(;timew>0;--timew){
				  statusLabel.setText("cool down ends in "+timew);
				  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			  } 
			  continue;
		  }										
				
		  element = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/ul/div/li["+counter+"]/div/div[2]/span/button"));

			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);			

			if(element.getText().equals("Following")||element.getText().equals("Requested")) {
				element.click();
			  	Thread.sleep(1500);
		  		if(element.getText().equals("Following")||element.getText().equals("Requested")) {
		  			++abort_counter;
		  			label_4.setText(Integer.toString(abort_counter));
		  		}		  			
		  		else { 
		  			++unfollow;
		  			abort_counter=0;
		  			label_4.setText("0");
		  			label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
		  			lblFollowing_1.setText(Integer.toString(Integer.parseInt(lblFollowing_1.getText())+1));
		  			statusLabel.setText("waiting for next confirmation...");
					timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
					textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
					Thread.sleep(timec);
		  		}		  		
			}
			lblFollowing_1.setText(Integer.toString(unfollow));
			label_4.setText(Integer.toString(abort_counter));
		  
	} catch (Exception e) {
		++listEndCounter;
	}
	  textArea.setCaretPosition(textArea.getDocument().getLength());
	  
  }
  textArea.append("expected Total:"+total);
  textArea.append("Calculated Total:"+(unfollow));  	

}
	  void IG103(String osName,String botName,String loginMethod,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,int waitAttempts,int waitTime,String profileUrl) throws InterruptedException{
			BufferedWriter br2 = null;
			String executableLocation=null;
			statusLabel.setText("Opening new browser session...");
			textArea.append("opening new browser session.\n");
		System.setProperty("webdriver.firefox.bin", fpath);
		if(osName=="windows")
			//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
			executableLocation="data"+File.separator+osName+File.separator+"geckodriver.exe";

		else 
			//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
			executableLocation="data"+File.separator+osName+File.separator+"geckodriver";
		try{ 
					System.setProperty("webdriver.gecko.driver",executableLocation);
					driver=new FirefoxDriver();
				}
		catch(IllegalStateException x){
			try {
				br2 = new BufferedWriter(new FileWriter("error_log", true));
				br2.write(">>"+x.toString()+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
			textArea.append("FireFox Path: "+fpath);
			statusLabel.setText("firefox error");
			return;
		}
		statusLabel.setText("Logging In.");
		textArea.append("**Do not resize browser window less than half the screen in width**\n");
		textArea.append("logging in.\n");
		try {
			if (loginMethod=="facebook"){		
				driver.get("https://www.instagram.com/");
				Thread.sleep(5000);	
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/span/button")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
				driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
				driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
				Thread.sleep(5000);
			}else{			
				driver.get("https://www.instagram.com/accounts/login/");
				Thread.sleep(5000);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[1]/div/input")).sendKeys(username);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[2]/div/input")).sendKeys(password);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button")).click();
				Thread.sleep(2000);
			}
		} catch (Exception e3) {
			try{
			br2 = new BufferedWriter(new FileWriter("error_log", true));
			br2.write(">>"+e3.toString()+"\n");
			br2.close();
			statusLabel.setText("not able to login");
			textArea.append("Not able to login may be slow network try restarting the bot.\n");
			driver.quit();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
			Thread.sleep(2000);
	  	statusLabel.setText("redirecting...");	  	
	  	Thread.sleep(5000);
		try {
			driver.get(profileUrl);
		} catch (InvalidArgumentException e1) {
			// TODO Auto-generated catch block
			textArea.append("Invalid profile url");
			e1.printStackTrace();
			driver.quit();
		}		
		Thread.sleep(5000);
	  	int i=0;
	  	int total=0;
	  	int follow=0;
	  	int following=0;
	  	int requested=0;
	  	int abort_counter=0;
	  	int abort=10;
	  	int counter=0;
	  	int listEndCounter=0;
	  	String buff="";
	  	String strTotal = "";  	
	  	long timec;
	  	int timew;
	  	buff=driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[2]/a/span")).getText();
	  for(i=0;i<buff.length();++i) {
		  if(Character.isDigit(buff.charAt(i)))
			  strTotal=strTotal+buff.charAt(i);
	  }
	  total=Integer.parseInt(strTotal);
	  textArea.append("Total followers at present: "+total+"\n");
	  
	  WebElement element;
	  driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	  
	  while(counter++<total) {
		 if(listEndCounter>10) {
			textArea.append("can not find more followers...");
			 driver.quit();
			 break;
		 }
		 
	  if(Integer.parseInt(label_3.getText())>=confirmations) {
		  label_2.setText(Integer.toString(Integer.parseInt(label_2.getText())+1));
		  label_3.setText("0");
		  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
		  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
		  for(;timew>0;--timew){
			  statusLabel.setText("Next wave starts in "+timew);
			  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }  
	  } 
		  try {
			if(abort_counter>=abort) {
				  abort_counter=0;
				  counter=counter-abort-1;
				  timew=waitTime*60*60;
				  textArea.append("----------------------------------------\nCool down:Waiting for "+waitTime+" hrs\n");
				  for(;timew>0;--timew){
					  statusLabel.setText("cool down ends in "+timew);
					  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				  } 
				  continue;
			  }				
			  element = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/ul/div/li["+counter+"]/div/div[2]/span/button"));

					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);			
					  		
			  	if(element.getText().equals("Requested")) {
					++requested;
					textArea.append("already requested: "+requested+"\n");
			  	}
				else if(element.getText().equals("Following")) {
					++following;
					textArea.append("already following: "+following+"\n");
				}
				else if(element.getText().equals("Follow")) {
					element.click();
				  	Thread.sleep(1000);
			  		if(element.getText().equals("Follow")) {
			  			++abort_counter;
			  			label_4.setText(Integer.toString(abort_counter));
			  		}	
			  		else if(element.getText().equals("Requested")) {
			  			lblRequested_1.setText(Integer.toString(Integer.parseInt(lblRequested_1.getText())+1));
			  			abort_counter=0;
			  			label_4.setText(Integer.toString(abort_counter));
			  			label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
			  			statusLabel.setText("waiting for next confirmation...");
						timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
						textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
						Thread.sleep(timec);
			  		}		  				
			  		else {
			  			++follow;
			  			abort_counter=0;
			  			lblFollowing_1.setText(Integer.toString(follow));
			  			label_4.setText("0");
			  			label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
			  			statusLabel.setText("waiting for next confirmation...");
						timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
						textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
						Thread.sleep(timec);
			  		}
			  		
				}
		} catch (Exception e) {
			++listEndCounter;
			Thread.sleep(1000);
		}
		  textArea.setCaretPosition(textArea.getDocument().getLength());
	  }
	  textArea.append("Acpected Total:"+total+"\n");
	 textArea.append("Calculated Total:"+(requested+following+follow));	 
	 statusLabel.setText("list ended");
	 driver.quit();
	 textArea.setCaretPosition(textArea.getDocument().getLength());
	  }
	  void IG104(String osName,String botName,String loginMethod,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,int waitAttempts,int waitTime,String profileUrl) throws InterruptedException{
			BufferedWriter br2 = null;
			String executableLocation=null;
			statusLabel.setText("Opening new browser session...");
			textArea.append("opening new browser session.\n");
		System.setProperty("webdriver.firefox.bin", fpath);
		if(osName=="windows")
			//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
			executableLocation="data"+File.separator+osName+File.separator+"geckodriver.exe";

		else 
			//executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
			executableLocation="data"+File.separator+osName+File.separator+"geckodriver";
		try{ 
					System.setProperty("webdriver.gecko.driver",executableLocation);
					driver=new FirefoxDriver();
				}
		catch(IllegalStateException x){
			try {
				br2 = new BufferedWriter(new FileWriter("error_log", true));
				br2.write(">>"+x.toString()+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
			textArea.append("FireFox Path: "+fpath);
			statusLabel.setText("firefox error");
			return;
		}
		statusLabel.setText("Logging In.");
		textArea.append("**Do not resize browser window less than half the screen in width**\n");
		textArea.append("logging in.\n");
		try {
			if (loginMethod=="facebook"){		
				driver.get("https://www.instagram.com/");
				Thread.sleep(5000);	
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/span/button")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
				driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
				driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
				Thread.sleep(5000);
			}else{			
				driver.get("https://www.instagram.com/accounts/login/");
				Thread.sleep(5000);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[1]/div/input")).sendKeys(username);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[2]/div/input")).sendKeys(password);
				driver.findElement(By.xpath(".//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button")).click();
				Thread.sleep(2000);
			}
		} catch (Exception e3) {
			try{
			br2 = new BufferedWriter(new FileWriter("error_log", true));
			br2.write(">>"+e3.toString()+"\n");
			br2.close();
			statusLabel.setText("not able to login");
			textArea.append("Not able to login may be slow network try restarting the bot.\n");
			driver.quit();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
			Thread.sleep(2000);
	  	statusLabel.setText("redirecting...");	  	
	  	Thread.sleep(5000);
		try {
			driver.get(profileUrl);
		} catch (InvalidArgumentException e1) {
			// TODO Auto-generated catch block
			textArea.append("Invalid profile url");
			e1.printStackTrace();
			driver.quit();
		}		
		Thread.sleep(5000);
	  	int i=0;
	  	int total=0;
	  	int follow=0;
	  	int following=0;
	  	int requested=0;
	  	int abort_counter=0;
	  	int abort=10;
	  	int counter=0;
	  	int listEndCounter=0;
	  	String buff="";
	  	String strTotal = "";  	
	  	long timec;
	  	int timew;
	  	buff=driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[3]/a/span")).getText();
	  for(i=0;i<buff.length();++i) {
		  if(Character.isDigit(buff.charAt(i)))
			  strTotal=strTotal+buff.charAt(i);
	  }
	  total=Integer.parseInt(strTotal);
	  textArea.append("Total followers at present: "+total+"\n");
	  
	  WebElement element;
	  driver.findElement(By.xpath("/html/body/span/section/main/article/header/section/ul/li[3]/a")).click();
	  Thread.sleep(2000);
	  
	  while(counter++<total) {
		 if(listEndCounter>10) {
			textArea.append("can not find more followers...");
			 driver.quit();
			 break;
		 }
		 
	  if(Integer.parseInt(label_3.getText())>=confirmations) {
		  label_2.setText(Integer.toString(Integer.parseInt(label_2.getText())+1));
		  label_3.setText("0");
		  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
		  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
		  for(;timew>0;--timew){
			  statusLabel.setText("Next wave starts in "+timew);
			  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }  
	  } 
		  try {
			if(abort_counter>=abort) {
				  abort_counter=0;
				  counter=counter-abort-1;
				  timew=waitTime*60*60;
				  textArea.append("----------------------------------------\nCool down:Waiting for "+waitTime+" hrs\n");
				  for(;timew>0;--timew){
					  statusLabel.setText("cool down ends in "+timew);
					  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				  } 
				  continue;
			  }										
			
			  element = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/ul/div/li["+counter+"]/div/div[2]/span/button"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);			
					  		
			  	if(element.getText().equals("Requested")) {
					++requested;
					textArea.append("already requested: "+requested+"\n");
			  	}
				else if(element.getText().equals("Following")) {
					++following;
					textArea.append("already following: "+following+"\n");
				}
				else if(element.getText().equals("Follow")) {
					element.click();
				  	Thread.sleep(1000);
			  		if(element.getText().equals("Follow")) {
			  			++abort_counter;
			  			label_4.setText(Integer.toString(abort_counter));
			  		}	
			  		else if(element.getText().equals("Requested")) {
			  			lblRequested_1.setText(Integer.toString(Integer.parseInt(lblRequested_1.getText())+1));
			  			abort_counter=0;
			  			label_4.setText(Integer.toString(abort_counter));
			  			label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
			  			statusLabel.setText("waiting for next confirmation...");
						timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
						textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
						Thread.sleep(timec);
			  		}		  				
			  		else {
			  			++follow;
			  			abort_counter=0;
			  			lblFollowing_1.setText(Integer.toString(follow));
			  			label_4.setText("0");
			  			label_3.setText(Integer.toString(Integer.parseInt(label_3.getText())+1));
			  			statusLabel.setText("waiting for next confirmation...");
						timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
						textArea.append("confirming="+ counter+" Wait time: "+timec/1000+"s\n");
						Thread.sleep(timec);
			  		}
			  		
				}
		} catch (Exception e) {
			++listEndCounter;
		}	
		  textArea.setCaretPosition(textArea.getDocument().getLength());
	  }
	  driver.quit();
	  textArea.append("Acpected Total:"+total+"\n");
	 textArea.append("Calculated Total:"+(requested+following+follow));	 
	 statusLabel.setText("list ended");
	 
	  }
}
