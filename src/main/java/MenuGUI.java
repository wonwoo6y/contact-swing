import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuGUI extends JFrame {
	private DataBase dataBase;
	JButton contactsOutput;
	JButton contactsInput;
	JButton contactsDeletion;
	JButton exit;

	public MenuGUI(DataBase dataBase) {
		this.dataBase = dataBase;
		makeMenuGUI();
	}

	private void makeMenuGUI() {
		setProperties();
		setComponents();
		addComponents();
	}

	private void setProperties() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(340, 145);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}

	private void setComponents() {
		setButtons();
	}

	private void setButtons() {
		setContactsOutput();
		setContactsInput();
		setContactsDeletion();
		setExit();
	}

	private void setContactsOutput() {
		contactsOutput = new JButton("연락처 출력");
		contactsOutput.setBounds(10, 10, 100, 50);
		// contactsOutput.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		new contactsOutputGUI(dataBase);
		// 	}
		// });
	}

	private void setContactsInput() {
		contactsInput = new JButton("연락처 등록");
		contactsInput.setBounds(120, 10, 100, 50);
		// contactsInput.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		new contactsInputGUI(dataBase);
		// 	}
		// });
	}

	private void setContactsDeletion() {
		contactsDeletion = new JButton("연락처 삭제");
		contactsDeletion.setBounds(230, 10, 100, 50);
		// contactsDeletion.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		new contactsDeletion(dataBase);
		// 	}
		// });
	}

	private void setExit() {
		exit = new JButton("끝내기");
		exit.setBounds(120, 60, 100, 50);
	}

	private void addComponents() {
		this.add(contactsOutput);
		this.add(contactsInput);
		this.add(contactsDeletion);
		this.add(exit);
	}
}