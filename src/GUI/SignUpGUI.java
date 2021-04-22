package GUI;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import register.UserDriver;

@SuppressWarnings("serial")
public class SignUpGUI extends javax.swing.JFrame {

    /**
     * Creates new form RegisterFrame
     */// Variables declaration - do not modify    
	private UserDriver u;
	
	JFrame frame;
	JButton authButton;
	private javax.swing.JButton authenticateBtn;

    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityl;
    private javax.swing.JTextField code;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JTextField designation;
    private javax.swing.JTextField dob;
    private javax.swing.JLabel dobl;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emaill;
    private javax.swing.JTextField experience;
    private javax.swing.JRadioButton femaleradio;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel first_namel;
    private javax.swing.JLabel genderl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField primary_skill;
    private javax.swing.JTextField secondary_skill;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel last_namel;
    private javax.swing.JTextField location;
    private javax.swing.JLabel locationl;
    private javax.swing.JRadioButton maleradio;
    private javax.swing.JTextField mobile;
    private javax.swing.JLabel mobile_lable;
    private javax.swing.JTextField noticePeriod;
    private static javax.swing.JPanel otherFields;
    private javax.swing.JTextField otherLocation;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField qualifiication;
    private javax.swing.JButton signupButton;
    private javax.swing.JTextField state;
    private javax.swing.JLabel statel;
    private javax.swing.JTextField street;
    private javax.swing.JLabel streetl;
    private static javax.swing.JTextField subjectFiled;
    private static javax.swing.JLabel subjectPanel;
    private javax.swing.JTextField zipcode;
    private javax.swing.JLabel zipcode_label;
    private JLabel errorMessage;
    private static String var;
    
    
    public SignUpGUI() {
        initComponents();
        otherFields.setVisible(false);
        signupButton.setEnabled(false);
        subjectFiled.setVisible(false);
        subjectPanel.setVisible(false);
        errorMessage.setVisible(false);
    }

    public String getCity() {
		return city.getText();
	}

