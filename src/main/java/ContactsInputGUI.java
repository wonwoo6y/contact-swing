import java.awt.*;

import javax.swing.*;

public class ContactsInputGUI extends JFrame {
	private DataBase dataBase;
	private JLabel nameLabel;
	private JLabel birthDataLabel;
	private JLabel phoneNumberLabel;
	private JLabel studentIdLabel;
	private JTextField nameTextField;
	private JTextField birthDataTextField;
	private JTextField phoneNumberTextField;
	private JTextField studentIdTextField;
	private JButton inputButton;

	public ContactsInputGUI(DataBase dataBase) {
		this.dataBase = dataBase;
		makeGUI();
	}

	private void makeGUI() {
		setProperties();
		setComponents();
		addComponents();
	}

	private void setProperties() {
		this.setTitle("연락처 입력 프레임");
		this.setLayout(null);
		this.setSize(230, 180);
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
		setNameLabel(x, y, width, height);
		y += height;
		setBirthDataButton(x, y, width, height);
		y += height;
		setPhoneNumberButton(x, y, width, height);
		y += height;
		setStudentIdButton(x, y, width, height);
	}

	private void setNameLabel(int x, int y, int width, int height) {
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(x, y, width, height);
	}

	private void setBirthDataButton(int x, int y, int width, int height) {
		birthDataLabel = new JLabel("생년월일");
		birthDataLabel.setBounds(x, y, width, height);
	}

	private void setPhoneNumberButton(int x, int y, int width, int height) {
		phoneNumberLabel = new JLabel("휴대폰 번호");
		phoneNumberLabel.setBounds(x, y, width, height);
	}

	private void setStudentIdButton(int x, int y, int width, int height) {
		studentIdLabel = new JLabel("학번");
		studentIdLabel.setBounds(x, y, width, height);
	}

	private void setTextFields() {
		int x = 70;
		int y = 10;
		int width = 100;
		int height = 30;
		setNameTextField(x, y, width, height);
		y += height;
		setBirthDataTextField(x, y, width, height);
		y += height;
		setPhoneNumberTextField(x, y, width, height);
		y += height;
		setStudentIdTextField(x, y, width, height);
	}

	private void setNameTextField(int x, int y, int width, int height) {
		nameTextField = new JTextField();
		nameTextField.setBounds(x, y, width, height);
	}

	private void setBirthDataTextField(int x, int y, int width, int height) {
		birthDataTextField = new JTextField();
		birthDataTextField.setBounds(x, y, width, height);
	}

	private void setPhoneNumberTextField(int x, int y, int width, int height) {
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(x, y, width, height);
	}

	private void setStudentIdTextField(int x, int y, int width, int height) {
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(x, y, width, height);
	}

	private void setButtons() {
		setInputButton(170, 55, 50, 30);
	}

	private void setInputButton(int x, int y, int width, int height) {
		inputButton = new JButton("등록");
		inputButton.setBounds(x, y, width, height);
	}
	private void addComponents() {
		this.add(nameLabel);
		this.add(birthDataLabel);
		this.add(phoneNumberLabel);
		this.add(studentIdLabel);
		this.add(nameTextField);
		this.add(birthDataTextField);
		this.add(phoneNumberTextField);
		this.add(studentIdTextField);
		this.add(inputButton);
	}
}
