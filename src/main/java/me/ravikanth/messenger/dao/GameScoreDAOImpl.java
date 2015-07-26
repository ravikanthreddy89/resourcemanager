package me.ravikanth.messenger.dao;

import me.ravikanth.messenger.dao.conn.PoolingDataSourceImpl;

import java.sql.*;

/**
 * Created by ragudipati on 7/24/15.
 */
public class GameScoreDAOImpl implements GameScoreDAO {

    private Connection conn;
    private String query;
    private PreparedStatement stmt;
    private CallableStatement cstmt;
    private ResultSet rs;


    @Override
    public int getGameScore(GameScore gameScore) {
        String query = "select score from gamescores where game_id=? and user_id=?";
        int ret = -2;
        try {
            conn = PoolingDataSourceImpl.getInstance().getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,gameScore.getGame_id());
            stmt.setInt(2, gameScore.getUserId());

            stmt.execute();
            rs = stmt.getResultSet();
            if(rs != null){
              rs.next();
              int score = rs.getInt(1);
              gameScore.setScore(score);
              ret =0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally { // close the resources
            try {
              if(rs !=null) rs.close();
              if(stmt != null) stmt.close();
              if(conn !=null) conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    public int updateGameScore(GameScore gameScore){
       String proc = "call updateGameScore(?,?,?,?)";
       int ret = -2;
        try {
            conn = PoolingDataSourceImpl.getInstance().getDataSource().getConnection();
            cstmt = conn.prepareCall(proc);

            // set the parameters and register output parameters
            cstmt.setInt(1,gameScore.getGame_id());
            cstmt.setInt(2, gameScore.getUserId());
            cstmt.setInt(3, gameScore.getScore());
            cstmt.registerOutParameter(4, ret);

            cstmt.executeUpdate();

            // retrieve the output parameter
            ret = cstmt.getInt(4);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(cstmt != null) cstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
