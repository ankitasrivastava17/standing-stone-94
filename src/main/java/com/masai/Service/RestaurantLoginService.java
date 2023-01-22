package com.masai.Service;

import org.springframework.stereotype.Service;

import com.masai.Exceptions.RestaurantLoginException;
import com.masai.Model.RestaurantLogin;

@Service
public interface RestaurantLoginService {
	public String restaurantLogin(RestaurantLogin dto) throws RestaurantLoginException;

    public String restaurantLogout(String uniqueId) throws RestaurantLoginException;
}
