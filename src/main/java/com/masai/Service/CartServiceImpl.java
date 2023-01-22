package com.masai.Service;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CartNotFoundException;
import com.masai.Exceptions.ItemException;
import com.masai.Model.CustomerSession;
import com.masai.Model.FoodCart;
import com.masai.repository.CartDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.ItemsDao;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	public CustomerDao cDao;
	@Autowired
	public CartDao cartDao;

	@Autowired
	public ItemsDao itemDao;

	@Autowired
	public CustomerSessionDao csDao;

	// 5 =======Customer
	@Override
	public FoodCart addItemToCart(Integer itemId, String uniueId) {
		FoodCart foodCart = null;

		CustomerSession cs = csDao.findByUniqueId(uniueId);
		if (cs != null) {
			foodCart = cartDao.findByCustumerId(cs.getCustomerId());
			if (foodCart != null) {
				Optional<Item> opt = itemDao.findById(itemId);
				if (opt.isPresent()) {
					foodCart.getItemList().add(opt.get());
					// foodCart = cartDao.save(foodCart);
					return cartDao.save(foodCart);

				} else {
					throw new ItemException("No item found with this itemId");
				}

			} else {
				foodCart = new FoodCart();
//				foodCart.setCustomerId(cs.getCustomerId());
				foodCart.setCartId(cs.getCustomerId());
				Optional<Item> opt = itemDao.findById(itemId);
				if (opt.isPresent()) {
					foodCart.getItemList().add(opt.get());
					foodCart = cartDao.save(foodCart);
					return cartDao.save(foodCart);
				} else {
					throw new ItemException("No item found with this itemId");
				}

			}
		}
		return foodCart;

	}



	//not working
	@Override
	public FoodCart clearCart(Integer cartId) throws CartNotFoundException {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if (opt.isPresent()) {
			FoodCart cart = opt.get();
			cartDao.delete(cart);
			return cart;
		} else {
			throw new CartNotFoundException("No Cart found with ID: " + cartId);
		}
	}

	@Override
	public FoodCart increaseQuantity(String unique_id, Integer item_id, Integer quantity)
			throws CartNotFoundException, ItemException {
		
		FoodCart cart=null;
		CustomerSession cs=csDao.findByUniqueId(unique_id);
		
		if(cs!=null)
		{
			 cart=cartDao.findByCustumerId(cs.getCustomerId());
			
			if(cart!=null) {
				
				Optional<Item> item=itemDao.findById(item_id);
				
				
				if(item.isPresent())
				{
					Item itm=item.get();
//					itm.setQuantity(itm.getQuantity() +quantity);
				
					
					
					cart.getItemList().add(itm);
					return cartDao.save(cart);
				}
			}
			else
			{
				throw new ItemException("No Item found with ID: " + item_id);
			}
			
		}
		else
		{
			throw new CartNotFoundException("no cart is there ");
		}
		return cart;
		
		
	}

	@Override
	public FoodCart reduceQuantity(String unique_id, Integer quantity, Integer item_Id)
			throws CartNotFoundException, ItemException {
		FoodCart cart=null;
		CustomerSession cs=csDao.findByUniqueId(unique_id);
		
		if(cs!=null)
		{
			 cart=cartDao.findByCustumerId(cs.getCustomerId());
			
			if(cart!=null) {
				
				Optional<Item> item=itemDao.findById(item_Id);
				
				
				if(item.isPresent())
				{
					Item items=item.get();
					Item it;
//					itm.setQuantity(itm.getQuantity()-quantity);
					
					
					cart.getItemList().add(items);
					return cartDao.save(cart);
				}
			}
			else
			{
				throw new ItemException("No Item found with ID: " + item_Id);
			}
			
		}
		else
		{
			throw new CartNotFoundException("no cart is there ");
		}
		return cart;
		
	}	
		
		
		


//	not working

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws CartNotFoundException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart viewCart(Integer cartid) throws CartNotFoundException {
		Optional<FoodCart> cart = cartDao.findById(cartid);
		if (cart.isPresent()) {
			throw new CartNotFoundException(" empty cart");
		} else {

			return cart.get();
		}

	}

	
	



}
