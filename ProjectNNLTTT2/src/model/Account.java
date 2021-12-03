package model;

public class Account {
	private String username;
	private String password;
	private String usertype;
	public Account() {
		
	}
	public Account(String user, String pwd, String type) {
		this.username = user;
		this.password = pwd;
		this.usertype = type;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
