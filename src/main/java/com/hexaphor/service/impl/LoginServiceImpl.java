package com.hexaphor.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexaphor.model.LoginUser;
import com.hexaphor.repo.LoginUserRepository;
import com.hexaphor.service.ILoginService;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginUserRepository login_User_Repository;
	@Override
	public LoginUser login(String userName, String password) throws Exception {
		
		
		LoginUser LoginUser=null;
		String loginID=login_User_Repository.user_login(userName, password);

		if(loginID==null){
			//return login_User_Pojo;
			LoginUser=null;
		}
		else{
		Optional<LoginUser> login_user=	login_User_Repository.findById(loginID);
		BeanUtils.copyProperties(login_user.get(), com.hexaphor.Global.StaticData.GetLoginUserByUserName);
		LoginUser=login_user.get();
		//return com.hexaphor.Global.StaticData.GetLoginUserByUserName;
		}
		return LoginUser;
	}
	@Override
	public String forgetPassword(String userName, String gmail) throws Exception {
		
		
		return "Enter Correct  User Name";
	}
	@Override
	public void forgetPassword(String userName, String gmail, String newPassword) throws Exception {
		
		
	}

}
