package com.cy.ssm.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cy.ssm.beans.UserBean;
import com.cy.ssm.service.ILoginService;
import com.cy.ssm.tools.tools;



@Controller
public class LoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ILoginService loginServiceImpl;
	
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest req,UserBean user){
		log.info(user);
		List<UserBean> u=loginServiceImpl.Login(user.getUsername(), user.getPassword());
		tools<List<UserBean>> restult = new tools<List<UserBean>>(u, 0,0);
		return restult.getRestult();
	}
	
	@RequestMapping("/insertuser")
	public ModelAndView insertUser(HttpServletRequest req,UserBean user){
		log.info(user);
		ModelAndView mv = new ModelAndView();
		int u;
		try {
			u = loginServiceImpl.insertUser(user);
			if(u != 0){
				System.out.println("test");
				System.out.println(u);
				req.getSession().setAttribute("user", u);
				mv.addObject("password", u);
			}
		} catch (Exception e) {
			System.out.println("test");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("index");
		return mv;
	}
	
	
}
