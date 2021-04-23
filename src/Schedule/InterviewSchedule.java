package Schedule;

//notify changes on rating type in sql
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
	
	Connection con;
	DBConnect obj;
	ResultSet rs;
	String query;
	Statement st;
	private char user_type;
	
	public InterviewSchedule(String user_id) throws SQLException {
		obj = new DBConnect();
		con = obj.con;
		
		UserCredentials uc = new UserCredentials(user_id);
		user_type = uc.getUserType();
		if(user_type == 'H') {
			query = "select * from ITS_TBL_Interview_Schedule where empHRID =" + "\"" + user_id + "\"";
		}
		else if(user_type == 'T') {
			query = "select * from ITS_TBL_Interview_Schedule where TechID =" + "\"" + user_id + "\"";
		}
		else if(user_type == 'C') {
			query = "select * from ITS_TBL_Interview_Schedule where candidateID =" + "\"" + user_id + "\"";
		}
		
		st = con.createStatement();
		rs = st.executeQuery(query);
		
	}

	public ArrayList<TechInterview> getTechInfo() throws SQLException{
		ArrayList<TechInterview> obj = new ArrayList<TechInterview>();
		
		while(rs.next()) {
			obj.add(new TechInterview(rs.getString("InterviewID"), 
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
			obj.add(new HRInterview(rs.getString("InterviewID"), 
					rs.getString("empHRID"),
					rs.getString("empHRInterviewDate"),
					rs.getString("empHRInterviewTime"),
					rs.getInt("empHRRating")));
		}
		return obj;
	}
	

	public ArrayList<CandidateInterview> getCandidateInfo() throws SQLException{
		ArrayList<CandidateInterview> obj = new ArrayList<CandidateInterview>();
		
		while(rs.next()) {
			obj.add(new CandidateInterview(rs.getString("InterviewID"), 
					rs.getString("CandidateId"),
					rs.getString("Subject"),
					rs.getString("TechInterviewDate"),
					rs.getString("TechInterviewTime"),
					rs.getString("empHRInterviewDate"),
					rs.getString("empHRInterviewTime")));
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

