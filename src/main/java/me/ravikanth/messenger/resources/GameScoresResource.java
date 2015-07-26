package me.ravikanth.messenger.resources;

import me.ravikanth.messenger.dao.GameScore;
import me.ravikanth.messenger.dao.GameScoreDAOImpl;
import me.ravikanth.messenger.dao.GameScoreDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ragudipati on 7/24/15.
 */


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameScoresResource {

    @Path("/{game_id}")
    @GET
    public GameScore getGameScore(GameScore gameScore, @PathParam("game_id")int game_id, @PathParam("user_id")int user_id){
        gameScore.setGame_id(game_id);
        gameScore.setUserId(user_id);
        GameScoreDAO gameScoreDAO = new GameScoreDAOImpl();
        gameScoreDAO.getGameScore(gameScore);
        return gameScore;
    }


    @Path("/{game_id}")
    @PUT
    public GameScore updateGameScore(GameScore gameScore, @PathParam("game_id")int game_id, @PathParam("user_id")int user_id){
        gameScore.setGame_id(game_id);
        gameScore.setUserId(user_id);
        GameScoreDAO gameScoreDAO = new GameScoreDAOImpl();
        gameScoreDAO.updateGameScore(gameScore);
        return gameScore;
    }

    @POST
    public GameScore insertGameScore(GameScore gameScore,  @PathParam("user_id")int user_id){
        gameScore.setUserId(user_id);
        GameScoreDAO gameScoreDAO = new GameScoreDAOImpl();
        gameScoreDAO.updateGameScore(gameScore);
        return gameScore;
    }

}
