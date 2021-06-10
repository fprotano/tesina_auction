package it.exolab.tesina.exploid.bat.forauction;



public class AutoUpdate {
public static void main(String[]args) {
	java.sql.Connection conn = null;
	java.sql.Statement stmt = null;
	 try {
	    try {
	       Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception e) {
	   System.out.println(e);
	}
		conn = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/tesina_auction?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "Alessio01!"); // modificare con vostro indirizzo
		System.out.println("Connessione effetuata:");
		stmt = (java.sql.Statement) conn.createStatement();
		String query1 = "update auction SET  closed_auction_at = now() where NOW() > end_auction_at; ";
		stmt.executeUpdate(query1);
		System.out.println("Record aggiornato .........-------->");
	 } catch (java.sql.SQLException e) {
	  
	 } catch (Exception x) {
	    
	 } finally {
	    try {
	       if (stmt != null)
	       conn.close();
	    } catch (java.sql.SQLException se) {}
	    try {
	       if (conn != null)
	       conn.close();
	    } catch (java.sql.SQLException se) {
	       se.printStackTrace();
	    }
	 }
    
  }

}

