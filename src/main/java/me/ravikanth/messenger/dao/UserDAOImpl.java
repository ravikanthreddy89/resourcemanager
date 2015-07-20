package me.ravikanth.messenger.dao;

import jdk.nashorn.internal.codegen.CompilerConstants;
import me.ravikanth.messenger.dao.conn.PoolingDataSourceImpl;

import java.sql.*;

/**
 * Created by ragudipati on 7/19/15.
 */
public class UserDAOImpl implements UserDAO {

    private Connection conn;
    private String query;
    private PreparedStatement stmt;
    private CallableStatement cstmt;
    private ResultSet rs;


    @Override
    public int getIdByNick(String nick) {
        int ret =-1;
        query = "select id from users where nick=?";
        try {
            conn = PoolingDataSourceImpl.getInstance().getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,nick);

            boolean executionStatus = stmt.execute();
            rs = stmt.getResultSet();

            if(executionStatus && rs!=null){
                 rs.next();
                 ret = rs.getInt(1);
            }else {
                 // user not found or error occured during execution
                 ret = -2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public int insert(User user) {
        int ret=-2;
        String proc_name = "call insertUser(?,?,?,?,?)";
        try {
            conn = PoolingDataSourceImpl.getInstance().getDataSource().getConnection();
            cstmt = conn.prepareCall(proc_name);
            cstmt.setString(1,user.getNick());
            cstmt.setString(2,user.getFirstName());
            cstmt.setString(3,user.getLastName());
            cstmt.registerOutParameter(4, Types.INTEGER);
            cstmt.registerOutParameter(5,Types.INTEGER);

            cstmt.executeUpdate();

            //if(status){
                int pId = cstmt.getInt(4);
                user.setId(pId);
                int pRet = cstmt.getInt(5);
                if(pRet == 0){
                  ret = 0;
                }else {
                    ret = pRet;
                }
            //}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
