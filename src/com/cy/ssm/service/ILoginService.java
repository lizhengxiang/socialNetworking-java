package com.cy.ssm.service;


import java.util.List;

import com.cy.ssm.beans.UserBean;

public interface ILoginService {

	public List<UserBean> Login(String username,String password);
	public int insertUser(UserBean user)throws Exception;
	
}
