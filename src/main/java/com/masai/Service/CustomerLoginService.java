package com.masai.Service;

import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerLoginException;
import com.masai.Model.CustomerLoginDTO;

@Service
public interface CustomerLoginService {
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException;
	
	public String customerLogout(String uniqueId) throws CustomerLoginException;
}
