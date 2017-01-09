package com.cy.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cy.ssm.mapper.UserMapper;
import com.cy.ssm.beans.UserBean;
import com.cy.ssm.service.ILoginService;
@Service //注重业务层
public class LoginServiceImpl implements ILoginService{
	
	@Resource //数据层
	private UserMapper um;


	@Override  //表示重写父类
	public List<UserBean> Login(String username, String password) {
		return um.login(username, password);
	}
	
	//@Override 
	public int insertUser(UserBean user) throws Exception{
		System.out.println(user.getUsername());
		 return um.insertUser(user);
	}
}
