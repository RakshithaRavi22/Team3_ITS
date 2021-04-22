package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import GUI.SignUpGUI;
import GUI.WelcomeGUI;

public class UserDriver {
	
	Connection con;
	User user;
	PreparedStatement pre;
	Scanner sc;
	WelcomeGUI w;
	static SignUpGUI s;
	

	public void say() {
		System.out.println("Im in user driver class");
	}
	
	
	public UserDriver() {
		con = DBConnect.con;
		user = new User();
		sc=new Scanner(System.in);
		w=new WelcomeGUI();
		w.setUserD(this);
	}
	

	public boolean delete(String userId) {
		boolean done = false;
		
		try {
			pre = con.prepareStatement("delete from user where user_id= ?");
			pre.setString(1, userId);
			int ra=pre.executeUpdate();

			if(ra>0)
				System.out.println("User Deleted Successfully..");
			else
				System.out.println("User was not deleted..");

			if(ra>0) {
				System.out.println("User Deleted Successfully..");
				done = true;
			}
			else {
				System.out.println("User was not deleted..");
				done = false;
			}
			pre.close();
			sc.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	public int insert()
	{
		s=w.getSignUpGUI();
		try
		{
			pre=con.prepareStatement("insert into user(first_name, last_name, dob, gender, street, location, city, state, zipcode, mobile_no, email)  values(?,?,?,?,?,?,?,?,?,?,?)");

			pre.setString(1, s.getFirstName());
			pre.setString(2,s.getLastName());
			pre.setString(3,s.getDob());
			pre.setString(4,s.getGender());
			pre.setString(5,s.getStreet());
			pre.setString(6,s.get_location());
			pre.setString(7,s.getCity());
			pre.setString(8,s.get_state());
			pre.setLong(9,s.getZipcode());
			pre.setString(10,s.getMobile());
			pre.setString(11,s.getEmail());
			pre.setString(1, w.getSignUpGUI().getFirstName());
			pre.setString(2,w.getSignUpGUI().getLastName());
			pre.setString(3,w.getSignUpGUI().getDob());
			pre.setString(4,w.getSignUpGUI().getGender());
			pre.setString(5,w.getSignUpGUI().getStreet());
			pre.setString(6,w.getSignUpGUI().get_location());
			pre.setString(7,w.getSignUpGUI().getCity());
			pre.setString(8,w.getSignUpGUI().get_state());
			pre.setLong(9,w.getSignUpGUI().getZipcode());
			pre.setString(10,w.getSignUpGUI().getMobile());
			pre.setString(11,w.getSignUpGUI().getEmail());
			

			int ra=pre.executeUpdate();
			
			
			
			if(ra>0) {
				String new_user_id="";
				String userType = s.getUserType();
				userType = userType.substring(0,1);
				
				System.out.println("User Details Committed..");
				
				String query = "select user_id from user where email="+"\""+s.getEmail()+"\"";
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				pre = con.prepareStatement("insert into user_credentials values(?, ?, ?, ?)");
				
				if(rs.next())
					new_user_id = rs.getString("user_id");
				pre.setString(1, new_user_id);
				pre.setString(2, s.getPassword());
				pre.setString(3, userType);
				pre.setInt(4, 0);
				
				int ra1 = pre.executeUpdate();
				
				if(ra1>0) {

					System.out.println("User Credentaials table was updated");
					
					
					if(userType.equalsIgnoreCase("c")) {
						float exper = s.getExperience();
						DecimalFormat df = new DecimalFormat("#.00");  
						exper= Float.valueOf(df.format(exper));
						    
						    
						pre = con.prepareStatement("insert into its_tbl_candidate values(?,?,?,?,?,?,?,?,?)");
						pre.setString(1, new_user_id);
						pre.setString(2, s.getprimary_skill());
						pre.setString(3, s.getsecondary_skill());
						pre.setFloat(4, exper);
						pre.setString(5, s.getQualifiication());
						pre.setString(6, s.getDesignation());
						pre.setInt(7, s.getNoticePeriod());
						pre.setString(8, s.getOtherLocation());
						pre.setInt(9, 1);
						
						ra1 = pre.executeUpdate();
						
					}
					else if(userType.equalsIgnoreCase("t")) {
						pre = con.prepareStatement("insert into its_tbl_techpanel values(?,?,?)");
						pre.setString(1, new_user_id);
						pre.setString(2, s.getFirstName()+" "+s.getLastName());
						pre.setString(3, s.getSubjectFiled());
						
						ra1 = pre.executeUpdate();
						
					}
					else if(userType.equalsIgnoreCase("h")) {
						pre = con.prepareStatement("insert into its_tbl_hrpanel values(?,?)");
						pre.setString(1, new_user_id);
						pre.setString(2, s.getFirstName()+" "+s.getLastName());
						
						ra1 = pre.executeUpdate();
					}
					
					if(ra1>0) {
						System.out.println("Tech/hr/candidate updated");
						return 1;
					}
					else 

					System.out.println("User Credentials table was updated");
					return 1;

				}
				else {
					System.out.println("User credentials was not updated");
					return 0;
				}
				
			}
			else 
				System.out.println("User Details are Not Committed..");
			pre.close();
			sc.close();
			return 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public String authenticateUserCode(String code) {
		 Pattern technicalCode = Pattern.compile("^techwiley[0-9]{4}$", Pattern.CASE_INSENSITIVE);
		 Pattern hrCode = Pattern.compile("^hrwiley[0-9]{4}$", Pattern.CASE_INSENSITIVE);
		 Pattern candidateCode = Pattern.compile("^candwiley[0-9]{4}$", Pattern.CASE_INSENSITIVE);
		 
		 return technicalCode.matcher(code).find() ? 
				 "tech" :
					 hrCode.matcher(code).find() ?
							 "hr" :
								 candidateCode.matcher(code).find() ?
										 "cand" :
											 "invalid";
								
	}
	public boolean updateUser(String userId) {
		boolean done = false;

		try {
			pre = con.prepareStatement("update user set first_name = ?, last_name = ?, dob = ?, gender = ?, street = ?, location = ?, city = ?, state = ?, zipcode = ?, mobile_no = ?, email = ? where user_id= ?");
			// Uncomment when done with GUI

//			pre.setString(1, getFirstName());
//			pre.setString(2, getLastName());
//			pre.setString(3, getDob());
//			pre.setString(4, getGender());
//			pre.setString(5, getStreet());
//			pre.setString(6, get_location());
//			pre.setString(7, getCity());
//			pre.setString(8, get_state());
//			pre.setString(9, getZipcode());
//			pre.setString(10, getMobile());
//			pre.setString(11, getEmail());
			pre.setString(12, userId);
			int ra=pre.executeUpdate();
			if(ra>0) {
				System.out.println("Users details updated successfully..");
				done = true;
			}
			else {
				System.out.println("Users details are not updated");
				done = false;
			}
			pre.close();
			sc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	
	
	
	
	public static String loginAuth(String userId, String password) {
		String user ="invalid";
		try {
			
			UserCredentials uc = new UserCredentials(userId);
			char userType = uc.getUserType();
			if(uc.checkUserCredentials(password)) {
				if(userType=='c')
					user= "candidate";
				else if(userType=='t')
					user= "technical";
				else if(userType=='a')
					user = "admin";
				else if(userType=='h')
					user = "hr";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
		
	}
	
	public static void main(String[] args) {
		new UserDriver();
	}
}