package Schedule;

public class TechInterview {
	private String InterviewID;
	private String TechID;
	private String candidateName;
	private String Subject;
	private String TechInterviewDate;
	private String TechInterviewTime;
	private int TechRating;
	
	public TechInterview(String interviewID, String candidateName, String techID, String subject, String techInterviewDate,
			String techInterviewTime, int techRating) {
		super();
		InterviewID = interviewID;
		TechID = techID;
		this.candidateName = candidateName;
		Subject = subject;
		TechInterviewDate = techInterviewDate;
		TechInterviewTime = techInterviewTime;
		TechRating = techRating;
	}

	public String getInterviewID() {
		return InterviewID;
	}

	public void setInterviewID(String interviewID) {
		InterviewID = interviewID;
	}

	public String getTechID() {
		return TechID;
	}

	public void setTechID(String techID) {
		TechID = techID;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getTechInterviewDate() {
		return TechInterviewDate;
	}

	public void setTechInterviewDate(String techInterviewDate) {
		TechInterviewDate = techInterviewDate;
	}

	public String getTechInterviewTime() {
		return TechInterviewTime;
	}

	public void setTechInterviewTime(String techInterviewTime) {
		TechInterviewTime = techInterviewTime;
	}

	public int getTechRating() {
		return TechRating;
	}

	public void setTechRating(int techRating) {
		TechRating = techRating;
	}

	@Override
	public String toString() {
		return "techInterview [InterviewID=" + InterviewID + ", TechID=" + TechID + ", candidateName=" + candidateName
				+ ", Subject=" + Subject + ", TechInterviewDate=" + TechInterviewDate + ", TechInterviewTime="
				+ TechInterviewTime + ", TechRating=" + TechRating + "]";
	}
	
	
	
	

}