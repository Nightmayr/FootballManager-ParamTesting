package joinSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinEntry {
	
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

}