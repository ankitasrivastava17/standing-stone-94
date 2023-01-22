package com.masai.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CartNotFoundException;
import com.masai.Exceptions.OrderException;
import com.masai.Model.Customer;
import com.masai.Model.CustomerSession;
import com.masai.Model.FoodCart;
import com.masai.Model.Order;
import com.masai.Model.Restaurant;
import com.masai.repository.CartDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderDao oDao;

	@Autowired
	public CustomerSessionDao cSDao;

	@Autowired
	public CartDao cDao;

	// place your order
	@Override
	public Order addOrder(Integer cartId, String uniqueId) {

		CustomerSession cs = cSDao.findByUniqueId(uniqueId);
		if (cs != null) {
			FoodCart foodCart = cDao.findByCustumerId(cs.getCustomerId());
			if (foodCart != null) {
				Order od = new Order();
				od.setOrderDate(LocalDateTime.now());
				od.setOrderStatus("Placed");
				od.setCart(foodCart);
				oDao.save(od);
				return od;

			} else {
				throw new CartNotFoundException("No item found in your cart");
			}
		} else {
			throw new OrderException("customer is not logged in");
		}

	}

	@Override
	public Order removeOrder(Order order) throws OrderException {
		Optional<Order> opt = oDao.findById(order.getOrderId());

		if (opt.isPresent()) {
			oDao.delete(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return order;
	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		Optional<Order> opt = oDao.findById(order.getOrderId());
		Order updatedOrder = null;
		if (opt.isPresent()) {
			updatedOrder = oDao.save(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return updatedOrder;
	}

	@Override
	public Order viewOrder(Order order) throws OrderException {
		Optional<Order> opt = oDao.findById(order.getOrderId());
		Order exitstingOrder = null;
		if (opt.isPresent()) {
			exitstingOrder = opt.get();

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return exitstingOrder;
	}

	@Override
	public List<Order> viewAllOrders(Restaurant res) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewAllOrders(Customer customer) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
