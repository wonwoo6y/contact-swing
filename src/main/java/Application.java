import java.sql.SQLException;

public class Application {
	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mariadb://localhost:3306";
		String dbId = "root";
		String dbPassword = "1234";
		String dbName = "contacts";
		DataBase dataBase = new DataBase(dbUrl, dbId, dbPassword, dbName);
		new MenuGUI(dataBase);
	}
}
