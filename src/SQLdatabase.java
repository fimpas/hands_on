import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLdatabase {

	// JDBC driver name and database URL
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	

	// Database credentials
	static final String USER = "root";
	static final String PASS = "Ajuste88"; // insert the password to SQL server

	public static void main(String[] args) { 
		Connection conn = null;
	Statement stmt = null;
	
	try {
		// Register JDBC driver 
		Class.forName(JDBC_DRIVER);
		// Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		/// Execute a query to create database
		System.out.println("Creating database...");
		
		stmt = conn.createStatement();
//		String sql = "DROP DATABASE STUDENTS"; // drops database students 
//		stmt.executeUpdate(sql);
//		System.out.println("Database created successfully...");
		
//		stmt = conn.createStatement();
//		String sql = "CREATE DATABASE STUDENTS"; // Create database students 
//		stmt.executeUpdate(sql);
//		System.out.println("Database created successfully...");
		
		// Connect to the created database STUDENTS and create table REGISTRATION
		conn = DriverManager.getConnection(DB_URL + "STUDENTS", USER, PASS); 
		String sql = "CREATE TABLE if not exists STUDENTS.REGISTRATION (`ID` INT, `First name` VARCHAR(255) NULL, `Last name` VARCHAR(255), `Age` INT UNSIGNED NULL, PRIMARY KEY (`ID`))"; // Create table REGISTRATION with corresponding attributes
		stmt.executeUpdate(sql) ;
		
		System.out.println("Created table in given database successfully..."); 
		
		// insert values into the table
//		sql = "INSERT INTO STUDENTS.REGISTRATION " + "VALUES (100, 'Anders ', 'Berg', 21)";
//		stmt.executeUpdate(sql); // repeat the procedure for all rows of the table 
//		System.out.println("Inserted records into the table...");
		
//		String sql = "INSERT INTO STUDENTS.REGISTRATION " + "VALUES (101, 'Anna ', 'Bellini', 20)";
//		stmt.executeUpdate(sql); // repeat the procedure for all rows of the table 
//		System.out.println("Inserted records into the table...");
		
//		String sql = "INSERT INTO STUDENTS.REGISTRATION " + "VALUES (102, 'Steve ', 'Warlock', 22)";
//		stmt.executeUpdate(sql); // repeat the procedure for all rows of the table 
//		System.out.println("Inserted records into the table...");
//		
//		String sql = "INSERT INTO STUDENTS.REGISTRATION " + "VALUES (103, 'Sumit ', 'Mittal', 24)";
//		stmt.executeUpdate(sql); // repeat the procedure for all rows of the table 
//		System.out.println("Inserted records into the table...");
		
		// create the java mysql update preparedstatement
		String query = "UPDATE STUDENTS.REGISTRATION SET Age = 22 WHERE ID = 103"; // Update age of Sumit Mittal 
		PreparedStatement preparedStmt = conn.prepareStatement(query); // execute p

//		String query = "update users set num_points = ? where first_name = ?";
//	    PreparedStatement preparedStmt = conn.prepareStatement(query);
//		preparedStmt.setInt   (1, 6000);
//	    preparedStmt.setString(2, "Fred");

	      // execute the java preparedstatement
	    preparedStmt.executeUpdate(query);
		
		// insert a new values to the table with preparedstatement
		query = "insert into students.registration values(104, 'Todor' , 'Nicolescu', 27) "
				+ "on duplicate key update ID=104;"; // finish the statement
//		preparedStmt.setInt(1, 104);
//	    preparedStmt.setString(2, "Todor");
//	    preparedStmt.setString(3, "Nicolescu");
//	    preparedStmt.setInt(4, 27);
	    preparedStmt.executeUpdate(query);
	    
		System.out.println("The table is updated...");
		conn.close();
		}
	
	catch(SQLException se) {
	//Handle errors for JDBC
	se.printStackTrace(); 
	}
	
	catch(Exception e) {
	//Handle errors for Class.forName
	e.printStackTrace(); 
	} 
	System.out.println("Goodbye!");
	}
}