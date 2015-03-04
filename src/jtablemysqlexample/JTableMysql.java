package jtablemysqlexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JTableMysql {

    
    public static void main(String[] args) {
    
        Connection             conn  = null;        
        PreparedStatement   pstmt = null;
        ResultSet            rs    = null;
        
        try {
                        
            Class.forName("com.mysql.jdbc.Driver");
            Properties connInfo = new Properties();
            
            connInfo.put("characterEncoding","UTF8");
            connInfo.put("user", "root");
            connInfo.put("password", "776776");
            
            
                
            
            
            conn  = DriverManager.getConnection("jdbc:mysql://localhost:3309/adventureworks", connInfo);
            
            pstmt = conn.prepareStatement("SELECT * FROM address");
            
            if(pstmt.execute()) {
                rs = pstmt.getResultSet();                                
                
                while (rs.next()) {
                    //System.out.println(rs.getString(1));
                    System.out.println(rs.getString("AddressLine1"));
                }
            }                                    
        }
        catch (Exception ex) {            
            System.out.println(ex.toString());
            //ex.printStackTrace();
        }
        finally {
            
            try {
                
                if (pstmt != null)
                    pstmt.close();
                
                if (conn != null)
                    conn.close();                
            }
            catch (SQLException ex) {            
                System.out.println("On close: " + ex.toString());
                //ex.printStackTrace();
            }                        
            
        }        /*dsadasdasdsadasd*/
    }

}