package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinResult {

	@FindBy(id = "join-list")
	private WebElement joinButton;

	@FindBy(id = "player-list")
	private WebElement playerList;

	public String joinAttemptText() {
		joinButton.click();
		return playerList.getText();
	}
	
	public String leaveAttemptText() {
		joinButton.click();
		joinButton.click();
		return playerList.getText();
	}

}