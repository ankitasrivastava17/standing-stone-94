package com.masai.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;
import com.masai.Model.CustomerSession;
import com.masai.Model.Restaurant;
import com.masai.Model.RestaurantSession;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.RestaurantDao;
import com.masai.repository.RestaurantSessionDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private RestaurantDao rDao;

	@Autowired
	private CustomerSessionDao cSDao;

	@Autowired
	private RestaurantSessionDao rSDao;

	// 1. add customer
	@Override
	public Customer customerRegistration(Customer customer) {
		// check if the customer is already registered or not
		Customer customerExist = cDao.findByMobileNumber(customer.getMobileNumber());
		if (customerExist == null) {
			// register if not
			Customer newCustomer = cDao.save(customer);
			return newCustomer;
		} else {
			throw new CustomerException("You are already registered");
		}

	}

	// 2 update customer details
	@Override
	public Customer updateCustomerDetails(String uniqueId, Customer updatedcustomer) {
		// check login or not
		CustomerSession customerSession = cSDao.findByUniqueId(uniqueId);
		if (customerSession == null) {
			throw new CustomerException("Customer is not logged in");
		} else {
			Optional<Customer> opt = cDao.findById(customerSession.getCustomerId());
			Customer eixtingCustomer = opt.get();
			if (eixtingCustomer.getCustomerId() == customerSession.getCustomerId()) {
				Customer updated = cDao.save(updatedcustomer);
				return updated;
			} else {
				throw new CustomerException("Invalid update process");
			}
		}
	}

	// 3remove customer (BY ADMIN ONLY)
	String username = "ankita";
	String password = "ankita";

	@Override
	public Customer removeCustomer(String uniqueId, String userNameCustomer) {

		RestaurantSession ResSession = rSDao.findByUniqueId(uniqueId);

		if (ResSession != null) {
			Optional<Restaurant> opt = rDao.findById(ResSession.getRestaurantId());
			Restaurant admin = opt.get();
			if (admin.getContactNumber().equals(username)) {
				Customer targetCustomer = cDao.findByMobileNumber(userNameCustomer);
				if (targetCustomer != null) {
					cDao.delete(targetCustomer);
					return targetCustomer;
				} else {
					throw new CustomerException("No Customer found with this Username");
				}
			} else {
				throw new CustomerException("Admin must be logged in");
			}

		} else {
			throw new CustomerException("Please login first");
		}

	}

	// 4 view customer (customer checking his own details)(Customers uniqueId)
	@Override
	public Customer showCustomerDetails(String uniqueId) {
		// check login or not
		CustomerSession customerSession = cSDao.findByUniqueId(uniqueId);
		if (customerSession == null) {
			throw new CustomerException("Customer is not logged in");
		} else {
			Optional<Customer> opt = cDao.findById(customerSession.getCustomerId());
			Customer eixtingCustomer = opt.get();
			if (eixtingCustomer.getCustomerId() == customerSession.getCustomerId()) {
				return eixtingCustomer;
			} else {
				throw new CustomerException("You can not authorised to see the details");
			}
		}

	}

	// 5 get list of all customers (only by admin)
	@Override
	public List<Customer> getAllCustomerDetails(String uniqueId) {
		RestaurantSession ResSession = rSDao.findByUniqueId(uniqueId);
		if (ResSession != null) {
			Optional<Restaurant> opt = rDao.findById(ResSession.getRestaurantId());
			Restaurant admin = opt.get();
			if (admin.getContactNumber().equals(username)) {
				List<Customer> list = cDao.findAll();
				return list;
			} else {
				throw new CustomerException("Admin must be logged in");
			}

		} else {
			throw new CustomerException("Please login first");
		}

	}

}
