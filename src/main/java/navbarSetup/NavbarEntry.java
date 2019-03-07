package navbarSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarEntry {

	@FindBy(id = "hbut")
	private WebElement loginNav;

	@FindBy(id = "cbut")
	private WebElement registerNav;

	@FindBy(id = "tbut")
	private WebElement playingNav;

	public void loginNav() {
		loginNav.click();
	}

	public void registerNav() {
		registerNav.click();
	}

	public void playingNav() {
		playingNav.click();
	}

}