package com.masai.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

 public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	@Size(min = 3, max = 10, message = "Item Name  should 3 to 20")
	private String itemName;

	@Size(min = 3, max = 10, message = "Category name should 3 to 20")
	private String category;

	private Integer quantity;

	private Integer costPerUnit;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemList") //
	private List<Restaurant> listOfRestaurants = new ArrayList<>();

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(Integer costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public List<Restaurant> getListOfRestaurants() {
		return listOfRestaurants;
	}

	public void setListOfRestaurants(List<Restaurant> listOfRestaurants) {
		this.listOfRestaurants = listOfRestaurants;
	}

	public Item(Integer itemId, @Size(min = 3, max = 10, message = "Item Name  should 3 to 20") String itemName,
			@Size(min = 3, max = 10, message = "Category name should 3 to 20") String category, Integer quantity,
			Integer costPerUnit, List<Restaurant> listOfRestaurants) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.costPerUnit = costPerUnit;
		this.listOfRestaurants = listOfRestaurants;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity=" + quantity
				+ ", costPerUnit=" + costPerUnit + ", listOfRestaurants=" + listOfRestaurants + "]";
	}
	
	

}
