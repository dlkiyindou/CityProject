package cityproject.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import cityproject.infrastructures.Ville;

public class VilleRepository extends SQLiteDatabaseManager {
	private static VilleRepository INSTANCE = new VilleRepository();
	
	private VilleRepository() {
		super();
	}
	
	public static VilleRepository getInstance() {
		return INSTANCE;
	}
	
	public void createTable () throws SQLException {
		StringBuilder sql =  new StringBuilder();
		sql.append("CREATE TABLE IF NOT EXISTS ville (");
		sql.append("id INT AUTO_INCREMENT PRIMARY KEY,");
		sql.append("name VARCHAR(30)");
		sql.append(")");
		
		Statement st = getConnection().createStatement();
		
		st.execute(sql.toString());
	}
	
	public void saveVille (Ville ville) throws SQLException {
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			connection = getConnection();

			StringBuilder sql =  new StringBuilder();
			if (ville.getId() > 1) {
				sql.append("UPDATE ville SET name = ? WHERE id = ?");
				ps = connection.prepareStatement(sql.toString());
				ps.setString(1, ville.getNom());
				ps.setInt(2, ville.getId());
				ps.execute();
			} else {
				sql.append("INSERT INTO ville (name) VALUES (?)");
				ps = connection.prepareStatement(sql.toString());
				ps.setString(1, ville.getNom());
				ps.execute();
			}
		} catch (SQLException e) {
			
		} finally {
			if (ps != null) {
				ps.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	

}
