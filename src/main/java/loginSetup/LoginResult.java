package loginSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginResult {
	
	@FindBy(id = "errorMessageLogin")
	private WebElement outputMessage;
	
	@FindBy(id = "name")
	private WebElement redirectPage;
	
	public String loginAttemptText() {
		return outputMessage.getText();
	}
	
	public String loginAttemptTextOnRedirect() {
		return redirectPage.getText();
	}

}