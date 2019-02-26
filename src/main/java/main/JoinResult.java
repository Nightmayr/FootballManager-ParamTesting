package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinResult {
	
	@FindBy(id = "errorMessage")
	private WebElement playerName;
	
	public String joinAttemptText() {
		return playerName.getText();
	}
	
}