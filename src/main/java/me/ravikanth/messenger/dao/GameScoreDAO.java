package me.ravikanth.messenger.dao;

import me.ravikanth.messenger.dao.GameScore;

/**
 * Created by ragudipati on 7/24/15.
 */
public interface GameScoreDAO {
    public int getGameScore(GameScore gameScore);
    public int updateGameScore(GameScore gameScore);
}
