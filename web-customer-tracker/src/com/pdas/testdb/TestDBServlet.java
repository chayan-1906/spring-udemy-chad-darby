package com.pdas.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		
		// setup connection variables
		String username = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String jdbcDriver = "com.mysql.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println("Connecting to database: " + jdbcUrl);
			Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			printWriter.println("SUCCESS!!!");
			connection.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ServletException(exception);
		}
		
	}
	
}