import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableModel;

public class ContactsOutputGUI extends JFrame {
	private DataBase dataBase;
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
		setButton();
		setTable();
		setScrollPane((Component)studentIdOutput);
	}

	private void setButton() {
		setStudentIdInput();
	}

	private void setStudentIdInput() {
		studentIdSelection = new JButton("출력");
		studentIdSelection.setBounds(175, 10, 50, 30);
		// studentIdSelection.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		//
		// 	}
		// });
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
		this.add(studentIdSelection);
		this.add(scrollPane);
	}
}
