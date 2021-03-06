package com.diksha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example
 */
@WebServlet("/Bills.do")
public class Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("Index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String title=request.getParameter("title");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String Age=request.getParameter("Age");
		String DOB=request.getParameter("DOB");
		
		
		if(title==null || firstname==null || lastname==null || Age==null || DOB==null)
		{
			//response.sendRedirect("Index.html");
			return;
		}
	
		
		
		
		if(firstname.length()<3 || lastname.length()<3 )
		{
			System.out.println("Invalid name or last name");
		}
		
		PrintWriter out=response.getWriter();
		out.println("<h1>Hi "+firstname+"! Your details </h1>");
		out.println("<h2> Age="+Age+"! Your details </h2>");
		out.println("<h2> Date OF Birth="+DOB+"</h2>");
		out.println("<h2> Saved </h2>");
		
		
		
		
		ADDAccDOA customerdao = new ADDAccDOA();
		customerdao.create(new Customer(title, firstname, lastname, Age, DOB)); 
		
		out.close();
		doGet(request, response);
	}

}
