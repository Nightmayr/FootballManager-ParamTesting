package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinEntry {
	
	@FindBy(id = "join-list")
	private WebElement joinButton;

	public void joinAttempt() {
		joinButton.click();
	}
	
	public void removeAttempt() {
		joinButton.click();
		joinButton.click();
	}

}