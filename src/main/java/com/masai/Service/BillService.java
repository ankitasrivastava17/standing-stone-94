package com.masai.Service;

import java.time.LocalDate;
import java.util.List;

import com.masai.Exceptions.BillException;
import com.masai.Model.Bill;

public interface BillService {

	//6 customer ===> add services 
	public Bill addBill(Integer orderId, String uniqueId) throws BillException;

	public Bill removeBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill viewBill(Bill bill) throws BillException;

	public List<Bill> viewBills(Integer custId) throws BillException;

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;

	public double calculateTotalCost(Bill bill) throws BillException;

}
