import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuGUI extends JFrame {
	private DataBase dataBase;
	private JButton contactsOutputButton;
	private JButton contactsInputButton;
	private JButton contactsDeletionButton;
	private JButton exitButton;

	public MenuGUI(DataBase dataBase) {
		this.dataBase = dataBase;
		makeGUI();
	}

	private void makeGUI() {
		setProperties();
		setComponents();
		addComponents();
	}

	private void setProperties() {
		this.setTitle("메뉴 프레임");
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
		setContactsOutputButton();
		setContactsInputButton();
		setContactsDeletionButton();
		setExitButton();
	}

	private void setContactsOutputButton() {
		contactsOutputButton = new JButton("연락처 출력");
		contactsOutputButton.setBounds(10, 10, 100, 50);
		contactsOutputButton.addActionListener(e -> {
			new ContactsOutputGUI(dataBase);
		});
	}

	private void setContactsInputButton() {
		contactsInputButton = new JButton("연락처 등록");
		contactsInputButton.setBounds(120, 10, 100, 50);
		contactsInputButton.addActionListener(e -> {
			new ContactsInputGUI(dataBase);
		});
	}

	private void setContactsDeletionButton() {
		contactsDeletionButton = new JButton("연락처 삭제");
		contactsDeletionButton.setBounds(230, 10, 100, 50);
		contactsDeletionButton.addActionListener(e -> {
			new ContactsDeletionGUI(dataBase);
		});
	}

	private void setExitButton() {
		exitButton = new JButton("끝내기");
		exitButton.setBounds(120, 60, 100, 50);
	}

	private void addComponents() {
		this.add(contactsOutputButton);
		this.add(contactsInputButton);
		this.add(contactsDeletionButton);
		this.add(exitButton);
	}
}
