package me.ravikanth.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.ravikanth.messenger.database.Database;
import me.ravikanth.messenger.model.Message;

public class MessageService{
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hello from Ravikanth", "Ravikanth"));
		messages.put(2L, new Message(2, "Hello from Saikanth", "Saikanth"));
	}
	
	private Map<Long, Message> messages = Database.getMessages();
		
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put((long) (messages.size()+1), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	} 
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
}
