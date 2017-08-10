package com.demo.rest.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.rest.messanger.database.DatabaseClass;
import com.demo.rest.messanger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService() {
		// TODO Auto-generated constructor stub
		profiles.put("Rahul",new Profile(1L,"Rahul","Rahul","Chaturvedi"));
		profiles.put("Saurabh",new Profile(2L,"Saurabh","Saurabh","Maheshwari"));
	}
	
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}

	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName)
	{
		return profiles.remove(profileName);
	}
}
