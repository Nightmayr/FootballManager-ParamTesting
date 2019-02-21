package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserEntry {
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/input[1]")
	private WebElement username; 
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/input[2]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/input[3]")
	private WebElement button;
	
	public void addUser(String user, String pass) { 
		username.sendKeys(user);
		password.sendKeys(pass);
		button.click();
	}

}
