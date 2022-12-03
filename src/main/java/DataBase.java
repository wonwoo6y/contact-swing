import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			+ "phone_number CHAR(13),"
			+ "student_id CHAR(8),"
			+ "PRIMARY KEY (phone_number)"
			+ ");";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}

	public String[] getFriendsFields() {
		String sql = "DESC friends;";
		ArrayList<String> fields = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			stmt.close();
			while (rs.next()) {
				fields.add(rs.getString("Field"));
			}
			rs.close();
		} catch (SQLException e) {
		}
		return fields.toArray(new String[0]);
	}

	public String[][] getFriendsData(String[] fields) {
		String[][] result;
		try {
			String sql = "SELECT * FROM friends;";
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			stmt.close();

			resultSet.last();
			result = new String[resultSet.getRow()][];
			resultSet.beforeFirst();
			for (int index = 0; index < result.length; index++) {
				result[index] = new String[fields.length];
			}

			for (int count = 0; resultSet.next(); count++) {
				for (int index = 0; index < fields.length; index++) {
					result[count][index] = resultSet.getString(fields[index]);
				}
			}
		} catch (SQLException e) {
			result = null;
		}
		return result;
	}
}
