package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginResult {
	
	@FindBy(id = "errorMessage")
	private WebElement outputMessage;
	
	public String loginAttemptText() {
		return outputMessage.getText();
	}

}