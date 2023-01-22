package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.RestaurantException;
import com.masai.Model.CustomerSession;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;
import com.masai.Model.RestaurantSession;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao rDao;

	@Autowired
	private Item iDao;

	@Autowired
	private CustomerSessionDao cSDao;

	@Autowired
	private RestaurantSession rSDao;

	@Override
	public Restaurant createRestaurant(Restaurant Restaurant) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant updateRestaurant(String uniqueId, Restaurant Restaurant) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant removeRestaurant(Integer resturantid) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurant(String uniqueId) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemname(String itemname) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant addRestaurant(Restaurant Restaurant) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
