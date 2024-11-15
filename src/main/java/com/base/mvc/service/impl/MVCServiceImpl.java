package com.base.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.mvc.dao.MVCDao;
import com.base.mvc.service.MVCService;

@Service
public class MVCServiceImpl implements MVCService {
	
	@Autowired
	private MVCDao mvcdao;
	
	public String methodSrv() {
		System.out.println(mvcdao.methodDao());
		return "Hello, Spring MVC. Here is Service.";
	}
}
