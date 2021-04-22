package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import register.UserDriver;

public class WelcomeGUI implements ActionListener {
	JLabel label;
	static JLabel msg;
	JFrame frame;
	JButton Signup, Login;
	JPanel panel1, panel2, outerPanel, panel3;
	private SignUpGUI sign;
	UserDriver u;
	
	public SignUpGUI getSignUpGUI() {
		return sign;
	}
	
	public static void ErrorMsg(int result) {
		if(result == 1)
			msg.setText("Successfuly Registered");
		else {
			msg.setText("Registration not successful");
		}
	}

	public void setUserD(UserDriver u2) {
		// TODO Auto-generated method stub
		u=u2;
	}
	public WelcomeGUI() {
		label = new JLabel("Welcome",2);
		label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 50));
		
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Signup = new JButton("Sign up");
		Login = new JButton("Log in");
		Signup.addActionListener(this);
		Login.addActionListener(this);
		
		msg = new JLabel("",2);
		
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(2,2));
		
		panel1.add(label);
		panel2.add(Signup);
		panel2.add(Login);
		panel2.add(msg);
		
		outerPanel = new JPanel(new BorderLayout());

		outerPanel.add(panel1, BorderLayout.NORTH);
		outerPanel.add(panel2, BorderLayout.CENTER);

		
		frame.add(outerPanel);
		frame.setVisible(true);
		

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Signup) {
			 try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(SignUpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(SignUpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(SignUpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(SignUpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
		        //</editor-fold>

//		         Create and display the form 
		        java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	sign = new SignUpGUI();
		            	sign.setExtendedState(JFrame.MAXIMIZED_BOTH);
		            	sign.setVisible(true);
		            	sign.setUser(u);
		            }
		        });
		}
		
		else if(e.getSource() == Login) {
			new LoginGUI();
			
		}
		
	}


}