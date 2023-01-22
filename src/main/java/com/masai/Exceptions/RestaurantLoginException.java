package com.masai.Exceptions;

public class RestaurantLoginException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestaurantLoginException() {
		
	}
	
	public RestaurantLoginException(String message) {
		super(message);
	}

}
