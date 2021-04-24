package Schedule;
public class HRInterview {
	private String InterviewID;
	private String candidateName;
	private String  hrID;
	private String hrInterviewTime;
	private String hrInterviewDate;
	private int hrRating;
	
	public HRInterview(String interviewID, String candidateName, String hrID, String hrInterviewTime, String hrInterviewDate,
			int hrRating) {
		super();
		InterviewID = interviewID;
		this.candidateName = candidateName;
		this.hrID = hrID;
		this.hrInterviewTime = hrInterviewTime;
		this.hrInterviewDate = hrInterviewDate;
		this.hrRating = hrRating;
	}

	@Override
	public String toString() {
		return "HRInterview [InterviewID=" + InterviewID + ", candidateName=" + candidateName + ", hrID=" + hrID
				+ ", hrInterviewTime=" + hrInterviewTime + ", hrInterviewDate=" + hrInterviewDate + ", hrRating="
				+ hrRating + "]";
	}
}

	
	
	
