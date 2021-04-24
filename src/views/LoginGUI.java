package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import pojos.User;
import pojos.UserDriver;

public class LoginGUI implements ActionListener {

	JFrame frame;
	JPanel outerPanel, panel1, panel2;
	JLabel label, label1, ul;
	JTextField username;
	JPasswordField password;
	JButton submit;
	String uname, psswd;
	
	
	public LoginGUI() {
		
		frame = new JFrame("Login");
		outerPanel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel();
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		label = new JLabel("");

		
		label1 = new JLabel("Enter UserID and Password");
		username = new JTextField(10);
		password = new JPasswordField(10);
		
		ul = new JLabel();
		
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		panel2.add(label1);
		panel2.add(username);
		panel2.add(password);
		panel2.add(submit);
		panel2.add(ul);
		panel1.add(label);
		
		
		outerPanel.add(panel2, BorderLayout.NORTH);
		outerPanel.add(panel1, BorderLayout.CENTER);
		
		frame.add(outerPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public String getUname() {
		return uname;
	}

	public String getPsswd() {
		return psswd;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		String s = (String) e.getSource();
		if(username.getText().length() != 0 && password.getPassword().length != 0) 
		{	
			if (e.getSource() == submit) {
				
				uname = username.getText();
				psswd = new String(password.getPassword());	

				
				Map<String,String> userType = UserDriver.loginAuth(uname, psswd);
				
				System.out.println(userType);
				
				if(userType.get("userType").equals("cand"))
				{
					CandidatePanelFrame cp = new CandidatePanelFrame(userType);
					cp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					cp.setVisible(true);
					frame.dispose();
				}
				else if(userType.get("userType").equals("tech")) {
					TechPanelFrame tp = new TechPanelFrame(userType);
					tp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					tp.setVisible(true);
					frame.dispose();
				}
				else if(userType.get("userType").equals("hr")) {
					HRPanelFrame hr = new HRPanelFrame(userType);
					hr.setExtendedState(JFrame.MAXIMIZED_BOTH);
					hr.setVisible(true);
					frame.dispose();
				}
				else if(userType.get("userType").equals("admin")) {
					AdminPanelFrame ad = new AdminPanelFrame();
					ad.setExtendedState(JFrame.MAXIMIZED_BOTH);
					ad.setVisible(true);
					frame.dispose();
				}
				else {
					label.setText("Invalid User");
				}
				
				
			}			
		}
		else ul.setText("Enter all fields");
	}
}