package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com")
@PropertySource("com/application.properties")
public class DataBaseConnections {
	@Value("${mysqlurl}")
	private String url;
	@Value("${mysqlpassword}")
	private String password;
	@Value("${mysqlusername}")
	private String username;
	@Value("${mysqlDriverClass}")
	private String driverClassName;

	public Connection mysqlDbConnections() {
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;

	}
	
	

	@Override
	public String toString() {
		return "DataBaseConnections [url=" + url + ", password=" + password + ", username=" + username
				+ ", driverClassName=" + driverClassName + "]";
	}
	
	
	

//	public void oracleDbConnections() {
//		try {
//			DriverManager.getConnection("urloracle", "oracleuser", "oraclepassword");
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//	}

}
