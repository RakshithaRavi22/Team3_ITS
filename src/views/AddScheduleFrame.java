 
package views;

import java.sql.SQLException;

import javax.swing.JFrame;

import Schedule.InterviewSchedule;
 
public class AddScheduleFrame extends javax.swing.JFrame {
 
    public AddScheduleFrame() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jalaas = new javax.swing.JLabel();
        candidateName = new javax.swing.JTextField();
        jlabel = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        jalaas1 = new javax.swing.JLabel();
        candidateId1 = new javax.swing.JTextField();
        jalaas2 = new javax.swing.JLabel();
        techId = new javax.swing.JTextField();
        jalaas3 = new javax.swing.JLabel();
        techTime = new javax.swing.JTextField();
        jalaas4 = new javax.swing.JLabel();
        techDate1 = new javax.swing.JTextField();
        jalaas6 = new javax.swing.JLabel();
        techName = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        addLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Add Interview");

        jalaas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas.setText("Candidate Id");

        candidateName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel.setText("Candidate Name");

        subject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jalaas1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas1.setText("Tech Interview Time");

        candidateId1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jalaas2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas2.setText("Subject");

        techId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        techId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techIdActionPerformed(evt);
            }
        });

        jalaas3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas3.setText("Tech Id");

        techTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        techTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techTimeActionPerformed(evt);
            }
        });

        jalaas4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas4.setText("Tech Interview Date");

        techDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        techDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techDate1ActionPerformed(evt);
            }
        });

        jalaas6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jalaas6.setText("Tech Interviewer Name");

        techName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        techName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techNameActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					InterviewSchedule schedule = new InterviewSchedule(candidateId1.getText(), subject.getText(), techId.getText(), techDate1.getText(), techTime.getText());
					
					boolean isInserted = schedule.insert();
					
					if(isInserted)
						System.out.println("inserted");
					else System.out.println("not inserted");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });

        addLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addLabel.setText("Added Successfully");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalaas, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalaas2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalaas3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalaas1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jalaas4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jalaas6)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(techId, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(techDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(subject, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(candidateId1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(candidateName)
                            .addComponent(techTime, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(techName)
                            .addComponent(addLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(578, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candidateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalaas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candidateId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalaas2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalaas3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(techId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalaas4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(techDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalaas1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(techTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(techName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalaas6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	SchedulePanelFrame sPanel = new SchedulePanelFrame();
    	sPanel.setVisible(true);
		sPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();
    }

    private void techNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_techNameActionPerformed

    private void techDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_techDate1ActionPerformed

    private void techTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_techTimeActionPerformed

    private void techIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_techIdActionPerformed

     
    public static void main(String args[]) {
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddScheduleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField candidateId1;
    private javax.swing.JTextField candidateName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jalaas;
    private javax.swing.JLabel jalaas1;
    private javax.swing.JLabel jalaas2;
    private javax.swing.JLabel jalaas3;
    private javax.swing.JLabel jalaas4;
    private javax.swing.JLabel jalaas6;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField subject;
    private javax.swing.JTextField techDate1;
    private javax.swing.JTextField techId;
    private javax.swing.JTextField techName;
    private javax.swing.JTextField techTime;
    // End of variables declaration//GEN-END:variables
}
