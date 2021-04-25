/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;

import pojos.Candidate;
import pojos.TechPanel;
import pojos.User;
import pojos.UserCredentials;
import pojos.UserDriver;

/**
 *
 * @author rages
 */
public class UsersPanelFrame extends javax.swing.JFrame {

    /**
     * Creates new form UsersPanelFrame
     */
	private String[][] users;
    public UsersPanelFrame() {
    	users = new UserDriver().getAllUsers();
    	System.out.println(Arrays.deepToString(users));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        updateUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userId_text = new javax.swing.JTextField();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Users Database");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
        		users,
                new String [] {
                    "User ID", "First Name", "Last Name", "Email", "DOB", "Mobile Number"
                }
        ));
        jScrollPane1.setViewportView(userTable);

        updateUserBtn.setText("Update User");
        updateUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					updateUserBtnActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });

        deleteUserBtn.setText("Delete User");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	User u = new User(userId_text.getText());
            	boolean isDeleted = u.delete();
            	if(isDeleted)
            		System.out.println("deleted");
            	else System.out.println("not deleted");
            	
            	dispose();
            	UsersPanelFrame usersPanel = new UsersPanelFrame();
            	usersPanel.setVisible(true);
            	usersPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter USER ID");

        userId_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userId_textActionPerformed(evt);
            }
        });

        homeBtn.setText("Go Back");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(754, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userId_text)
                            .addComponent(homeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userId_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(updateUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    private void userId_textActionPerformed(java.awt.event.ActionEvent evt) {                                            
    
    }                                           

    private void updateUserBtnActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                              
    	char userType = new UserCredentials(userId_text.getText()).getUserType();
    	
    	
    	Object obj = userType == 'c' || userType == 'C' ?  new Candidate(userId_text.getText()) : 
    		userType == 't' || userType == 'T' ?  new TechPanel(userId_text.getText()) : null;
    	
    	UpdateUserFrame updateUser = new UpdateUserFrame(
    			userType, new User(userId_text.getText()), obj);
    	updateUser.setVisible(true);
		updateUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();
    }                                             

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
    
    }                                             

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	AdminPanelFrame adminPanel = new AdminPanelFrame();
    	adminPanel.setVisible(true);
		adminPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();
	}                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsersPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersPanelFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField userId_text;
    private javax.swing.JButton updateUserBtn;
    private javax.swing.JTable userTable;
    // End of variables declaration                   
}