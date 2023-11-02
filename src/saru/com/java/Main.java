package saru.com.java;

import java.sql.*; // 1) Import package

/*
 * 
 * 1) Import package -> java.sql.*
 * 2) Load and register the driver -> com.mysql.jdbc.Driver
 * 3) Create connection
 * 4) Create a statement
 * 5) Execute the query
 * 6) Process the results
 * 7) Close
 * 
 */

public class Main 
{

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/school";
		String dbUser = "saru";
		String dbPass = "password";
		String query = "SELECT * FROM students WHERE id = 5";
		
		Class.forName("com.mysql.jdbc.Driver"); // 2) Load and Register the driver
		Connection con = DriverManager.getConnection(url, dbUser, dbPass); // 3) Create connection
		Statement st = con.createStatement(); // 4) Create statement
		ResultSet rs = st.executeQuery(query); // 5) Execute the query
		
		rs.next();
		String name = rs.getString("username"); // 6) Process the result
		
		System.out.println(name);
		
		st.close(); // 7) Close the statement
		con.close(); // 7) Close the connection
	}

}
