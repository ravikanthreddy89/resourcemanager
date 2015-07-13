package me.ravikanth.messenger.database;

import java.util.Map;
import java.util.HashMap;

import me.ravikanth.messenger.model.*;


public class Database {

	private static Map<Long, Message> messages = new HashMap();
	private static Map<String, Profile> profiles = new HashMap();

	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
