package pojos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import dao.DBConnect;
import schedule.CandidateInterview;
import schedule.InterviewSchedule;
import views.SignUpGUI;
import views.WelcomeGUI;

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
	
	
	public List<CandidateInterview> getCandidateSchedule(String candId) {
		List<CandidateInterview> list;
		try {
			InterviewSchedule obj = new InterviewSchedule(candId);

			list = obj.getCandidateInfo();
			
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;

	}
	

	
	public static Map<String, String> loginAuth(String userId, String password) {
		Map<String, String> map =new HashMap<>();
		try {
			
			UserCredentials uc = new UserCredentials(userId);
			char userType = uc.getUserType();
			User user1 = new User(userId);
			ArrayList<User> Userdetails = user1.getDetails();
			User user = Userdetails.get(0);
			
			if(uc.checkUserCredentials(password)) {
				if(userType=='c' || userType == 'C') {

					
					Candidate objC = new Candidate(userId);
					ArrayList<Candidate> profDetails = objC.getProfessionalDetails();
					objC = profDetails.get(0);
					
					
					map.put("first_name", user.getFirst_name());
					map.put("last_name", user.getLast_name());
					map.put("email", user.getEmail());
					map.put("dob", user.getDob());
					map.put("mob", user.getMob_no());
					map.put("userType", "cand");
					map.put("primary", objC.getPrimarySkills());
					map.put("secondary", objC.getSecondarySkills());
					map.put("experience", Float.toString(objC.getExperience()));
					map.put("qualif", objC.getQualification());
					map.put("desig", objC.getDesignation());
					map.put("candId", userId);
				}
				else if(userType=='t' || userType=='T') {
					
					TechPanel techGuy = new TechPanel(userId);
					ArrayList<TechPanel> profDetails = techGuy.getProfessionalDetails();
					techGuy = profDetails.get(0);
					map.put("first_name", user.getFirst_name());
					map.put("last_name", user.getLast_name());
					map.put("email", user.getEmail());
					map.put("dob", user.getDob());
					map.put("mob", user.getMob_no());
					map.put("userType", "tech");
					map.put("subject", techGuy.getSubjects());
				}
				else if(userType=='a' || userType == 'A') {
					
				}
				else if(userType=='h' || userType == 'H') {
					map.put("first_name", user.getFirst_name());
					map.put("last_name", user.getLast_name());
					map.put("email", user.getEmail());
					map.put("dob", user.getDob());
					map.put("mob", user.getMob_no());
					map.put("userType", "hr");
				}
				
			}
			else {
				map.put("userType", "invalid");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
		
		
	}
	
	public static void main(String[] args) {
		new UserDriver();
	}
}