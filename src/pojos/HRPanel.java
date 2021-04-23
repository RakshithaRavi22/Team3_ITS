package pojos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DBConnect;

public class HRPanel {

	private String empHRId;
	private String empHRName;
	
	Connection con;


public HRPanel(String empHRID) throws SQLException {
	con = DBConnect.con;
	String query = "select * from ITS_TBL_HRPanel where empHRId="+"\""+empHRID+"\"";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	this.setEmpHRId(empHRID);
	if(rs.next()) {
		this.empHRName = rs.getString("empHRName");
	}
}

public  ArrayList<HRPanel> getProfessionalDetails() throws SQLException {
	ArrayList<HRPanel> proffDetails = new ArrayList<HRPanel>();
	proffDetails.add(this);
	
	return proffDetails;

}

public String getEmpHRName() {
	return empHRName;
}

public void setEmpHRName(String empHRName) {
	this.empHRName = empHRName;
}


public void setEmpHRID(String empHRID) {
	this.setEmpHRId(empHRID);
}

public static void main(String args[]) throws SQLException {
	
	HRPanel c = new HRPanel("a1000");
	System.out.println(c.getProfessionalDetails());

	
}

@Override
public String toString() {
	return "HRPanel [empHRName=" + empHRName + "]";
}

public String getEmpHRId() {
	return empHRId;
}

public void setEmpHRId(String empHRId) {
	this.empHRId = empHRId;
}

}