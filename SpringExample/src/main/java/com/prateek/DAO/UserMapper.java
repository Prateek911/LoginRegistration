package com.prateek.DAO;

import com.prateek.Model.Login;
import com.prateek.Model.Register;

public interface UserMapper {

	public void insertUser(Register user);

	public Register getUser(Login user);
	
	public String checkUser(String uname);
	
	public String getEmail(String uname);
	
	public String checkEmail(String email);
	
	public void updatePass(String email,String pass);
}
