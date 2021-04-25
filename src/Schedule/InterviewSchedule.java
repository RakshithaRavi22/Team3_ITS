package Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import dao.DBConnect;
import pojos.User;
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
	
	private PreparedStatement pre;
	Connection con;

	ResultSet rs;
	ResultSet rs1;
	String query;
	Statement st, st1;
	
	private char user_type;
	
	public InterviewSchedule() {con = DBConnect.con;}
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

	
	public InterviewSchedule(String candidateId, String subject, String techId, String techInDate, String techInTime) throws SQLException {
		super();
		this.candidateId = candidateId;
		this.subject = subject;
		this.techId = techId;
		this.techInDate = techInDate;
		this.techInTime = techInTime;
		
		User techGuy = new User(techId);
		User candidateGuy = new User(candidateId);
		TechinterviewerName = techGuy.getFirst_name() + techGuy.getLast_name();
		this.candidateName = candidateGuy.getFirst_name() + candidateGuy.getLast_name();
	}
	
	public boolean insert() throws SQLException {
		boolean done;
		con = DBConnect.con;
		
		pre = con.prepareStatement("insert into ITS_TBL_Interview_Schedule(CandidateID, Subject, TechID, TechInterviewDate, TechInterviewTime) values"
				+ "(?, ?, ?, ?, ?);");
		pre.setString(1, candidateId);
		pre.setString(2, subject);
		pre.setString(3, techId);
		pre.setString(4, techInDate);
		pre.setString(5, techInTime);
		
		int ra=pre.executeUpdate();
		if(ra>0) {
			System.out.println("Inserted details updated successfully..");
			done = true;
		}
		else {
			System.out.println("Inserted details are not updated");
			done = false;
		}
		pre.close();
		return done;

				
	}

	public InterviewSchedule(String admin_id, String InterviewID) throws SQLException {
		con = DBConnect.con;
		query = "select * from ITS_TBL_Interview_Schedule  where InterviewID = " + "\"" + InterviewID + "\"";
		st = con.createStatement();
		rs = st.executeQuery(query);
		
		if(rs.next()) {
			interviewId = rs.getString("InterviewID");
			candidateId = rs.getString("CandidateID");
			subject = rs.getString("Subject");
			techId = rs.getString("TechID");
			techInDate =rs.getString("TechInterviewDate");
			techInTime = rs.getString("TechInterviewTime");
			techRate = rs.getInt("TechRating");
			hrId = rs.getString("empHRID");
			hrInDate = rs.getString("empHRInterviewDate");
			hrInTime = rs.getString("empHRInterviewTime");
			hrRate = rs.getInt("empHRRating");
			result = rs.getString("Result");
			shareResult = rs.getInt("ShareResult");
		}
				
	}

	public boolean updateRating(String rating, String interID, char userType) throws SQLException {
		if(userType == 't' || userType=='T') {
			query = "update ITS_TBL_Interview_Schedule set TechRating = ? where InterviewID = ?";
		}
		else
		if(userType == 'h' || userType=='H') {
			query = "update ITS_TBL_Interview_Schedule set empHRRating = ? where InterviewID = ?";
		}
		pre = con.prepareStatement(query);
		pre.setInt(1,Integer.parseInt(rating));
		pre.setString(2,interID);
		int rs = pre.executeUpdate();
		if(rs>0)
			return true;
		return false;
	}
	
	
