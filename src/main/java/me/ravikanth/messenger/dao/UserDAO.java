package me.ravikanth.messenger.dao;

/**
 * Created by ragudipati on 7/19/15.
 */
public interface UserDAO {
    public int getIdByNick(String nick);
    public int insert(User user);
}
