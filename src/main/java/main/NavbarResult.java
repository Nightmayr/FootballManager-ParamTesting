package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarResult {

	@FindBy(id = "header-2")
	private WebElement loginNavResult;

	@FindBy(id = "createButton")
	private WebElement registerNavResult;

	@FindBy(id = "name")
	private WebElement playingNavResult;

	public String loginNavResultText() {
		return loginNavResult.getText();
	}

	public String registerNavResultText() {
		return registerNavResult.getText();
	}

	public String playingNavResultText() {
		return playingNavResult.getText();
	}

}