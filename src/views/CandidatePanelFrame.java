
package views;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import pojos.User;

public class CandidatePanelFrame extends javax.swing.JFrame {
	
	private String first_name;
	private String last_name;
	private String email_id;
	private String dob1;
	private String mob_no;
	private String prim_skill;
	private String sec_skill;
	private String exp;
	private String qualif;
	private String desig;
		
    public CandidatePanelFrame() {
        
    }
    public CandidatePanelFrame(Map<String,String> li) {
    	first_name = li.get("first_name");
    	last_name = li.get("last_name");
    	email_id = li.get("email");
    	dob1 = li.get("dob");
    	mob_no = li.get("mob");
    	prim_skill = li.get("primary");
    	sec_skill = li.get("secondary");
    	exp = li.get("experience");
    	qualif = li.get("qualif");
    	desig = li.get("desig");
    	
    	initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        logoutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mobile = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        primarySkills = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        secondarySkills = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        experience = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        qualification = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        designation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setText("LogOut");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("My Profile ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Last Name");

        firstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        firstName.setText(first_name);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("First Name");

        lastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastName.setText(last_name);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Email");

        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setText(email_id);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("DOB");

        dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dob.setText(dob1);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Mobile No");

        mobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mobile.setText(mob_no);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Secondary Skills");

        primarySkills.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        primarySkills.setText(prim_skill);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Primary skills");

        secondarySkills.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        secondarySkills.setText(sec_skill);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Experience ");

        experience.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        experience.setText(exp);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Designation");

        qualification.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        qualification.setText(qualif);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Qualification");

        designation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        designation.setText(desig);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastName)
                            .addComponent(firstName)
                            .addComponent(email)
                            .addComponent(dob)
                            .addComponent(mobile))
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primarySkills)
                            .addComponent(secondarySkills)
                            .addComponent(experience)
                            .addComponent(qualification)
                            .addComponent(designation)))
                    .addComponent(jLabel1))
                .addContainerGap(279, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutBtn)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstName)
                    .addComponent(jLabel4)
                    .addComponent(primarySkills)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastName)
                    .addComponent(jLabel12)
                    .addComponent(secondarySkills))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email)
                    .addComponent(jLabel16)
                    .addComponent(experience))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dob)
                    .addComponent(jLabel20)
                    .addComponent(qualification))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(mobile)
                    .addComponent(jLabel18)
                    .addComponent(designation))
                .addContainerGap(314, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
    }//GEN-LAST:event_logoutBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CandidatePanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidatePanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidatePanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidatePanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandidatePanelFrame().setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel designation;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel email;
    private javax.swing.JLabel experience;
    private javax.swing.JLabel firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lastName;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel mobile;
    private javax.swing.JLabel primarySkills;
    private javax.swing.JLabel qualification;
    private javax.swing.JLabel secondarySkills;
}
