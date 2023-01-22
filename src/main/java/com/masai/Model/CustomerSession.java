package com.masai.Model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CustomerSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private Integer customerId;
	private String uniqueId;
	private LocalDateTime timeStamp;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getUniqueId() {
		return uniqueId;
	}



	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}



	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



	public CustomerSession(Integer customerId, String uniqueId, LocalDateTime timeStamp) {
		super();
		this.customerId = customerId;
		this.uniqueId = uniqueId;
		this.timeStamp = timeStamp;
	}
	
	
	
}
