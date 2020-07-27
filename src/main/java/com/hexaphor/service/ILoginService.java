package com.hexaphor.service;

import com.hexaphor.model.LoginUser;

public interface ILoginService {

	public LoginUser login(String userName,String password)throws Exception;
	
	public String forgetPassword(String userName,String gmail)throws Exception;
	
	public void forgetPassword(String userName,String gmail,String newPassword)throws Exception;
	
	
}
