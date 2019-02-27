package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinResult {

	@FindBy(id = "join-list")
	private WebElement joinButton;

	@FindBy(id = "playerListEntry")
	private WebElement playerListEntry;

	public void joinButtonClick() {
		joinButton.click();
	}

	public String joinAttemptText() {
		return playerListEntry.getText();
	}

}