package com.masai.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.masai.Exceptions.OrderException;
import com.masai.Model.Customer;
import com.masai.Model.Order;
import com.masai.Model.Restaurant;


@Service
public interface OrderService {
	// 6 customer ====>// place your order
	public Order addOrder(Integer cartId, String uniqueId) throws OrderException;

	public Order removeOrder(Order order) throws OrderException;

	public Order updateOrder(Order order) throws OrderException;

	public Order viewOrder(Order order) throws OrderException;

	public List<Order> viewAllOrders(Restaurant res) throws OrderException;

	public List<Order> viewAllOrders(Customer customer) throws OrderException;

}
