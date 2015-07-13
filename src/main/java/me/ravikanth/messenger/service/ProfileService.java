package me.ravikanth.messenger.service;

import me.ravikanth.messenger.database.Database;
import me.ravikanth.messenger.model.Profile;

import java.util.Map;

public class ProfileService {

	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService(){
		profiles.put("Raka", new Profile(1L, "Raka", "Ravikanth", "Gudipati"));
		profiles.put("Saka", new Profile(2L, "Saka", "Saikanth", "Guidpati"));
	}
	
	
	public Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	public Profile createProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile){
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	
}
