package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.RestaurantLogin;
import com.masai.Model.RestaurantSession;

@RestController
public class AdminLoginController {

	@Autowired
	private RestaurantLogin login;

	@PostMapping("/AdminLogin")
	public String restaurantLogin(@RequestBody RestaurantSession dto) {
		return login.RestaurantLogin();
//		
	}

	@PatchMapping("/AdminLoginLogout/{uniqueId}")
	public String restaurantLogout(@PathVariable("uniqueId") String uniqueId) {
		return login.RestaurantLogout(uniqueId);
	}

}
