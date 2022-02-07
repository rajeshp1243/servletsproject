package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Updateclass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	System.out.println("iam in update servlet class");
	    	 String title = request.getParameter("title");
	         String author = request.getParameter("author");
	         float price = Float.parseFloat(request.getParameter("price"));
	  
	         Book newBook = new Book(title, author, price);
	         try {
				bookDAO.update(newBook);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         response.sendRedirect("index.jsp");
	    	
	}


}
