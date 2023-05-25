package com.registration_app.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyCredential(String email,String password);
	
	public void saveRegistration(String name, String city, String email,String mobile);
	public ResultSet getAllReg();
		
	

}
