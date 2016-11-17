package com.shrikantmanasi;

import java.io.Serializable;

public class Synergy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3625396076743805333L;
	
	private String name;
	private String email;
	private String contactNumber;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
