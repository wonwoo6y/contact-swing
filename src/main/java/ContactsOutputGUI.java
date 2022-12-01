import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableModel;

public class ContactsOutputGUI extends JFrame {
	private DataBase dataBase;
	private JLabel studentIdMark;
	private JTextField studentIdInputBox;
	private JButton studentIdSelection;
	private JTable studentIdOutput;
	private JScrollPane scrollPane;

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
		setLabel();
		setTextField();
		setButton();
		setTable();
		setScrollPane((Component)studentIdOutput);
	}

	private void setLabel() {
		setStudentIdMark();
	}

	private void setStudentIdMark() {
		studentIdMark = new JLabel("학번");
		studentIdMark.setBounds(10, 10, 30, 30);
	}

	private void setTextField() {
		setStudentIdInputBox();
	}

	private void setStudentIdInputBox() {
		studentIdInputBox = new JTextField();
		studentIdInputBox.setBounds(50, 10, 100, 30);
	}

	private void setButton() {
		setStudentIdInput();
	}

	private void setStudentIdInput() {
		studentIdSelection = new JButton("확인");
		studentIdSelection.setBounds(150, 10, 50, 30);
	}

	private void setTable() {
		setStudentIdOutput();
	}

	private void setStudentIdOutput() {
		studentIdOutput = new JTable();
	}

	private void setScrollPane(Component component) {
		scrollPane = new JScrollPane(component);
		scrollPane.setBounds(10, 50, 380, 910);
	}

	private void addComponents() {
		this.add(studentIdMark);
		this.add(studentIdInputBox);
		this.add(studentIdSelection);
		this.add(scrollPane);
	}
}
