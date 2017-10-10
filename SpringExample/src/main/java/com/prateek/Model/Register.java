package com.prateek.Model;

import java.io.Serializable;

public class Register implements Serializable {

	private static final long serialVersionUID = -9067540169632985515L;

	private String name;

	private int adhaar_Id;

	private int age;

	private String email;

	private String username;

	private String password;

	public Register() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdhaar_Id() {
		return adhaar_Id;
	}

	public void setAdhaar_Id(int adhaar_Id) {
		this.adhaar_Id = adhaar_Id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "Register [name=" + name + ", adhaar_Id=" + adhaar_Id + ", age=" + age + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}

}
