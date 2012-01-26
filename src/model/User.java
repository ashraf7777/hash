package model;

public class User extends Thing{
	// DO NOT CHANGE THE protected modifier because it brakes SQL Query Generation
	protected int uID;
	protected String name;
	protected String username;
	protected String password;
	protected String type;
	protected String ID;
	protected String email;
	protected String phone;
	
    

	public User(int tID, String name, String username, String password,
			String type, String iD, String email, String phone) {
		super(tID);
		uID=tID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.type = type;
		ID = iD;
		this.email = email;
		this.phone = phone;
	}
	public User(Object[] o)
	{
		uID=(Integer) o[0];
		name = (String) o[1];
		username = (String) o[2];
		password = (String) o[3];
		type = (String) o[4];
		ID = (String) o[5];
		email = (String) o[6];
		phone = (String) o[7];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
