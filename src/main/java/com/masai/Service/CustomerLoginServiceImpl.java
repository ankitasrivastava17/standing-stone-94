package com.masai.Service;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerLoginException;
import com.masai.Model.Customer;
import com.masai.Model.CustomerLoginDTO;
import com.masai.Model.CustomerSession;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;

import net.bytebuddy.utility.RandomString;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CustomerSessionDao cSDao;
	
	@Override
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException {
		
//		Customer ecs = cDao.findByMobileNumber(dto.getMobileNumber());
		Customer ecs = cDao.findByMobileNumber(dto.getMobileNumber());
		
		if(ecs==null) {
			throw new CustomerLoginException("Please enter a valid mobile number!");
		}
		
		Optional<CustomerSession> opt = cSDao.findById(ecs.getCustomerId());
		
		if(opt.isPresent()) {
			throw new CustomerLoginException("Customer already logged in!");
		}
		
		if(ecs.getPassword().equals(dto.getPassword())) {
			
			CustomerSession custSession = new CustomerSession(ecs.getCustomerId(),RandomString.make(8),LocalDateTime.now());
		
		    cSDao.save(custSession);
		    
		    return custSession.toString();
		}else {
			throw new CustomerLoginException("Enter valid password!");
		}
		
	}

	@Override
	public String customerLogout(String uniqueId) throws CustomerLoginException {
		
		CustomerSession validCustomer = cSDao.findByUniqueId(uniqueId);
		
		if(validCustomer == null) {
			throw new CustomerLoginException("invalid!");
		}
		
		cSDao.delete(validCustomer);
		return "Logged out!";
	}

	

}