public boolean setAllDetails(Map<String,String> map) {
	
		if(map.get("CandidateID") != null)
			candidateId = map.get("CandidateID");
		if(map.get("Subject") != null)
			subject = map.get("Subject");
		if(map.get("TechID") != null)
			techId = map.get("TechID");
		if(map.get("TechInterviewDate") != null && !map.get("TechInterviewDate").equals(""))
			techInDate = map.get("TechInterviewDate");
		if(map.get("TechInterviewTime") != null)
			techInTime = map.get("TechInterviewTime");
		if(map.get("TechRating") != null)
			techRate = Integer.parseInt(map.get("TechRating"));
		if(map.get("empHRID") != null)
			hrId = map.get("empHRID");
		if(map.get("empHRInterviewDate") != null && !map.get("empHRInterviewDate").equals(""))
			hrInDate = map.get("empHRInterviewDate");
		if(map.get("empHRInterviewTime") != null)
			hrInTime = (map.get("empHRInterviewTime"));
		if(map.get("empHRRating") != null)
			hrRate = Integer.parseInt(map.get("empHRRating"));
		if(map.get("Result") != null)
			result = map.get("Result");
		if(map.get("ShareResult") != null)
			shareResult = Integer.parseInt(map.get("ShareResult"));
		
		return updateSchedule(); 
		
	}


	public boolean updateSchedule() {
		boolean done = false;

		try {
			pre = con.prepareStatement("update ITS_TBL_Interview_Schedule set CandidateID = ?, Subject = ?, TechID = ?,"
					+ " TechInterviewDate = ?, TechInterviewTime = ?,  TechRating= ?, empHRID = ?, empHRInterviewDate = ?, empHRInterviewTime = ?, "
					+ "empHRRating = ?, Result = ?, ShareResult = ? where InterviewID = ?");
			// Uncomment when done with GUI

			pre.setString(1, candidateId);
			pre.setString(2, subject);
			pre.setString(3, techId);
			pre.setString(4, techInDate);
			pre.setString(5, techInTime);
			pre.setInt(6, techRate);
			pre.setString(7, hrId);
			pre.setString(8, hrInDate);
			pre.setString(9, hrInTime);
			pre.setInt(10, hrRate);
			pre.setString(11, result);
			pre.setInt(12, shareResult);
			pre.setString(13, interviewId);

			
			int ra=pre.executeUpdate();
			if(ra>0) {
				System.out.println("Interview details updated successfully..");
				done = true;
			}
			else {
				System.out.println("Interview details are not updated");
				done = false;
			}
			pre.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	

	public boolean delete() {
		boolean done = false;
		
		try {
			pre = con.prepareStatement("delete from ITS_TBL_Interview_Schedule where InterviewID = ?");
			pre.setString(1, this.getInterviewId());
			int ra=pre.executeUpdate();

			if(ra>0) {
				System.out.println("Interview Deleted Successfully..");
				done = true;
			}
			else {
				System.out.println("Interview");
				done = false;
			}
			pre.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	
	
	

	@Override
	public String toString() {
		return "InterviewSchedule [interviewId=" + interviewId + ", candidateId=" + candidateId + ", subject=" + subject
				+ ", techId=" + techId + ", techInDate=" + techInDate + ", techInTime=" + techInTime + ", techRate="
				+ techRate + ", hrId=" + hrId + ", hrInDate=" + hrInDate + ", hrInTime=" + hrInTime + ", hrRate="
				+ hrRate + ", result=" + result + ", shareResult=" + shareResult + ", HRinterviewerName="
				+ HRinterviewerName + ", TechinterviewerName=" + TechinterviewerName + ", candidateName="
				+ candidateName + ", user_type=" + user_type + "]\n";
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
	
	public String[][] getAllSchedules() {
		String[][] list = null;
		
		
		try {
			
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("select count(*) size from its_tbl_interview_schedule");
			int size = 0;
			
			if(rs1.next())
				size = rs1.getInt("size");
			
			list = new String[size][12];
			st = con.createStatement();
			rs = st.executeQuery("select * from its_tbl_interview_schedule");
			
			int i=0;
			
			while(rs.next()) {
				list[i][0] = rs.getString("InterviewID");
				list[i][1] = rs.getString("CandidateId");
				list[i][2] = rs.getString("Subject");
				list[i][3] = rs.getString("TechID");
				list[i][4] = rs.getString("TechInterviewTime");
				list[i][5] = rs.getString("TechInterviewDate");
				list[i][6] = rs.getString("TechRating");
				list[i][7] = rs.getString("empHRID");
				list[i][8] = rs.getString("empHRInterviewDate");
				list[i][9] = rs.getString("empHRInterviewTime");
				list[i][10] = rs.getString("empHRRating");
				list[i][11] = rs.getString("result");
				i++;
			}
		}
		
		catch(Exception e) {System.out.println(e);}
		
		return list;
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
}


		/*to insert new schedule: 
			InterviewSchedule schedule = new InterviewSchedule(String candidateId, String subject, String techId, String techInDate, String techInTime);
			-- returns nothing - insertion operation is always successful.
		
		to update schedule:
			InterviewSchedule schedule = new InterviewSchedule(String admin_id, String InterviewID);
			schedule.setAllDetails(HashMap<String, String>);
			-- setAllDetails' argument is a hashmap of fields being edited.
			-- returns true if updation successful, false otherwise 
			-- setAllDetails implicitly calls updateSchedule function
			-- constructor argument admin_id is a dummy used to mitigate duplicate constructor signature
		
		to delete schedule:
			InterviewSchedule schedule = new InterviewSchedule(String admin_id, String InterviewID);
			schedule.delete();
			-- returns true if deletion successful, false otherwise
		
		to fetch specific details for hr/tech/candidate interface view:
			InterviewSchedule schedule = new InterviewSchedule(String user_id);
			ArrayList<techInterview> getTechInfo(); 
			ArrayList<candidateInterview> getCandidateInfo();  
			ArrayList<HRInterview> getHRInfo();
		*/