	public String getDob() {
		return dob.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getGender() {
		if(maleradio.isSelected())
			return "M";
		else return "F";
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

	public String get_location() {
		return location.getText();
	}

	public String getMobile() {
		return mobile.getText();
	}

	public String getPassword() {
		return String.valueOf(password.getPassword());
	}

	public String get_state() {
		return state.getText();
	}

	public String getStreet() {
		return street.getText();
	}

	public Long getZipcode() {
		return Long.parseLong(zipcode.getText());
	}

	public String getFirst_name() {
    	return this.firstName.getText();
    }
	

    public String getDesignation() {
		return designation.getText();
	}


	public Float getExperience() {
		return Float.parseFloat(experience.getText());
	}

	public String getprimary_skill() {
		return primary_skill.getText();
	}

	public String getsecondary_skill() {
		return secondary_skill.getText();
	}


	public Integer getNoticePeriod() {
		return Integer.parseInt(noticePeriod.getText());
	}

	public String getOtherLocation() {
		return otherLocation.getText();
	}


	public String getQualifiication() {
		return qualifiication.getText();
	}

	public  String getSubjectFiled() {
		return subjectFiled.getText();
	}

	public String getUserType() {
		return var;
	}
	
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        emaill = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        first_namel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        last_namel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        dobl = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        genderl = new javax.swing.JLabel();
        maleradio = new javax.swing.JRadioButton();
        femaleradio = new javax.swing.JRadioButton();
        streetl = new javax.swing.JLabel();
        street = new javax.swing.JTextField();
        locationl = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        cityl = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        statel = new javax.swing.JLabel();
        state = new javax.swing.JTextField();
        zipcode_label = new javax.swing.JLabel();
        zipcode = new javax.swing.JTextField();
        mobile_lable = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        signupButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        authenticateBtn = new javax.swing.JButton();
        otherFields = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        primary_skill = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        secondary_skill = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        experience = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        qualifiication = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        designation = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        noticePeriod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        otherLocation = new javax.swing.JTextField();
        subjectPanel = new javax.swing.JLabel();
        subjectFiled = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();
        

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emaill.setText("Email");

        jLabel3.setText("Password");

        jLabel4.setText("Confirm Password");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        first_namel.setText("First Name");

        last_namel.setText("Last Name");

        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        dobl.setText("DOB");

        genderl.setText("Gender");

        buttonGroup2.add(maleradio);
        maleradio.setText("Male");
        maleradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleradioActionPerformed(evt);
            }
        });

        buttonGroup2.add(femaleradio);
        femaleradio.setText("Female");

        streetl.setText("Street");

        locationl.setText("Location");

        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });

        cityl.setText("City");

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });

        statel.setText("State");

        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        zipcode_label.setText("Zipcode");

        mobile_lable.setText("Mobile");

        signupButton.setText("Sign Up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }

			private void signupButtonActionPerformed(ActionEvent evt) {
				int val = u.insert();
				
				dispose();
				WelcomeGUI.ErrorMsg(val);
				
			}
        });

        jLabel2.setText("Enter Code");

        authenticateBtn.setText("Authenticate");
        authenticateBtn.addActionListener(new java.awt.event.ActionListener() {
      
        	private void authenticateBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                        
            	var = u.authenticateUserCode(code.getText());
                if(var.equals("cand")) {
                	otherFields.setVisible(true);
                	code.setEditable(false);
                	authenticateBtn.setEnabled(false);
                	signupButton.setEnabled(true);
                	errorMessage.setVisible(false);
                	
                }
                else if(var.equals("tech")) {
                	subjectFiled.setVisible(true);
                	subjectPanel.setVisible(true);
                	code.setEditable(false);
                	authenticateBtn.setEnabled(false);
                	errorMessage.setVisible(false);
                	signupButton.setEnabled(true);
                }
                else if(var.equals("hr")) {
                	authenticateBtn.setEnabled(false);
                	signupButton.setEnabled(true);
                	errorMessage.setVisible(false);
                }
                else {
                	errorMessage.setVisible(true);
                }
            }
        	

        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	
      
                authenticateBtnActionPerformed(evt);
            }

		
        });

        jLabel5.setText("Primary SKills");

        primary_skill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primary_skillActionPerformed(evt);
            }

			private void primary_skillActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });

        jLabel6.setText("Secondary Skills");

        jLabel7.setText("Experience");

        jLabel8.setText("Qualification");

        jLabel9.setText("Designation");

        jLabel10.setText("Notice Period");

        jLabel11.setText("Location");

        javax.swing.GroupLayout otherFieldsLayout = new javax.swing.GroupLayout(otherFields);
        otherFields.setLayout(otherFieldsLayout);
        otherFieldsLayout.setHorizontalGroup(
            otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherFieldsLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(primary_skill, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(secondary_skill)
                    .addComponent(experience)
                    .addComponent(qualifiication)
                    .addComponent(designation)
                    .addComponent(noticePeriod)
                    .addComponent(otherLocation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        otherFieldsLayout.setVerticalGroup(
            otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(primary_skill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(secondary_skill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(experience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(qualifiication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(noticePeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(otherLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectPanel.setText("Subjects");

        errorMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setText("Enter Valid Code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emaill)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(first_namel)
                            .addComponent(last_namel)
                            .addComponent(dobl))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(confirmPassword)
                                .addComponent(password)
                                .addComponent(firstName)
                                .addComponent(lastName)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderl)
                            .addComponent(streetl)
                            .addComponent(cityl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobile_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipcode_label, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(subjectPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mobile)
                            .addComponent(zipcode)
                            .addComponent(state)
                            .addComponent(city)
                            .addComponent(location)
                            .addComponent(street)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maleradio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(femaleradio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code)
                            .addComponent(subjectFiled))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(authenticateBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(otherFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(138, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emaill)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(first_namel)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(last_namel)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobl)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderl)
                            .addComponent(maleradio)
                            .addComponent(femaleradio))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streetl)
                            .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationl)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityl)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statel)
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(otherFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipcode_label)
                    .addComponent(zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobile_lable)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authenticateBtn)
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectPanel)
                    .addComponent(subjectFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>       
    
    private void emailActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void maleradioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }

	public void setUser(UserDriver u2) {
		// TODO Auto-generated method stub
		u=u2;
	
	}

  
                    
}