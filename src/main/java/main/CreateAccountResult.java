package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountResult {
	 
	@FindBy(id = "errorMessage")
	private WebElement outputMessage;
	
	public String createAccountAttemptText() {
		return outputMessage.getText();
	}

}