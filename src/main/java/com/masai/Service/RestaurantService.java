package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.masai.Exceptions.RestaurantException;
import com.masai.Model.Restaurant;

@Service
public interface RestaurantService {

	public Restaurant createRestaurant(Restaurant Restaurant) throws RestaurantException;

	public Restaurant updateRestaurant(String uniqueId,Restaurant Restaurant) throws RestaurantException;

	public Restaurant removeRestaurant(Integer resturantid) throws RestaurantException;

	public List<Restaurant> viewRestaurant(String uniqueId) throws RestaurantException;

	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException;

	public List<Restaurant> viewRestaurantByItemname(String itemname) throws RestaurantException;

	//////////////////////////////////////////////////////////////////////////////////////
	public Restaurant addRestaurant(Restaurant Restaurant) throws RestaurantException;

}
