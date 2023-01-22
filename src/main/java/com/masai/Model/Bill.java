package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;

	@NotEmpty
	@NotBlank
	@Size(min=2,max=10,message="Name should be 3 to 10")
	private String customerName;

	private LocalDateTime billDate;

	private Double totalCost;

	private Integer totalItem;

	@Embedded
	Address c_Add;

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public Address getC_Add() {
		return c_Add;
	}

	public void setC_Add(Address c_Add) {
		this.c_Add = c_Add;
	}

	public Bill(Integer billId, String customerName, LocalDateTime billDate, Double totalCost, Integer totalItem,
			Address c_Add) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.billDate = billDate;
		this.totalCost = totalCost;
		this.totalItem = totalItem;
		this.c_Add = c_Add;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", customerName=" + customerName + ", billDate=" + billDate + ", totalCost="
				+ totalCost + ", totalItem=" + totalItem + ", c_Add=" + c_Add + "]";
	}
	
	
	

}

