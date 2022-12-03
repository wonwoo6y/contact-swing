import java.awt.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class ContactsInputGUI extends JFrame {
	public final int MAXIMUM_AGE = 200;
	private DataBase dataBase;
	private JLabel nameLabel;
	private JLabel birthDateLabel;
	private JLabel phoneNumberLabel;
	private JLabel studentIdLabel;
	private JTextField nameTextField;
	private JTextField birthDateTextField;
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
		setBirthDateButton(x, y, width, height);
		y += height;
		setPhoneNumberButton(x, y, width, height);
		y += height;
		setStudentIdButton(x, y, width, height);
	}

	private void setNameLabel(int x, int y, int width, int height) {
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(x, y, width, height);
	}

	private void setBirthDateButton(int x, int y, int width, int height) {
		birthDateLabel = new JLabel("생년월일");
		birthDateLabel.setBounds(x, y, width, height);
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
		setBirthDateTextField(x, y, width, height);
		y += height;
		setPhoneNumberTextField(x, y, width, height);
		y += height;
		setStudentIdTextField(x, y, width, height);
	}

	private void setNameTextField(int x, int y, int width, int height) {
		nameTextField = new JTextField();
		nameTextField.setBounds(x, y, width, height);
	}

	private void setBirthDateTextField(int x, int y, int width, int height) {
		birthDateTextField = new JTextField();
		birthDateTextField.setBounds(x, y, width, height);
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
		inputButton.addActionListener(e -> {
			System.out.println("등록 버튼 클릭");
			String name = nameTextField.getText();
			String birthDate = birthDateTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String studentId = studentIdTextField.getText();
			System.out.printf("name: %s, birthDate: %s, phoneNumber: %s, studentId: %s\n",
				name, birthDate, phoneNumber, studentId);
			if (!validName(name) || !validBirthDate(birthDate) ||
				!validPhoneNumber(phoneNumber) || !validStudentId(studentId)) {
				System.out.println("정규표현식에 유효하지 않음");
				return;
			}
			if (!validAge(birthDate)) {
				System.out.println("나이 제한");
				return;
			}
			if (dataBase.insertFriend(name, birthDate, phoneNumber, studentId)){
				System.out.println("데이터 삽입 성공");
			} else {
				System.out.println("데이터 삽입 실패");
			}
		});
	}

	private boolean validName(String name) {
		String regex = "^([a-zA-Zㄱ-힣0-9]*)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	private boolean validBirthDate(String birthData) {
		String regex = "^\\d{4}-\\d{2}-\\d{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(birthData);
		return matcher.matches();
	}

	private boolean validPhoneNumber(String phoneNumber) {
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{3,4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

	private boolean validStudentId(String studentId) {
		String regex = "^\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(studentId);
		return matcher.matches();
	}

	private boolean validAge(String birthDate) {
		Integer age = getAge(birthDate);
		if (age > MAXIMUM_AGE) {
			return false;
		}
		return true;
	}

	private Integer getAge(String date) {
		Calendar now = Calendar.getInstance();
		Integer currentYear = now.get(Calendar.YEAR);

		Integer inputYear = getYear(date);
		return currentYear - inputYear + 1;
	}
	private Integer getYear(String date) {
		return Integer.parseInt(date.substring(0, 4));
	}

	private void addComponents() {
		this.add(nameLabel);
		this.add(birthDateLabel);
		this.add(phoneNumberLabel);
		this.add(studentIdLabel);
		this.add(nameTextField);
		this.add(birthDateTextField);
		this.add(phoneNumberTextField);
		this.add(studentIdTextField);
		this.add(inputButton);
	}
}
