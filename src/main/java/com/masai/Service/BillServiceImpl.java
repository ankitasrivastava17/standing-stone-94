package com.masai.Service;
import com.masai.Model.Item;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.BillException;
import com.masai.Model.Bill;
import com.masai.Model.Customer;
import com.masai.Model.CustomerSession;
import com.masai.Model.Order;
import com.masai.repository.BillDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.OrderDao;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	public BillDao bDao;

	@Autowired
	public CustomerSessionDao cSDao;

	@Autowired
	public OrderDao oDao;

	@Autowired
	public CustomerDao cDao;

	// 6 customer ===> add services
	@Override
	public Bill addBill(Integer orderId, String uniqueId) throws BillException {
		CustomerSession cs = cSDao.findByUniqueId(uniqueId);
		if (cs != null) {
			Optional<Order> opt = oDao.findById(orderId);
			Optional<Customer> optC = cDao.findById(cs.getCustomerId());
			if (opt.isPresent() && optC.isPresent()) {
				Order orders = opt.get();
				Customer customerDetails = optC.get();
				Bill bill = new Bill();
				bill.setBillDate(orders.getOrderDate());
				bill.setC_Add(customerDetails.getAddress());
				bill.setCustomerName(customerDetails.getFirstName() + " " + customerDetails.getLastName());

				List<Item> listItems = (List<Item>) orders.getCart().getItemList();
				double totalCost = 0;
				Integer totalItem = 0;
				for (Item i : listItems) {
					totalCost += i.getQuantity() * i.getCostPerUnit();
					totalItem += i.getQuantity();
				}
				bill.setTotalCost(totalCost);

				bill.setTotalItem(totalItem);

				bDao.save(bill);
				return bill;
			} else {
				throw new BillException("Wrong order Id , please pass correct Order Id");
			}

		} else {
			throw new BillException("Customer is not logged in");
		}
	}
	
	@Override
	public Bill removeBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());

		if (opt.isPresent()) {
			bDao.delete(bill);

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return bill;

	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());
		Bill uBill = null;
		if (opt.isPresent()) {
			uBill = bDao.save(opt.get());

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return uBill;
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		Optional<Bill> opt = bDao.findById(bill.getBillId());
		Bill existingBill = null;
		if (opt.isPresent()) {

			existingBill = opt.get();

		} else {
			throw new BillException("No bill found by " + bill.getBillId() + " id");
		}

		return existingBill;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalCost(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return 0;
	}

}
