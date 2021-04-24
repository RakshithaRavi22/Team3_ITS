package schedule;
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

	public String getInterviewID() {
		return InterviewID;
	}

	public void setInterviewID(String interviewID) {
		InterviewID = interviewID;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getHrID() {
		return hrID;
	}

	public void setHrID(String hrID) {
		this.hrID = hrID;
	}

	public String getHrInterviewTime() {
		return hrInterviewTime;
	}

	public void setHrInterviewTime(String hrInterviewTime) {
		this.hrInterviewTime = hrInterviewTime;
	}

	public String getHrInterviewDate() {
		return hrInterviewDate;
	}

	public void setHrInterviewDate(String hrInterviewDate) {
		this.hrInterviewDate = hrInterviewDate;
	}

	public int getHrRating() {
		return hrRating;
	}

	public void setHrRating(int hrRating) {
		this.hrRating = hrRating;
	}

	@Override
	public String toString() {
		return "HRInterview [InterviewID=" + InterviewID + ", candidateName=" + candidateName + ", hrID=" + hrID
				+ ", hrInterviewTime=" + hrInterviewTime + ", hrInterviewDate=" + hrInterviewDate + ", hrRating="
				+ hrRating + "]";
	}
}

	
	
	
