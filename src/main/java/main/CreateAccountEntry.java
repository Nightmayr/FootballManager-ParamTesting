package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountEntry {

	@FindBy(id = "fullNameInput")
	private WebElement fullName;

	@FindBy(id = "emailInput")
	private WebElement email;

	@FindBy(id = "passwordInput")
	private WebElement password;

	@FindBy(id = "confirmInput")
	private WebElement confirmPassword;

	@FindBy(id = "createButton")
	private WebElement createButton;

	public void addAccount(String name, String emessage, String pword, String confirm) {
		fullName.sendKeys(name);
		email.sendKeys(emessage);
		password.sendKeys(pword);
		confirmPassword.sendKeys(confirm);
		createButton.click();
	}

	public void addAccountNoName(String emessage, String pword, String confirm) {
		email.sendKeys(emessage);
		password.sendKeys(pword);
		confirmPassword.sendKeys(confirm);
		createButton.click();
	}

	public void addAccountNoEmail(String name, String pword, String confirm) {
		fullName.sendKeys(name);
		password.sendKeys(pword);
		confirmPassword.sendKeys(confirm);
		createButton.click();
	}

	public void addAccountNoPassword(String name, String emessage, String confirm) {
		fullName.sendKeys(name);
		email.sendKeys(emessage);
		confirmPassword.sendKeys(confirm);
		createButton.click();
	}

	public void addAccountNoConfirm(String name, String emessage, String pword) {
		fullName.sendKeys(name);
		email.sendKeys(emessage);
		password.sendKeys(pword);
		createButton.click();
	}

	public void addAccountNoInput() {
		createButton.click();
	}

}