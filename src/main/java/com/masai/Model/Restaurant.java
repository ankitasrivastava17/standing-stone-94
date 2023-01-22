package com.masai.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.lang.NonNull;


@Entity
public class Restaurant
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Restaurent name should 3 to 10")
	private String restaurantName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Restaurent Manager Name name should 3 to 10")
	private String managerName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 10, max = 10, message = "Contact Number should 3 to 10")
	private String contactNumber;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password length should be 3 to 10")
	private String password;

	@Embedded
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Restaurant(Integer restaurantId,
			@NotBlank @NotEmpty @Size(min = 3, max = 10, message = "Restaurent name should 3 to 10") String restaurantName,
			@NotBlank @NotEmpty @Size(min = 3, max = 10, message = "Restaurent Manager Name name should 3 to 10") String managerName,
			@NotBlank @NotEmpty @Size(min = 10, max = 10, message = "Contact Number should 3 to 10") String contactNumber,
			@NotBlank @NotEmpty @Size(min = 3, max = 10, message = "Password length should be 3 to 10") String password,
			Address address, List<Item> itemList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.password = password;
		this.address = address;
		this.itemList = itemList;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + ", password=" + password + ", address=" + address
				+ ", itemList=" + itemList + "]";
	}
	
	

}
