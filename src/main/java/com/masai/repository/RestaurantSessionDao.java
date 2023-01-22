package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.RestaurantSession;

@Repository
public interface RestaurantSessionDao extends JpaRepository<RestaurantSession, Integer>{
	public RestaurantSession findByUniqueId(String uId);
}
