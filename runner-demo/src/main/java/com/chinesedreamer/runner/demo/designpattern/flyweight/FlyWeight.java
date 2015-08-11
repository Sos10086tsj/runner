package com.chinesedreamer.runner.demo.designpattern.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class FlyWeight {
	private Vector<Connection> pool;
	
	private String url="jdbc:mysql://localhost:3306/runner?characterEncoding=UTF-8";
	private String user="root";
	private String password="Password2";
	private String driverClass="com.mysql.jdbc.Driver";
	
	private static int poolSize = 100;
	private static FlyWeight instance = null;
	Connection conn = null;
	
	private FlyWeight(){
		pool = new Vector<Connection>(poolSize);
		for (int i = 0; i < poolSize; i++) {
			try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void release(){
		pool.add(conn);
	}
	
	public synchronized Connection getConnection(){
		if (pool.size() > 0) {
			Connection connection = pool.get(0);
			pool.remove(connection);
			return connection;
		}else {
			return null;
		}
	}
}
