package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import GUI.WelcomeGUI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDriver {
	
	Connection con;
	User user;
	PreparedStatement pre;
	Scanner sc;
	
	
	
	public UserDriver() {
		this.con = DBConnect.con;
		user = new User();
		sc=new Scanner(System.in);
	}
	
	public void delete() {
		System.out.println("Enter user_id to delete the user");
		String userId = sc.next();
		
		try {
			pre = con.prepareStatement("delete from user where user_id= ?");
			pre.setString(1, userId);
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("User Deleted Successfully..");
			else
				System.out.println("User was not deleted..");
			pre.close();
			sc.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert()
	{
		try
		{
			
			System.out.println("Enter First Name of User");
			user.setFirst_name(sc.next());
			System.out.println("Enter Last Name of User");
			user.setLast_name(sc.next());
			System.out.println("Enter dob of User");
			user.setDob(sc.next());
			System.out.println("Enter Gender of User");
			user.setGender(sc.next().charAt(0));
			System.out.println("Enter Street of User");
			user.setStreet(sc.next());
			System.out.println("Enter Location of User");
			user.setLocation(sc.next());
			System.out.println("Enter City of User");
			user.setCity(sc.next());
			System.out.println("Enter State of User");
			user.setState(sc.next());
			System.out.println("Enter Mobile of User");
			user.setMob_no(sc.next());
			System.out.println("Enter Email Id of User");
			user.setEmail(sc.next());
			System.out.println("Enter UserType of User");
			user.setUserType(sc.next());			
			System.out.println("Enter Password for User");
			user.setPassword(sc.next());
			System.out.println("Enter Zipcode of User");
			user.setZipcode(sc.nextLong());

			pre=con.prepareStatement("insert into user(first_name, last_name, dob, gender, street, location, city, state, zipcode, mobile_no, email)  values(?,?,?,?,?,?,?,?,?,?,?)");

			
			pre.setString(1, user.getFirst_name());
			pre.setString(2,user.getLast_name());
			pre.setString(3,user.getDob());
			pre.setString(4,String.valueOf(user.getGender()));
			pre.setString(5,user.getStreet());
			pre.setString(6,user.getLocation());
			pre.setString(7,user.getCity());
			pre.setString(8,user.getState());
			pre.setLong(9,user.getZipcode());
			pre.setString(10,user.getMob_no());
			pre.setString(11,user.getEmail());
			
			int ra=pre.executeUpdate();
			
			
			
			if(ra>0) {
				System.out.println("User Details Committed..");
				
				
				String query = "select user_id from user where email="+"\""+user.getEmail()+"\"";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				pre = con.prepareStatement("insert into user_credentials values(?, ?, ?, ?)");
				
				if(rs.next())
					pre.setString(1, rs.getString("user_id"));
				pre.setString(2, user.getPassword());
				pre.setString(3, user.getUserType());
				pre.setInt(4, 0);
				
				int ra1 = pre.executeUpdate();
				
				if(ra1>0) {
					System.out.println("User Credentials table was updated");
					
				}
				else {
					System.out.println("User credentials was not updated");
				}
				
			}
			else 
				System.out.println("User Details are Not Committed..");
			pre.close();
			sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
	
	
	public static void main(String[] args) {
		UserDriver u = new UserDriver();
		//u.delete();
		
	}
}
