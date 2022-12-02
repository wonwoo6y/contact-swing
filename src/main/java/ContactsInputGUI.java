import java.awt.*;

import javax.swing.*;

public class ContactsInputGUI extends JFrame {
	private DataBase dataBase;
	private JLabel nameMark;
	private JLabel birthDataMark;
	private JLabel phoneNumberMark;
	private JLabel studentIdMark;
	private JTextField nameInputBox;
	private JTextField birthDataInputBox;
	private JTextField phoneNumberInputBox;
	private JTextField studentIdInputBox;
	private JButton contactInput;

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
		setNameMark(x, y, width, height);
		y += height;
		setBirthDataMark(x, y, width, height);
		y += height;
		setPhoneNumberMark(x, y, width, height);
		y += height;
		setStudentIdMark(x, y, width, height);
	}

	private void setNameMark(int x, int y, int width, int height) {
		nameMark = new JLabel("이름");
		nameMark.setBounds(x, y, width, height);
	}

	private void setBirthDataMark(int x, int y, int width, int height) {
		birthDataMark = new JLabel("생년월일");
		birthDataMark.setBounds(x, y, width, height);
	}

	private void setPhoneNumberMark(int x, int y, int width, int height) {
		phoneNumberMark = new JLabel("휴대폰 번호");
		phoneNumberMark.setBounds(x, y, width, height);
	}

	private void setStudentIdMark(int x, int y, int width, int height) {
		studentIdMark = new JLabel("학번");
		studentIdMark.setBounds(x, y, width, height);
	}

	private void setTextFields() {
		int x = 70;
		int y = 10;
		int width = 100;
		int height = 30;
		setNameInputBox(x, y, width, height);
		y += height;
		setBirthDataInputBox(x, y, width, height);
		y += height;
		setPhoneNumberInputBox(x, y, width, height);
		y += height;
		setStudentIdInputBox(x, y, width, height);
	}

	private void setNameInputBox(int x, int y, int width, int height) {
		nameInputBox = new JTextField();
		nameInputBox.setBounds(x, y, width, height);
	}

	private void setBirthDataInputBox(int x, int y, int width, int height) {
		birthDataInputBox = new JTextField();
		birthDataInputBox.setBounds(x, y, width, height);
	}

	private void setPhoneNumberInputBox(int x, int y, int width, int height) {
		phoneNumberInputBox = new JTextField();
		phoneNumberInputBox.setBounds(x, y, width, height);
	}

	private void setStudentIdInputBox(int x, int y, int width, int height) {
		studentIdInputBox = new JTextField();
		studentIdInputBox.setBounds(x, y, width, height);
	}

	private void setButtons() {
		setContactInput(170, 55, 50, 30);
	}

	private void setContactInput(int x, int y, int width, int height) {
		contactInput = new JButton("등록");
		contactInput.setBounds(x, y, width, height);
	}
	private void addComponents() {
		this.add(nameMark);
		this.add(birthDataMark);
		this.add(phoneNumberMark);
		this.add(studentIdMark);
		this.add(nameInputBox);
		this.add(birthDataInputBox);
		this.add(phoneNumberInputBox);
		this.add(studentIdInputBox);
		this.add(contactInput);
	}
}
