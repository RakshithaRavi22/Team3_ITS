package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeGUI implements ActionListener {
	JLabel label;
	JFrame frame;
	JButton Signup, Login;
	JPanel panel1, panel2, outerPanel;

	
	public WelcomeGUI() {
		label = new JLabel("Welcome");
		label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 50));
		
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Signup = new JButton("Sign up");
		Login = new JButton("Log in");
		Signup.addActionListener(this);
		Login.addActionListener(this);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.add(label);
		panel2.add(Signup);
		panel2.add(Login);
		
		outerPanel = new JPanel(new BorderLayout());

		outerPanel.add(panel1, BorderLayout.NORTH);
		outerPanel.add(panel2, BorderLayout.CENTER);
		
		frame.add(outerPanel);
		frame.setVisible(true);
		

	}


	public static void main(String[] args) {
		new WelcomeGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Signup) {
//			new SignUpGUI();
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
		                new SignUpGUI().setVisible(true);
		            }
		        });
		}
		
		else if(e.getSource() == Login) {
			new LoginGUI();
			
		}
		
	}

}