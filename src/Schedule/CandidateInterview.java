package Schedule;

public class CandidateInterview {
	private String InterviewID;
	private String  candidateID;
	private String subject; //edge case for hr
	private String TechInterviewTime;
	private String TechInterviewDate;
	private String HRInterviewTime;
	private String HRInterviewDate;
	
	public CandidateInterview(String interviewID, String candidateID, String subject, String techInterviewTime,
			String techInterviewDate, String hRInterviewTime, String hRInterviewDate) {
		super();
		InterviewID = interviewID;
		this.candidateID = candidateID;
		this.subject = subject;
		TechInterviewTime = techInterviewTime;
		TechInterviewDate = techInterviewDate;
		HRInterviewTime = hRInterviewTime;
		HRInterviewDate = hRInterviewDate;
	}

	@Override
	public String toString() {
		return "candidateInterview [InterviewID=" + InterviewID + ", candidateID=" + candidateID + ", subject="
				+ subject + ", TechInterviewTime=" + TechInterviewTime + ", TechInterviewDate=" + TechInterviewDate
				+ ", HRInterviewTime=" + HRInterviewTime + ", HRInterviewDate=" + HRInterviewDate + "]\n";
	}
	

	


}
