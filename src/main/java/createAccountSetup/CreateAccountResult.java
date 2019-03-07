package createAccountSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountResult {
	 
	@FindBy(id = "errorMessageCreate")
	private WebElement outputMessage;
	
	@FindBy(id = "name")
	private WebElement redirectPage;
	
	public String createAccountAttemptText() {
		return outputMessage.getText();
	}
	
	public String createAccountAttemptTextOnRedirect() {
		return redirectPage.getText();
	}

}