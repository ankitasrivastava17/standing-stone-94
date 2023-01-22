package com.masai.Service;
import com.masai.Exceptions.CartNotFoundException;
import com.masai.Exceptions.CustomerLoginException;
import com.masai.Exceptions.ItemException;
import com.masai.Model.FoodCart;

public interface CartService {
	
	public FoodCart addItemToCart(Integer itemId, String uniueId)
			throws CartNotFoundException, ItemException, CustomerLoginException;

	public FoodCart increaseQuantity(String unique_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException;

	public FoodCart reduceQuantity(String unique_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException;

	public FoodCart removeItem(Integer cartId, Integer itemId) throws CartNotFoundException, ItemException;

	public FoodCart clearCart(Integer cartId) throws CartNotFoundException;

	public FoodCart viewCart(Integer cartid) throws CartNotFoundException;

	

}
