package com.masai.Model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.lang.NonNull;


public class Address
{	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, message = "Please enter valid addressId")
	private String addressId;
	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 10, message = "Building name should 2 to 10")
	private String buildingName;
	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, message = "Please enter valid street Number")
	private String streetNo;
	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 10, message = "Area name should 4 to 10")
	private String area;

	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 10, message = "City name should 4 to 10")
	private String city;
	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 15, message = "State name should 4 to 15")
	private String State;
	
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 15, message = "Country name should 4 to 15")
	private String country;


	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 6, max = 6, message = "Building name should 6")
	private String pincode;


	public String getAddressId() {
		return addressId;
	}


	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getStreetNo() {
		return streetNo;
	}


	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Address(@NotBlank @NotEmpty @Size(min = 1, message = "Please enter valid addressId") String addressId,
			@NotBlank @NotEmpty @Size(min = 4, max = 10, message = "Building name should 2 to 10") String buildingName,
			@NotBlank @NotEmpty @Size(min = 1, message = "Please enter valid street Number") String streetNo,
			@NotBlank @NotEmpty @Size(min = 4, max = 10, message = "Area name should 4 to 10") String area,
			@NotBlank @NotEmpty @Size(min = 4, max = 10, message = "City name should 4 to 10") String city,
			@NotBlank @NotEmpty @Size(min = 4, max = 15, message = "State name should 4 to 15") String state,
			@NotBlank @NotEmpty @Size(min = 4, max = 15, message = "Country name should 4 to 15") String country,
			@NotBlank @NotEmpty @Size(min = 6, max = 6, message = "Building name should 6") String pincode) {
		super();
		this.addressId = addressId;
		this.buildingName = buildingName;
		this.streetNo = streetNo;
		this.area = area;
		this.city = city;
		State = state;
		this.country = country;
		this.pincode = pincode;
	}


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", buildingName=" + buildingName + ", streetNo=" + streetNo
				+ ", area=" + area + ", city=" + city + ", State=" + State + ", country=" + country + ", pincode="
				+ pincode + "]";
	}
	
	
	
	

}
