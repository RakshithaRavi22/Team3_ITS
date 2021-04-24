package schedule;

public class CandidateInterview {
	private String InterviewID;
	private String HRinterviewerName;
	private String TechinterviewerName;
	private String candidateID;
	private String subject; //edge case for hr
	private String TechInterviewTime;
	private String TechInterviewDate;
	private String HRInterviewTime;
	private String HRInterviewDate;
	
	public CandidateInterview(String interviewID, String hRinterviewerName, String techinterviewerName,
			String candidateID, String subject, String techInterviewTime, String techInterviewDate,
			String hRInterviewTime, String hRInterviewDate) {
		super();
		InterviewID = interviewID;
		HRinterviewerName = hRinterviewerName;
		TechinterviewerName = techinterviewerName;
		this.candidateID = candidateID;
		this.subject = subject;
		TechInterviewTime = techInterviewTime;
		TechInterviewDate = techInterviewDate;
		HRInterviewTime = hRInterviewTime;
		HRInterviewDate = hRInterviewDate;
	}


	public void setInterviewID(String interviewID) {
		InterviewID = interviewID;
	}


	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public void setTechInterviewTime(String techInterviewTime) {
		TechInterviewTime = techInterviewTime;
	}


	public void setTechInterviewDate(String techInterviewDate) {
		TechInterviewDate = techInterviewDate;
	}


	public void setHRInterviewTime(String hRInterviewTime) {
		HRInterviewTime = hRInterviewTime;
	}


	public void setHRInterviewDate(String hRInterviewDate) {
		HRInterviewDate = hRInterviewDate;
	}


	public String getInterviewID() {
		return InterviewID;
	}


	public String getCandidateID() {
		return candidateID;
	}


	public String getSubject() {
		return subject;
	}


	public String getTechInterviewTime() {
		return TechInterviewTime;
	}


	public String getTechInterviewDate() {
		return TechInterviewDate;
	}


	public String getHRInterviewTime() {
		return HRInterviewTime;
	}


	public String getHRInterviewDate() {
		return HRInterviewDate;
	}





	public String getHRinterviewerName() {
		return HRinterviewerName;
	}


	@Override
	public String toString() {
		return "CandidateInterview [InterviewID=" + InterviewID + ", candidateID=" + candidateID + ", subject="
				+ subject + ", TechInterviewTime=" + TechInterviewTime + ", TechInterviewDate=" + TechInterviewDate
				+ ", HRInterviewTime=" + HRInterviewTime + ", HRInterviewDate=" + HRInterviewDate
				+ ", TechinterviewerName=" + TechinterviewerName + ", HRinterviewerName=" + HRinterviewerName + "]";
	}


	public void setHRinterviewerName(String hRinterviewerName) {
		HRinterviewerName = hRinterviewerName;
	}


	public String getTechinterviewerName() {
		return TechinterviewerName;
	}


	public void setTechinterviewerName(String techinterviewerName) {
		TechinterviewerName = techinterviewerName;
	}
	

	


}
