package register;

public class UserCredentails {
	private String userId;
	private String password;
	private char userType;
	private int status;
	
	
	
	public UserCredentails(String userId, String password, char userType, int status) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.status = status;
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
}
