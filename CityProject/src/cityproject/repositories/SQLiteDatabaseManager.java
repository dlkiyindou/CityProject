package cityproject.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cityproject.infrastructures.Ville;

public class SQLiteDatabaseManager {	
	
	/**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + getSQLiteDBPath();
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public Connection getConnection () throws SQLException {
    	String url = "jdbc:sqlite:" + getSQLiteDBPath();
        // create a connection to the database
    	
        return DriverManager.getConnection(url);
    }
    
    public static void main(String[] args) throws SQLException {
    	//connect();
    	System.out.println(getSQLiteDBPath());
    	VilleRepository.getInstance().createTable();
    	
    	Ville ville =  new Ville("Ma belle ville");
    	VilleRepository.getInstance().saveVille(ville);
    }


	public static String getSQLiteDBPath() {
    	return System.getProperty("user.dir") + System.getProperty("file.separator") + "data.sqlite" 
				+ System.getProperty("file.separator") + "data.db";
    }

}
