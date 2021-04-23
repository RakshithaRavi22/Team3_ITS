package pojos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DBConnect;

public class TechPanel {
	
	private String techId;
	private String techName;
	private String Subjects;
	
	Connection con;


public TechPanel(String TechID) throws SQLException {

	con = DBConnect.con;
	String query = "select * from ITS_TBL_TechPanel where techId="+"\""+TechID+"\"";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	this.setTechId(TechID);
	if(rs.next()) {
		this.techName = rs.getString("techName");
		this.Subjects = rs.getString("Subjects");
	}
}


public  ArrayList<TechPanel> getProfessionalDetails() throws SQLException {
	ArrayList<TechPanel> proffDetails = new ArrayList<TechPanel>();
	proffDetails.add(this);
	
	return proffDetails;

}


	@Override
public String toString() {
	return "TechPanel [techName=" + techName + ", Subjects=" + Subjects + "]";
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
	
	public static void main(String args[]) throws SQLException {
		
		TechPanel c = new TechPanel("bb1000");
		System.out.println(c.getProfessionalDetails());
		System.out.println(c.getProfessionalDetails().get(0).getTechName());
		User u = new User("bb1000");
		System.out.println(u.getDetails());
		

		
	}


	public String getTechId() {
		return techId;
	}


	public void setTechId(String techId) {
		this.techId = techId;
	}
	

}