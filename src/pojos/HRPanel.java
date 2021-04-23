package pojos;

import java.sql.SQLException;
import java.util.ArrayList;

public class HRPanel {

	// private String empHRId; AUTO GENERATED - USERID
	private String empHRName;
	
public HRPanel(String empHRName) {
		super();
		this.empHRName = empHRName;
	}


public String getEmpHRName() {
	return empHRName;
}

public void setEmpHRName(String empHRName) {
	this.empHRName = empHRName;
}
public  ArrayList<HRPanel> getProfessionalDetails() throws SQLException {
	ArrayList<HRPanel> proffDetails = new ArrayList<HRPanel>();
	proffDetails.add(this);
	
	return proffDetails;

}

}
