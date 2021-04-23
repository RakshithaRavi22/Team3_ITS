package pojos;

public class User {
	private String first_name;
	private String last_name;
	private String dob;
	private char gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private long zipcode;
	private String mob_no;
	private String email;

	public User() {}

	public User(String first_name, String last_name, String dob, char gender, String street, String location,
			String city, String state, long zipcode, String mob_no, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mob_no = mob_no;
		this.email = email;
	

	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getDob() {
		return dob;
	}

	public char getGender() {
		return gender;
	}

	public String getStreet() {
		return street;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getZipcode() {
		return zipcode;
	}

	public String getMob_no() {
		return mob_no;
	}

	public String getEmail() {
		return email;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob + ", gender=" + gender
				+ ", street=" + street + ", location=" + location + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", mob_no=" + mob_no + ", email=" + email + "]\n";
	}
	

}
