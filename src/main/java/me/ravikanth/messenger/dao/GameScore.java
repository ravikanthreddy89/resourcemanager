package me.ravikanth.messenger.dao;

/**
 * Created by ragudipati on 7/24/15.
 */
public class GameScore {
    private int userId;
    private int score;
    private int game_id;


    GameScore(){}

    public GameScore(int userId, int score, int game_id) {
        this.userId = userId;
        this.score = score;
        this.game_id = game_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
}
