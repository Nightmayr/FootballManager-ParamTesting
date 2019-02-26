package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginResult {
	
	@FindBy(id = "errorMessage")
	private WebElement outputMessage;
	
	@FindBy(id = "header")
	private WebElement redirectPage;
	
	public String loginAttemptText() {
		return outputMessage.getText();
	}
	
	public String loginAttemptTextOnRedirect() {
		return redirectPage.getText();
	}

}