package br.com.ctg.crudservlet.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionFactory {

	public Connection open() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_servlet?useTimeZone=true&serverTimezone="+ TimeZone.getDefault().getID(),"root","100420");
	}
	
}
