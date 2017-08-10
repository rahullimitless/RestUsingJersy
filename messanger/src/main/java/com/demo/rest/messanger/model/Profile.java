package com.demo.rest.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String firstName;
	private String lastName;
	private String profileName;
	private Date created;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	public Profile(long id,String profileName,String firstName,String lastName)
	{
		this.id=id;
		this.profileName=profileName;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String prfileName) {
		this.profileName = prfileName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", profileName=" + profileName + ", created="
				+ created + "]";
	}
	
	

}
