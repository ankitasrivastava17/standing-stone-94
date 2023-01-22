package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Model.Customer;

@Service
public interface CustomerService {

	public Customer customerRegistration(Customer customer);

	public Customer updateCustomerDetails(String uniqueId, Customer updatedcustomer);

	public Customer removeCustomer(String uniqueId, String userNameCustomer);

	public Customer showCustomerDetails(String uniqueId);

	public List<Customer> getAllCustomerDetails(String uniqueId);
}
