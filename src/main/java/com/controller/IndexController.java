package com.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
//STEP 1. Import required packages
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		//FirstExample();
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//FirstExample();
		return "index";
	}

	public void FirstExample() {
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/deneme";

		// Database credentials
		String USER = "deneme";
		String PASS = "asd123";

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT tutorial_id, tutorial_title,  tutorial_author, submission_date FROM tutorials_tbl";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int tutorial_id = rs.getInt("tutorial_id");
				String tutorial_title = rs.getString("tutorial_title");
				String tutorial_author = rs.getString("tutorial_author");
				Date submission_date = rs.getDate("submission_date");

				// Display values
				System.out.print("tutorial_id: " + tutorial_id);
				System.out.print(", tutorial_title: " + tutorial_title);
				System.out.print(", tutorial_author: " + tutorial_author);
				System.out.println(", submission_date: " + submission_date);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end FirstExample

}
