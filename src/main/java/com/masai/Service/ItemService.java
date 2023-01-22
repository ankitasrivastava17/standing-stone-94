package com.masai.Service;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.ItemException;
import com.masai.Exceptions.RestaurantException; 

@Service
public interface ItemService
{
	public Item createItem(String restaurantName, Item item) throws ItemException;

	public Item updateItem(String restaurantName, Item item) throws ItemException;

	public List<Item> viewItem(String restaurantName, Integer itemid) throws ItemException;

	public Item removeItem(Integer restaurantId, String uniqueId, Item item)
			throws ItemException, RestaurantException;

	public List<Item> viewAllItemOfRestaurent(Integer restaurentId,String uniqueId) throws ItemException;

	public List<Item> viewAllItemByName(String name) throws ItemException;

	public List<Item> addItemToRestaurant(String restaurantName, com.masai.Model.@Valid Item item) throws ItemException;

	Item addItemToRestaurant(String restaurantName, Item item) throws ItemException;

}
