package Schedule;

public class TechInterview {
	private String InterviewID;
	private String TechID;
	private String Subject;
	private String TechInterviewDate;
	private String TechInterviewTime;
	private int TechRating;
	
	public TechInterview(String interviewID, String techID, String subject, String techInterviewDate,
			String techInterviewTime, int techRating) {
		super();
		InterviewID = interviewID;
		TechID = techID;
		Subject = subject;
		TechInterviewDate = techInterviewDate;
		TechInterviewTime = techInterviewTime;
		TechRating = techRating;
	}

	@Override
	public String toString() {
		return "techInterview [InterviewID=" + InterviewID + ", TechID=" + TechID + ", Subject=" + Subject
				+ ", TechInterviewDate=" + TechInterviewDate + ", TechInterviewTime=" + TechInterviewTime
				+ ", TechRating=" + TechRating + "]\n";
	}
}
