package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offcn.dao.Userdao;
import com.offcn.pojo.User;

@Controller
public class Web_Service {
	@Autowired
	Userdao userdao;
	@RequestMapping("list")
	
	
	public String get(@RequestParam("phone") String phone){
		System.out.println(phone);
		User select = userdao.select(phone);
		if(select!=null){
			System.out.println(select.getMobileArea());
		}else{
			System.out.println("没有这个号码归属地");
		}
		return null;
		
	}



}
