package com.masai.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "first name should 3 to 10")
	private String firstName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "last name should 3 to 10")
	private String lastName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Min(value = 10, message = "minimum age required 10 for registration")
	private Integer age;

	@NotBlank
	@NotEmpty
	private String gender;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 10, max = 10, message = "mobile number must be 10 digit only")
	private String mobileNumber;
	private String email;
	private String password;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	public FoodCart fcart;
//	

	@Embedded
	private Address address;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Customer(Integer customerId,
			@NotBlank @NotEmpty @Size(min = 3, max = 10, message = "first name should 3 to 10") String firstName,
			@NotBlank @NotEmpty @Size(min = 3, max = 10, message = "last name should 3 to 10") String lastName,
			@NotBlank @NotEmpty @Min(value = 10, message = "minimum age required 10 for registration") Integer age,
			@NotBlank @NotEmpty String gender,
			@NotBlank @NotEmpty @Size(min = 10, max = 10, message = "mobile number must be 10 digit only") String mobileNumber,
			String email, String password, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password="
				+ password + ", address=" + address + "]";
	}

	
	
}
