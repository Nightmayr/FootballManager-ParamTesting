package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginEntry {

	@FindBy(id = "user-email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginButton;

	public void loginAttempt(String emessage, String pword) {
		email.sendKeys(emessage);
		password.sendKeys(pword);
		loginButton.click();
	}

	public void loginNoEmail(String pword) {
		password.sendKeys(pword);
		loginButton.click();
	}

	public void loginNoPassword(String emessage) {
		email.sendKeys(emessage);
		loginButton.click();
	}

	public void loginNoInput() {
		loginButton.click();
	}

}