package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.websocket.Session;

public class Servletconnection {
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String username = "postgres";
    private static final String password = "123";
    
    private static final String insertQuery ="INSERT INTO \"feedback\" (email, phone, message) VALUES (?, ?, ?) RETURNING id; ";
    private  final String findQuery = "SELECT * FROM \"feedback\" ";
    
    Connection conne = null;
    
    public Connection connectToDatabase() {
    	try {
			conne = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return conne;
    }
    
    public boolean exitUser(String email, String phone) {
    	try {
			Statement st = connectToDatabase().createStatement();
			
			if(st != null) {
				ResultSet res = st.executeQuery(this.findQuery);
				while(res.next()) {
				    String dbEmail = res.getString("email");
				    String dbPhone = res.getString("phone");
					if(email.equals(dbEmail) || phone.equals(dbPhone)) {
						return true;
					}
				}
				 res.close();
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return false;
    	
    }
    
     public int inserData(String email, String phone, String message) {
         int id = -1;
         try {	
             PreparedStatement pstmt = connectToDatabase().prepareStatement(insertQuery);
             if (pstmt != null) {
                 pstmt.setString(1, email);
                 pstmt.setString(2, phone);
                 pstmt.setString(3, message);

                 ResultSet rs = pstmt.executeQuery(); 
                 if (rs.next()) {
                     id = rs.getInt("id");
                 }	
                 
                 rs.close();
                 pstmt.close();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return id;
    }
}
