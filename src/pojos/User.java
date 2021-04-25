package pojos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.DBConnect;

public class User {
	private String userId;
	private String first_name;
	private String last_name;
	private String dob;
	private char gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private long zipcode;
	private String mob_no;
	private String email;
	private Connection con;
	private PreparedStatement pre;
	public User() {

	}

	public User(String userId) {
		try {
			this.con = DBConnect.con;
			String query = "select * from user where user_id=" + "\"" + userId + "\"";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			this.setUserId(userId);
			while (rs.next()) {
				this.first_name = rs.getString("first_name");
				this.last_name = rs.getString("last_name");
				this.dob = rs.getString("dob");
				this.gender = rs.getString("gender").charAt(0);
				this.street = rs.getString("street");
				this.location = rs.getString("location");
				this.city = rs.getString("city");
				this.state = rs.getString("state");
				this.zipcode = rs.getLong("zipcode");
				this.mob_no = rs.getString("mobile_no");
				this.email = rs.getString("email");
			} 
		} catch (Exception e) {
		}
	}
	
	
	public boolean setAllDetails(Map<String,String> map) {
		
		first_name = map.get("first_name");
		last_name = map.get("last_name");
		dob = map.get("dob");
		gender = map.get("gender").charAt(0);
		street = map.get("street");
		location = map.get("location");
		city = map.get("city");
		state = map.get("state");
		zipcode = Long.parseLong(map.get("zipcode"));
		mob_no = map.get("mob_no");
		email = map.get("email");
		
		return updateUser(); 
		
	}
	
	
	
	private boolean updateUser() {
try {
			
			
			pre = con.prepareStatement("update user set first_name = ?, last_name = ?, dob = ?, gender = ?, street = ?, location = ?, city = ?, state = ?, zipcode = ?, mobile_no = ?, email = ? where user_id= ?");
			// Uncomment when done with GUI

			pre.setString(1, first_name);
			pre.setString(2, last_name);
			pre.setString(3, dob);
			pre.setString(4, String.valueOf(gender));
			pre.setString(5, street);
			pre.setString(6, location);
			pre.setString(7, city);
			pre.setString(8, state);
			pre.setLong(9, zipcode);
			pre.setString(10, mob_no);
			pre.setString(11, email);
			pre.setString(12, userId);
			int ra=pre.executeUpdate();
			if(ra>0)
				return true;
			else return false;
	}
	catch(Exception e) {System.out.println(e);}
			
		return false;
	}

	public boolean updateUser(char userType, String priSkill, String secSkill, String exp, String quali, String desig, String noticeP,String loc, String sub) {
		boolean done = false;
		
		try {
					int ra = -1;
					if(userType == 'c' || userType == 'C') {
						System.out.println("im here!!!!!!!!!!!!!");
						pre = con.prepareStatement("update its_tbl_candidate set "
								+ "primarySkills= ?, secondarySkills = ?, designation = ?, qualification= ?, noticePeriod = ?, location =?, experience = ? "
								+ "where candidateId = ?");
						pre.setString(1, priSkill);
						pre.setString(2, secSkill);
						pre.setString(3, desig);
						pre.setString(4, quali);
						pre.setInt(5, Integer.parseInt(noticeP));
						pre.setString(6, loc);
						pre.setFloat(7, Float.parseFloat(exp));
						pre.setString(8, userId);
						ra = pre.executeUpdate();
					}
					else if(userType=='t' || userType=='T')
					{
						System.out.println(sub);
						pre = con.prepareStatement("update its_tbl_techpanel set subjects=? where techId = ?");
						pre.setString(1, sub);
						pre.setString(2, userId);
						ra = pre.executeUpdate();
					}
					if(ra>0)
						done = true;
					else 
						done = false;
			pre.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	
	
	
	public boolean delete() {
		boolean done = false;
		
		try {
			pre = con.prepareStatement("delete from user where user_id= ?");
			pre.setString(1, this.getUserId());
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	
	
	
	
	
	public User(String first_name, String last_name, String dob, char gender, String street, String location,
			String city, String state, long zipcode, String mob_no, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mob_no = mob_no;
		this.email = email;
	}
	
	

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getDob() {
		return dob;
	}

	public char getGender() {
		return gender;
	}

	public String getStreet() {
		return street;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getZipcode() {
		return zipcode;
	}

	public String getMob_no() {
		return mob_no;
	}

	public String getEmail() {
		return email;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob + ", gender=" + gender
				+ ", street=" + street + ", location=" + location + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", mob_no=" + mob_no + ", email=" + email + "]\n";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public ArrayList<User> getDetails() throws SQLException {
		ArrayList<User> details = new ArrayList<>();
			details.add(this);
			
		return details;
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
