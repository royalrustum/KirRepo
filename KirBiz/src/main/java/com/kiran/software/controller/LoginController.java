package com.kiran.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiran.software.util.ReqMap;
import com.kiran.software.util.ViewName;

@Controller
@RequestMapping(ReqMap.Login)
public class LoginController {

	@RequestMapping(ReqMap.ShowLogin)
	public String showLogin() {
		return ViewName.Login;
	}

}
