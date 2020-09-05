package emailApp;

import java.util.Scanner;

public class Email {
	private String company = "google.com";
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int passwordLength = 12;
	private String department;
	private int mailboxCap = 1000;
	private String alternateEmail;
	
	// input first/last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		this.password = randomPassword(this.passwordLength);
		// generate email address
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.company;
	}
	// set department
	private String setDepartment() {
		System.out.print("Enter the department code:\n1 for Human Resource\n2 for Development\n3 for sales\n0 for None\n");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		in.close();
		if (depChoice == 1) {return "hr";}
		else if (depChoice == 2) {return "devs";}
		else if (depChoice == 3) {return "sales";}
		else { return "";}
	}
	// generate random password
	private String randomPassword(int length) {
		String passwordChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int idx = (int) (Math.random() * passwordChar.length());
			password[i] = passwordChar.charAt(idx);
		}
		return new String(password);
	}
	// set email capacity
	public void setMailboxCapacity(int cap) {
		this.mailboxCap = cap;
	}
	
	// set alternate email
	public void setAlternateEmail(String alteremail) {
		this.alternateEmail = alteremail;
	}
	
	// change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return this.mailboxCap;
	}
	
	public String getAlternateEmail() {
		return this.alternateEmail;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String showInfo() {
		return "Name: " + this.firstName + " " + this.lastName + "\n" +
				"Email: " + this.email + "\n" +
				"Password: " + this.password + "\n";	
	}
}
