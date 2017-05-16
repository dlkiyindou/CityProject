package cityproject.repositories;

import java.sql.SQLException;
import java.sql.Statement;

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

}
