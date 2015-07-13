package me.ravikanth.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.ravikanth.messenger.service.MessageService;
import me.ravikanth.messenger.model.Message;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return msgService.getAllMessages();
	}
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId")long id){
		return msgService.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return msgService.addMessage(message);
	}
	
	
	
	@Path("/{messageId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return msgService.updateMessage(message);
	}
	
	@Path("/{messageId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")long id){
		msgService.removeMessage(id);
	}
	
}
