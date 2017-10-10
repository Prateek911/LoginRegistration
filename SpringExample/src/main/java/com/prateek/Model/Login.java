package com.prateek.Model;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 9179015705859221931L;

	private String username;

	private String password;

	public Login() {
		super();

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

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

}
