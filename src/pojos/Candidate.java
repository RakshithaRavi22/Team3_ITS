package pojos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DBConnect;

public class Candidate {
	
	// private String candidateId; - AUTOGENERATED
	private String primarySkills;
	private String secondarySkills;
	private float experience;
	private String qualification;
	private String designation;
	private int noticePeriod;
	private String location;
	private int shareDetails;
	
	
	Connection con;
	private String candidateId;
	
	public Candidate(String candidateId) throws SQLException {
		this.con = DBConnect.con;
		String query = "select * from ITS_TBL_Candidate where CandidateId="+"\""+candidateId+"\"";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		this.candidateId = candidateId;
		while(rs.next()) {
			this.primarySkills = rs.getString("PrimarySkills");
			this.secondarySkills = rs.getString("SecondarySkills");
			this.experience = rs.getInt("Experience");
			this.qualification = rs.getString("Qualification");
			this.designation = rs.getString("Designation");
			this.noticePeriod = rs.getInt("NoticePeriod");
			this.location = rs.getString("Location");
			this.shareDetails = rs.getInt("ShareDetails");
		}
	}
	
	public Candidate( String primarySkills, String secondarySkills, float experience,
			String qualification, String designation, int noticePeriod, String location, int shareDetails) {
		super();
		//this.candidateId = candidateId;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
	}

	/*
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}*/
	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}
	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setShareDetails(int shareDetails) {
		this.shareDetails = shareDetails;
	}

	/*public String getCandidateId() {
		return candidateId;
	}*/

	public String getPrimarySkills() {
		return primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public float getExperience() {
		return experience;
	}

	public String getQualification() {
		return qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public String getLocation() {
		return location;
	}

	public int getShareDetails() {
		return shareDetails;
	}
	
	public ArrayList<User> getDetails() throws SQLException {
		String query = "select * from user where user_id="+"\""+candidateId+"\"";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<User> details = new ArrayList<>();
		
		if(rs.next()) {
			details.add(new User(rs.getString("first_name"), 
					rs.getString("last_name"),
					rs.getString("dob"),
					rs.getString("gender").charAt(0),
					rs.getString("street"),
					rs.getString("location"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getLong("zipcode"),
					rs.getString("mobile_no"),
					rs.getString("email")));
		}
//		System.out.println(details);
//		System.out.println("\nfirst name is:" + details.get(0).getFirst_name());
		return details;
		
	}
	
	public  ArrayList<Candidate> getProfessionalDetails() {
        ArrayList<Candidate> proffDetails = new ArrayList<Candidate>();
        proffDetails.add(new Candidate(this.getPrimarySkills(), 
                this.getSecondarySkills(),
                this.getExperience(),
                this.getQualification(),
                this.getDesignation(),
                this.getNoticePeriod(),
                this.getLocation(),
                this.getShareDetails()));
        return proffDetails;

    }
@Override
    public String toString() {
        return "Candidate [primarySkills=" + primarySkills + ", secondarySkills=" + secondarySkills + ", experience="
                + experience + ", qualification=" + qualification + ", designation=" + designation + ", noticePeriod="
                + noticePeriod + ", location=" + location + ", shareDetails=" + shareDetails + ", con=" + con
                + ", candidateId=" + candidateId + "]\n";
    }
//	public static void main(String args[]) throws SQLException {
//		Candidate c = new Candidate("a1000");
//		c.getDetails();
//		
//	}
	
}
