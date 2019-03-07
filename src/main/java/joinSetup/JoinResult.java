package joinSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinResult {

	@FindBy(id = "join-list")
	private WebElement joinButton;

	@FindBy(id = "updateMessageJoin")
	private WebElement updateMessage;

	public void joinButtonClick() {
		joinButton.click();
	}

	public String joinAttemptText() {
		return updateMessage.getText();
	}

}