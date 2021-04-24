package schedule;

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

	@Override
	public String toString() {
		return "techInterview [InterviewID=" + InterviewID + ", TechID=" + TechID + ", candidateName=" + candidateName
				+ ", Subject=" + Subject + ", TechInterviewDate=" + TechInterviewDate + ", TechInterviewTime="
				+ TechInterviewTime + ", TechRating=" + TechRating + "]";
	}
	
	
	
	

}