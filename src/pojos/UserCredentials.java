package pojos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;

public class UserCredentials {
    private String userId;
    private String password;
    private char userType;
    private int status;
    Connection con;
    DBConnect obj;
    
    int flag = 0;
    
    public UserCredentials(String userId, String password, char userType, int status) {
        super();
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.status = status;
    }
    
    public UserCredentials(String uid) throws SQLException {
    	con= DBConnect.con;
		String query = "select * from user_credentials where user_id =" + "\"" + uid + "\"";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			this.userId = uid;
			this.password = rs.getString("password");
			this.userType  = rs.getString("usertype").charAt(0);
			this.status = rs.getInt("login_status");
		}
		else
			flag = 1;
    }
    
    public boolean checkUserCredentials(String password) throws SQLException {
    	if(flag == 1)
    		return false;
    	if((this.password).equals(password)) {
    		String query = "update user_credentials set login_status = 1";
    		Statement st = con.createStatement();
    		st.executeUpdate(query);
    		this.status = 1;
    		return true;
    	}
    	return false;
    	
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public char getUserType() {
        return userType;
    }
    public void setUserType(char userType) {
        this.userType = userType;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    public static void main(String args[]) throws SQLException {
    	UserCredentials u = new UserCredentials("a1000");
    	System.out.println(u.checkUserCredentials("dsdsds"));
    }
}