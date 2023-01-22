package com.masai.Exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails
{

	private LocalDateTime timestamp;

	private String name;

	private String description;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", name=" + name + ", description=" + description + "]";
	}

	public MyErrorDetails(LocalDateTime timestamp, String name, String description) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.description = description;
	}

	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
