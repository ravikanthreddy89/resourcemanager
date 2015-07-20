package me.ravikanth.messenger.dao.conn;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.ConnectionFactory;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ragudipati on 7/19/15.
 */


public class PoolingDataSourceImpl {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/mydb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "willsmith";
	private GenericObjectPool connectionPool = null;

	private static PoolingDataSourceImpl instance;
    private static DataSource dataSource;

	private PoolingDataSourceImpl(){
		//
		// Load JDBC Driver class.
		//
		try {
			Class.forName(PoolingDataSourceImpl.DRIVER).newInstance();
			dataSource = setupDataSource();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

   public synchronized static PoolingDataSourceImpl getInstance(){
	   if(instance == null){
		   instance = new PoolingDataSourceImpl();
	   }
	   return instance;
   }


	public DataSource getDataSource(){
        return dataSource;
	}

	private static DataSource setupDataSource() {
		//
		// First, we'll create a ConnectionFactory that the
		// pool will use to create Connections.
		// We'll use the DriverManagerConnectionFactory,
		// using the connect string passed in the command line
		// arguments.
		//
		ConnectionFactory connectionFactory =
				new DriverManagerConnectionFactory(PoolingDataSourceImpl.URL,
						PoolingDataSourceImpl.USERNAME,
						PoolingDataSourceImpl.PASSWORD);
		//
		// Next we'll create the PoolableConnectionFactory, which wraps
		// the "real" Connections created by the ConnectionFactory with
		// the classes that implement the pooling functionality.
		//
		PoolableConnectionFactory poolableConnectionFactory =
				new PoolableConnectionFactory(connectionFactory, null);
		//
		// Now we'll need a ObjectPool that serves as the
		// actual pool of connections.
		//
		// We'll use a GenericObjectPool instance, although
		// any ObjectPool implementation will suffice.
		//
		ObjectPool<PoolableConnection> connectionPool =
				new GenericObjectPool<>(poolableConnectionFactory);
		// Set the factory's pool property to the owning pool
		poolableConnectionFactory.setPool(connectionPool);

		//
		// Finally, we create the PoolingDriver itself,
		// passing in the object pool we created.
		//
		PoolingDataSource<PoolableConnection> dataSource =
				new PoolingDataSource<PoolableConnection>(connectionPool);

		return dataSource;
	}
}
