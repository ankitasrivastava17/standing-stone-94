package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.RestaurantLoginException;
import com.masai.Model.Restaurant;
import com.masai.Model.RestaurantLogin;
import com.masai.Model.RestaurantSession;
import com.masai.repository.RestaurantDao;
import com.masai.repository.RestaurantSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class RestaurantLoginServiceImpl implements RestaurantLoginService{
	
	@Autowired
	private RestaurantDao rDao;
	
	@Autowired
	private RestaurantSessionDao rSDao;

	@Override
	public String restaurantLogin(RestaurantLogin dto) throws RestaurantLoginException {
		
		Restaurant existingRestaurant = rDao.findByContactNumber(dto.getContactNumber());
		
		if(existingRestaurant==null) {
			throw new RestaurantLoginException("Please enter a valid mobile number!");
		}
		
		Optional<RestaurantSession> opt = rSDao.findById(existingRestaurant.getRestaurantId());
		
		if(opt.isPresent()) {
			throw new RestaurantLoginException("Restaurant already logged in!");
		}
		
		if(existingRestaurant.getPassword().equals(dto.getPassword())) {
			
			RestaurantSession restaurantSession = new RestaurantSession(existingRestaurant.getRestaurantId(),RandomString.make(8),LocalDateTime.now());
			
			rSDao.save(restaurantSession);
			
			return restaurantSession.toString();
			
		}else {
			throw new RestaurantLoginException("Please enter a valid password!");
		}
		
	}

	@Override
	public String restaurantLogout(String uniqueId) throws RestaurantLoginException {
		RestaurantSession validRestaurant = rSDao.findByUniqueId(uniqueId);
		if(validRestaurant==null) {
			throw new RestaurantLoginException("Restaurant didn't sign in with this number!");
		}
		
		rSDao.delete(validRestaurant);
		
		return "Logged out!";
	}

}
