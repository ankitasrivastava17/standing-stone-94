package com.masai.Service; 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.ItemException;
import com.masai.Exceptions.RestaurantException;
import com.masai.Model.CustomerSession;
import com.masai.Model.Restaurant;
import com.masai.Model.RestaurantSession;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.RestaurantDao;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public Item createItem(String restaurantName, Item item) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item updateItem(String restaurantName, Item item) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewItem(String restaurantName, Integer itemid) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item removeItem(Integer restaurantId, String uniqueId, Item item)
			throws ItemException, RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemOfRestaurent(Integer restaurentId, String uniqueId)
			throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemByName(String name) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item addItemToRestaurant(String restaurantName, Item item)
			throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> addItemToRestaurant(String restaurantName, com.masai.Model.@Valid Item item)
			throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
