package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.RestaurantException;
import com.masai.Model.Restaurant;
import com.masai.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurentController {
	@Autowired
	private RestaurantService myService;

	// 1. ADMIN ++> create customer
	@PostMapping("/create")
	public ResponseEntity<Restaurant> createRestaurantHandler(@Valid @RequestBody Restaurant restaurant)
			throws RestaurantException {
		Restaurant newRestaurant = myService.createRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(newRestaurant, HttpStatus.CREATED);

	}

	@PutMapping("/update/{uniqueId}")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@PathVariable("uniqueId") String uniqueId,
			@Valid @RequestBody Restaurant restaurant) throws RestaurantException {
		Restaurant updatedRestaurant = myService.updateRestaurant(uniqueId, restaurant);

		return new ResponseEntity<Restaurant>(updatedRestaurant, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Restaurant> deleteRestaurantHandler(@PathVariable("id") Integer restaurantID)
			throws RestaurantException {
		Restaurant updatedRestaurant = myService.removeRestaurant(restaurantID);

		return new ResponseEntity<Restaurant>(updatedRestaurant, HttpStatus.OK);

	}

	@GetMapping("/find/{uid}")
	public ResponseEntity<List<Restaurant>> viewRestaurantHandler(@PathVariable("uid") String uniqueId)
			throws RestaurantException {
		List<Restaurant> listOfRestaurant = myService.viewRestaurant(uniqueId);

		return new ResponseEntity<List<Restaurant>>(listOfRestaurant, HttpStatus.OK);

	}

	@GetMapping("/findbylocation/{location}")
	public ResponseEntity<List<Restaurant>> findRestaurantByLocationHandler(@PathVariable("location") String location)
			throws RestaurantException {
		List<Restaurant> nearbyRestaurant = myService.viewNearByRestaurant(location);

		return new ResponseEntity<List<Restaurant>>(nearbyRestaurant, HttpStatus.OK);

	}

	@GetMapping("/findallbyitemname/{itemname}")
	public ResponseEntity<List<Restaurant>> findRestaurantByItemNameHandler(@PathVariable("itemname") String itemName)
			throws RestaurantException {
		List<Restaurant> nearbyRestaurant = myService.viewRestaurantByItemname(itemName);

		// List<Restaurant> Restaurant = null;

		return new ResponseEntity<List<Restaurant>>(nearbyRestaurant, HttpStatus.OK);

	}

	//

	/////////////////////////////////////////////////////////////////////////////////////////////////
//	@PostMapping("/Restaurant")
//	public ResponseEntity<Restaurant> listRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException
//	{
//		Restaurant newRestaurant = myService.addRestaurant(restaurant);
//
//
//		return new ResponseEntity<Restaurant>(newRestaurant, HttpStatus.CREATED);
//
//	}

	@GetMapping("/Restaurant")
	public String listRestaurant1() {

		return "Hello";

	}

}
