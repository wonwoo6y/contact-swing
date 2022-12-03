import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContactsOutputGUI extends JFrame {
	private DataBase dataBase;
	private JButton selectionButton;
	private JTable studentIdTable;
	private JScrollPane studentIdScrollPane;

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
		setStudentIdScrollPane((Component)studentIdTable);
	}

	private void setButtons() {
		setSelectionButton();
	}

	private void setSelectionButton() {
		selectionButton = new JButton("출력");
		selectionButton.setBounds(175, 10, 50, 30);
		// studentIdSelection.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		//
		// 	}
		// });
	}

	private void setTables() {
		setStudentIdTable();
	}

	private void setStudentIdTable() {
		studentIdTable = new JTable(new DefaultTableModel());
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
