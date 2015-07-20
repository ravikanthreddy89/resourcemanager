package me.ravikanth.messenger.resources;

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
public class UserResource {


    @Path("/{nick}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int getUser(@PathParam("nick")String usernick){
        UserDAO userDAO = new UserDAOImpl();
        int ret = userDAO.getIdByNick(usernick);
        return ret;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        UserDAO userDAO= new UserDAOImpl();
        int ret = userDAO.insert(user);
        return user;
    }
}
