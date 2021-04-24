package Schedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DBConnect;
import pojos.UserCredentials;

public class InterviewSchedule {
	private String interviewId;
	private String candidateId;
	private String subject;
	private String techId;
	private String techInDate;
	private String techInTime;
	private int techRate;
	private String hrId;
	private String hrInDate;
	private String hrInTime;
	private int hrRate;
	private String result;
	private int shareResult;
	
	
	private String HRinterviewerName;
	private String TechinterviewerName;
	private String candidateName;
	Connection con;
	ResultSet rs;
	ResultSet rs1;
	String query;
	Statement st, st1;
	private char user_type;
	
	public InterviewSchedule(String user_id) throws SQLException {
		con = DBConnect.con;
		
		UserCredentials uc = new UserCredentials(user_id);
		user_type = uc.getUserType();
		if(user_type == 'H' || user_type == 'h') {
			query = "select * from ITS_TBL_Interview_Schedule  where empHRID = " + "\"" + user_id + "\"";
		}
		else if(user_type == 'T' || user_type == 't') {
			query = "select * from ITS_TBL_Interview_Schedule where TechID =" + "\"" + user_id + "\"";
		}
		else if(user_type == 'C' || user_type == 'c') {
			query = "select * from ITS_TBL_Interview_Schedule where candidateID =" + "\"" + user_id + "\"";
		}
		
		st = con.createStatement();
		rs = st.executeQuery(query);
		
		
	}

	public ArrayList<TechInterview> getTechInfo() throws SQLException {
		ArrayList<TechInterview> obj = new ArrayList<TechInterview>();
		
		while(rs.next()) {
			query = "select concat(first_name, \' \', last_name) as name from user where user_id = " + "\"" + rs.getString("CandidateID") + "\"";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(query);
			rs1.next();
			candidateName = rs1.getString("name");
			
			
			obj.add(new TechInterview(rs.getString("InterviewID"),
					this.getcandidateName(),
					rs.getString("TechID"),
					rs.getString("Subject"),
					rs.getString("TechInterviewDate"),
					rs.getString("TechInterviewTime"),
					rs.getInt("TechRating")));
		}
		return obj;
	}
	
	public ArrayList<HRInterview> getHRInfo() throws SQLException{
		ArrayList<HRInterview> obj = new ArrayList<HRInterview>();
		
		while(rs.next()) {
			query = "select concat(first_name, \' \', last_name) as name from user where user_id = " + "\"" + rs.getString("CandidateID") + "\"";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(query);
			rs1.next();
			candidateName = rs1.getString("name");
			
			obj.add(new HRInterview(rs.getString("InterviewID"), 
					this.getcandidateName(),
					rs.getString("empHRID"),
					rs.getString("empHRInterviewTime"),
					rs.getString("empHRInterviewDate"),
					rs.getInt("empHRRating")));
		}
		return obj;
	}
	

	public ArrayList<CandidateInterview> getCandidateInfo() throws SQLException{
		ArrayList<CandidateInterview> obj = new ArrayList<CandidateInterview>();
		
		while(rs.next()) {
			query = "select concat(first_name, \' \', last_name) as name from user where user_id = " + "\"" + rs.getString("TechID") + "\"";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(query);
			if(rs1.next())
				TechinterviewerName = rs1.getString("name");
			System.out.println(TechinterviewerName);
			st1.close();
			
			query = "select concat(first_name, \' \', last_name) as name from user where user_id = " + "\"" + rs.getString("empHRID") + "\"";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(query);
			if(rs1.next())
				HRinterviewerName = rs1.getString("name");
			
			
			obj.add(new CandidateInterview(rs.getString("InterviewID"),
					this.HRinterviewerName,
					this.TechinterviewerName,
					rs.getString("CandidateId"),
					rs.getString("Subject"),
					rs.getString("TechInterviewTime"),
					rs.getString("TechInterviewDate"),
					rs.getString("empHRInterviewTime"),
					rs.getString("empHRInterviewDate")));
					
		}
		return obj;
	}
	
	
	
	public String getInterviewId() {
		return interviewId;
	}


	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}


	public String getCandidateId() {
		return candidateId;
	}
	

	public char getUserType() {
		return user_type;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTechId() {
		return techId;
	}


	public void setTechId(String techId) {
		this.techId = techId;
	}


	public String getTechInDate() {
		return techInDate;
	}


	public void setTechInDate(String techInDate) {
		this.techInDate = techInDate;
	}


	public String getTechInTime() {
		return techInTime;
	}


	public void setTechInTime(String techInTime) {
		this.techInTime = techInTime;
	}


	public int getTechRate() {
		return techRate;
	}


	public void setTechRate(int techRate) {
		this.techRate = techRate;
	}


	public String getHrId() {
		return hrId;
	}


	public void setHrId(String hrId) {
		this.hrId = hrId;
	}


	public String getHrInDate() {
		return hrInDate;
	}


	public void setHrInDate(String hrInDate) {
		this.hrInDate = hrInDate;
	}


	public String getHrInTime() {
		return hrInTime;
	}


	public void setHrInTime(String hrInTime) {
		this.hrInTime = hrInTime;
	}


	public int getHrRate() {
		return hrRate;
	}
	
	public String getcandidateName() {
		return candidateName;
	}


	public void setHrRate(int hrRate) {
		this.hrRate = hrRate;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public int getShareResult() {
		return shareResult;
	}


	public void setShareResult(int shareResult) {
		this.shareResult = shareResult;
	}
	
	public static void main(String args[]) throws SQLException {
		InterviewSchedule schedule = new InterviewSchedule("cc1001");
		if(schedule.getUserType() == 'H')
			System.out.println(schedule.getHRInfo());
		if(schedule.getUserType() == 'C')
			System.out.println(schedule.getCandidateInfo());
		if(schedule.getUserType() == 'T')
			System.out.println(schedule.getTechInfo());
		
	}
	
}
