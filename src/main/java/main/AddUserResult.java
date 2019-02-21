package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserResult {
	 
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/p")
	private WebElement outputMessage;
	
	public String addUserAttemptText() {
		return outputMessage.getText();
	}

}
