package Schedule;

public class HRInterview {
	private String InterviewID;
	private String  hrID;
	private String hrInterviewTime;
	private String hrInterviewDate;
	private int hrRating;
	
	public HRInterview(String interviewID, String hrID, String hrInterviewTime, String hrInterviewDate,
			int hrRating) {
		super();
		InterviewID = interviewID;
		this.hrID = hrID;
		this.hrInterviewTime = hrInterviewTime;
		this.hrInterviewDate = hrInterviewDate;
		this.hrRating = hrRating;
	}

	@Override
	public String toString() {
		return "HRInterview [InterviewID=" + InterviewID + ", hrID=" + hrID + ", hrInterviewTime=" + hrInterviewTime
				+ ", hrInterviewDate=" + hrInterviewDate + ", hrRating=" + hrRating + "]\n";
	}
	
}
