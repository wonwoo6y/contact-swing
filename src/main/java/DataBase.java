import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	Connection connection;

	public DataBase(String url, String id, String password, String name) throws SQLException {
		connection = DriverManager.getConnection(url, id, password);
		makeDataBase(name);
		connectionDataBase(name);
		makeTable();
	}

	private void makeDataBase(String name) throws SQLException {
		String sql = "CREATE DATABASE IF NOT EXISTS " + name + ";";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

	private void connectionDataBase(String name) throws SQLException {
		String sql = "USE " + name + ";";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

	private void makeTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS friends ("
			+ "name VARCHAR(20),"
			+ "birth_date CHAR(10),"
			+ "phone_number CHAR(11),"
			+ "student_id CHAR(8),"
			+ "PRIMARY KEY (phone_number)"
			+ ");";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

}
