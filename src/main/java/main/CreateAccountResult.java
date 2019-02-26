package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountResult {
	 
	@FindBy(id = "errorMessage")
	private WebElement outputMessage;
	
	@FindBy(id = "header")
	private WebElement redirectPage;
	
	public String createAccountAttemptText() {
		return outputMessage.getText();
	}
	
	public String createAccountAttemptTextOnRedirect() {
		return redirectPage.getText();
	}

}