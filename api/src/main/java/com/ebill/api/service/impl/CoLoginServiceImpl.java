package com.ebill.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebill.api.repository.LoginRepo;
import com.ebill.api.service.CoLoginService;

@Component
public class CoLoginServiceImpl implements CoLoginService {
	
	@Autowired
	LoginRepo loginRepo;

}
