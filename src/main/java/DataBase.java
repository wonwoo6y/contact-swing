import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			+ "PRIMARY KEY (student_id)"
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

	public boolean insertFriends(String name, String birthDate, String phoneNumber, String studentId) {
		try {
			String selectionSql = "SELECT * FROM friends WHERE student_id = ?;";
			PreparedStatement selectionStatement = connection.prepareStatement(selectionSql);
			selectionStatement.setString(1, studentId);
			ResultSet resultSet = selectionStatement.executeQuery();
			selectionStatement.close();
			if (resultSet.next()) {
				System.out.println("학번 데이터 존재");
				resultSet.close();
				return false;
			}
			resultSet.close();
			String insertionSql = "INSERT INTO friends(name, birth_date, phone_number, student_id) values (?, ?, ?, ?);";
			PreparedStatement insertionStatement = connection.prepareStatement(insertionSql);
			insertionStatement.setString(1, name);
			insertionStatement.setString(2, birthDate);
			insertionStatement.setString(3, phoneNumber);
			insertionStatement.setString(4, studentId);
			insertionStatement.executeUpdate();
			insertionStatement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
