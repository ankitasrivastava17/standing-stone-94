package com.masai.Model;
import antlr.collections.List;

public class FoodCart {
	
	private Integer cartId;
	private Customer customer;
	private List ItemList;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer integer) {
		this.cartId = integer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List getItemList() {
		return ItemList;
	}
	public void setItemList(List itemList) {
		ItemList = itemList;
	}
	public FoodCart(Integer cartId, Customer customer, List itemList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		ItemList = itemList;
	}
	public FoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", ItemList=" + ItemList + "]";
	}
	
	
	
	
}
