package it.exolab.tesina.exploid.bat.forauction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoUpdate {
public static void main(String[]args) {
	 Connection conn = null;
     Statement stmt = null;
     try {
        try {
           Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
           System.out.println(e);
        }
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tesina_auction", "root", "root"); // modificare con vostro indirizzo
        System.out.println("Connessione effetuata:");
        stmt = (Statement) conn.createStatement();
        String query1 = "update auction SET  closed_auction_at = now() where NOW() > end_auction_at; ";
        stmt.executeUpdate(query1);
        System.out.println("Record aggiornato .........-------->");
     } catch (SQLException e) {
      
     } catch (Exception x) {
        
     } finally {
        try {
           if (stmt != null)
           conn.close();
        } catch (SQLException se) {}
        try {
           if (conn != null)
           conn.close();
        } catch (SQLException se) {
           se.printStackTrace();
        }
     }
    
  }

}

