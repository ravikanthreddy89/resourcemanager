package me.ravikanth.messenger.resources;

import jdk.nashorn.api.scripting.JSObject;
import me.ravikanth.messenger.dao.User;
import me.ravikanth.messenger.dao.UserDAO;
import me.ravikanth.messenger.dao.UserDAOImpl;
import me.ravikanth.messenger.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ragudipati on 7/19/15.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    @Path("/{nick}")
    @GET
    public User getUser(@PathParam("nick")String usernick){
        UserDAO userDAO = new UserDAOImpl();
        int ret = userDAO.getIdByNick(usernick);
        // set the headers apropriately
        User user = new User();
        user.setId(ret);
        user.setNick(usernick);
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        UserDAO userDAO= new UserDAOImpl();
        int ret = userDAO.insert(user);
        // set the headers appropriately
        return user;
    }

    // Delegate the responsibility to the subresourse
    @Path("/{user_id}/gamescores")
    public GameScoresResource gameScoresResource(){
        return new GameScoresResource();
    }
}
