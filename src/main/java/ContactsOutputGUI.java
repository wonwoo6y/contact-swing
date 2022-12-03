import java.awt.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContactsOutputGUI extends JFrame {
	private DataBase dataBase;
	private JButton selectionButton;
	private JTable studentIdTable;
	private JScrollPane studentIdScrollPane;
	private DefaultTableModel tableModel;
	private String[] tableColumnNames;
	private String[][] tableData;

	public ContactsOutputGUI(DataBase dataBase) {
		this.dataBase = dataBase;
		makeGUI();
	}

	private void makeGUI() {
		setProperties();
		setComponents();
		addComponents();
	}

	private void setProperties() {
		this.setTitle("연락처 출력 프레임");
		this.setLayout(null);
		this.setSize(400, 1000);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}

	private void setComponents() {
		setButtons();
		setTables();
		setStudentIdScrollPane(studentIdTable);
	}

	private void setButtons() {
		setSelectionButton();
	}

	private void setSelectionButton() {
		selectionButton = new JButton("출력");
		selectionButton.setBounds(175, 10, 50, 30);
		selectionButton.addActionListener(e -> {
			tableColumnNames = dataBase.getFriendsFields();
			tableData = dataBase.getFriendsData(tableColumnNames);
			tableColumnNames = addAgeField(tableColumnNames);
			tableData = addAgeData(tableData);
			tableModel = new DefaultTableModel(tableData, tableColumnNames);
			studentIdTable = new JTable(tableModel);
			this.remove(studentIdScrollPane);
			setStudentIdScrollPane(studentIdTable);
			this.add(studentIdScrollPane);
			System.out.println("데이터 출력");
		});
	}

	private String[] addAgeField(String[] fields) {
		String[] result = new String[fields.length + 1];
		result[0] = fields[0];
		result[1] = "Age";
		for (int index = 1; index < fields.length; index++) {
			result[index + 1] = fields[index];
		}
		return result;
	}

	private String[][] addAgeData(String[][] data) {
		String[][] result = new String[data.length][];
		for (int index = 0; index < result.length; index++) {
			result[index] = new String[data[0].length + 1];
		}

		for (int row = 0; row < data.length; row++) {
			result[row][0] = data[row][0];
			result[row][1] = getAge(data[row][1]);
			for (int col = 1; col < data[row].length; col++) {
				result[row][col + 1] = data[row][col];
			}
		}
		return result;
	}

	private String getAge(String date) {
		Calendar now = Calendar.getInstance();
		Integer currentYear = now.get(Calendar.YEAR);

		Integer inputYear = getYear(date);
		return String.valueOf(currentYear - inputYear + 1);
	}

	private Integer getYear(String date) {
		return Integer.parseInt(date.substring(0, 4));
	}

	private void setTables() {
		setStudentIdTable();
	}

	private void setStudentIdTable() {
		studentIdTable = new JTable();
	}

	private void setStudentIdScrollPane(Component component) {
		studentIdScrollPane = new JScrollPane(component);
		studentIdScrollPane.setBounds(10, 50, 380, 910);
	}

	private void addComponents() {
		this.add(selectionButton);
		this.add(studentIdScrollPane);
	}
}
