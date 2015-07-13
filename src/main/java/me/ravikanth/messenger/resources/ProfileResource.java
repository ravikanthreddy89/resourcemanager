package me.ravikanth.messenger.resources;

import java.util.ArrayList;
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

import me.ravikanth.messenger.service.ProfileService;
import me.ravikanth.messenger.model.Profile;


@Path("/profiles")
public class ProfileResource {

	ProfileService pfService = new ProfileService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(pfService.getProfiles().values());
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String name){
		return pfService.getProfile(name);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile createProfile(Profile profile){
		return pfService.createProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName")String pName, Profile profile){
		profile.setProfileName(pName);
		return pfService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
	public void removeProfile(@PathParam("profileName")String profileName){
		pfService.removeProfile(profileName);
	}
	
}
