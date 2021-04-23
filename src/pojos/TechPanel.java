package pojos;

public class TechPanel {
	
	// private String techId; AUTO GENERATED USERID 
	private String techName;
	private String Subjects;
	
	public TechPanel(String techName, String subjects) {
		super();
		this.techName = techName;
		Subjects = subjects;
	}
	
	public String getTechName() {
		return techName;
	}
	public String getSubjects() {
		return Subjects;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public void setSubjects(String subjects) {
		Subjects = subjects;
	}
	
	

}
