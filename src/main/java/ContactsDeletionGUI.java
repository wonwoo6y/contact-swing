import java.awt.*;

import javax.swing.*;

public class ContactsDeletionGUI extends JFrame {
	private DataBase dataBase;
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberTextField;
	private JButton deletionButton;

	public ContactsDeletionGUI(DataBase dataBase) {
		this.dataBase = dataBase;
		makeGUI();
	}

	private void makeGUI() {
		setProperties();
		setComponents();
		addComponents();
	}

	private void setProperties() {
		this.setTitle("연락처 삭제 프레임");
		this.setLayout(null);
		this.setSize(230, 80);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}

	private void setComponents() {
		setLabels();
		setTextFields();
		setButtons();
	}

	private void setLabels() {
		int x = 10;
		int y = 10;
		int width = 60;
		int height = 30;
		setStudentIdLabel(x, y, width, height);
	}

	private void setStudentIdLabel(int x, int y, int width, int height) {
		phoneNumberLabel = new JLabel("휴대폰 번호");
		phoneNumberLabel.setBounds(x, y, width, height);
	}

	private void setTextFields() {
		int x = 70;
		int y = 10;
		int width = 100;
		int height = 30;
		setStudentIdTextField(x, y, width, height);
	}

	private void setStudentIdTextField(int x, int y, int width, int height) {
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(x, y, width, height);
	}

	private void setButtons() {
		int x = 170;
		int y = 10;
		int width = 50;
		int height = 30;
		setDeletionButton(x, y, width, height);
		deletionButton.addActionListener(e -> {
			if (dataBase.deleteFriend(phoneNumberTextField.getText())){
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		});
	}

	private void setDeletionButton(int x, int y, int width, int height) {
		deletionButton = new JButton("삭제");
		deletionButton.setBounds(x, y, width, height);
	}

	private void addComponents() {
		this.add(phoneNumberLabel);
		this.add(phoneNumberTextField);
		this.add(deletionButton);
	}

}
