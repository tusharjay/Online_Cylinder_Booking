package com.app.service;

import javax.security.auth.login.LoginException;

import com.app.dto.LoginDto;
import com.app.pojos.Customer;
import com.app.pojos.Login;

public interface ILoginService {
	
	
	public Object checkLoginCusAndDis(LoginDto login);

}
