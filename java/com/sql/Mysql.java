package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {

	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	}
}

