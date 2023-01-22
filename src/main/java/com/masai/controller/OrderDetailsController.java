package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Order;
import com.masai.Service.OrderService;

@RestController
public class OrderDetailsController {
	@Autowired
	public OrderService oService;

	@PostMapping("/placeorder/{cartId}/{uniqueId}")
	public ResponseEntity<Order> addOrder(@PathVariable("cartId") Integer cartId,
			@PathVariable("uniqueId") String uniqueId) {
		Order orderDetails = oService.addOrder(cartId, uniqueId);

		return new ResponseEntity<Order>(orderDetails, HttpStatus.OK);

	}

}
