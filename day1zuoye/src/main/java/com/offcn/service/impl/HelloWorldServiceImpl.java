package com.offcn.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.Userdao;
import com.offcn.pojo.User;
import com.offcn.service.HelloWorldService;
@Service

public class HelloWorldServiceImpl implements HelloWorldService {
@Autowired
Userdao userdao;
	@Override
	public User search(String number) {
		
		return userdao.select(number);
	}

	

}
