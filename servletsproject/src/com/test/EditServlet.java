package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Books</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        Book e=BookDAO.getBookById(id); 
	        
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>title:</td><td><input type='text' name='title' value='"+e.getTitle()+"'/></td></tr>");  
	        out.print("<tr><td>author:</td><td><input type='text' name='author' value='"+e.getAuthor()+"'/> </td></tr>");  
	        out.print("<tr><td>price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");  
	        out.print("</select>");  
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();
	 }
	    

}
