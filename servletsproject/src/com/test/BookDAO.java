package com.test;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class BookDAO {
     
       public static int insertBook(com.test.Book book){  
        int status=0;  
        try{  
            Connection con=BookDAO.getConnection();  
            PreparedStatement statement=con.prepareStatement(  
                         "INSERT INTO book (title, author, price) VALUES (?, ?, ?)");  
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
              
            status=statement.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
    
    
    public static int update(com.test.Book book){  
        int status=0;  
        try{  
            Connection con=BookDAO.getConnection();  
            PreparedStatement statement=con.prepareStatement(  
            		 "update book set title=?,author=?,price=? Where book_id = ?");  
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            statement.setInt(4, book.getId());
            
              
            status=statement.executeUpdate();  
            System.out.println(status);
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  

    
    
    public static Book getbookById(int id) throws SQLException{  
        Book b=null;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from book where book_id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                b=new Book();  
                String title = rs.getString("title");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                 
                //book = new Book(id, title, author, price);
  
            }  
        }catch(Exception e){System.out.println(e);}                    
        return b;  
    }  
    
   public static List<Book> getAllBooks(){  
        List<Book> list=new ArrayList<Book>();  
          
        try{  
            Connection con=BookDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from book");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
               // Book e=new Book(); 
                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                Book book = new Book(id, title, author, price);
                list.add(book);
                        
                 
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
   
   public static Book getBookById(int id){  
       Book b=new Book();  
         
       try{  
           Connection con=BookDAO.getConnection();  
           PreparedStatement ps=con.prepareStatement("select * from book where book_id=?");  
           ps.setInt(1,id);  
           ResultSet rs=ps.executeQuery();  
           if(rs.next()){  
        	   String title = rs.getString("title");
               String author = rs.getString("author");
               float price = rs.getFloat("price");
                
               b = new Book(id, title, author, price); 
               System.out.println(b);
           }  
           con.close();  
       }catch(Exception ex){ex.printStackTrace();}  
         
       return b;  
   }  

   public static int delete(int id){  
       int status=0;  
       try{  
           Connection con=BookDAO.getConnection();  
           PreparedStatement ps=con.prepareStatement("delete from book where book_id=?");  
           ps.setInt(1,id);  
           status=ps.executeUpdate();  
             
           con.close();  
       }catch(Exception e){e.printStackTrace();}  
         
       return status;  
   }  
  
   
}