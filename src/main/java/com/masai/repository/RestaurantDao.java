package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Restaurant;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer>
{


	public Restaurant findByContactNumber(String contactNumber);

    @Query("select r from Restaurant r")
	public List<Restaurant> getRestByLocation();

	public Restaurant findByRestaurantName(String restaurantName);

	@Query("select r from Restaurant r where r.restaurantName=?1")
	public Restaurant getResByName(String rName);

}
 