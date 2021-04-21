package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		
		label = new JLabel("Choose User Type");
		String[] users = {"Admin", "Tech", "HR" };
		JComboBox<String> userType = new JComboBox<String>(users);
		
		label1 = new JLabel("Enter UserID and Password");
		username = new JTextField(10);
		password = new JPasswordField(10);
		
		ul = new JLabel();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel1.add(label);
		panel1.add(userType);
		panel2.add(label1);
		panel2.add(username);
		panel2.add(password);
		panel2.add(submit);
		panel2.add(ul);
		
		outerPanel.add(panel1, BorderLayout.NORTH);
		outerPanel.add(panel2, BorderLayout.CENTER);
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
		if(username.getText().length() != 0 && password.getPassword().length != 0) {
			
			if (e.getSource() == submit) {
				username.setText("");
				password.setText("");
				uname = username.getText();
				psswd = new String(password.getPassword());
				frame.dispose();
			}			
		}
		else ul.setText("Enter all fields");
	}
}