package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
          response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
          String sid=request.getParameter("id");  
          int id=Integer.parseInt(sid);  
          String title=request.getParameter("title");  
          String author=request.getParameter("author");  
          String price=request.getParameter("price"); 
          float pr=Float.parseFloat(price);
          System.out.println(id+" "+title+" "+author+" "+price);
         
          Book b=new Book();  
          b.setId(id);  
          b.setTitle(title);  
          b.setAuthor(author);  
          b.setPrice(pr);  
          //e.setCountry(country); 
          System.out.println(b);
            
          int status=BookDAO.update(b);  
          if(status>0){  
              response.sendRedirect("ViewServlet.jsp");  
          }else{  
              out.println("Sorry! unable to update record");  
          }  
            
          out.close();  
      }  
  
            


}
