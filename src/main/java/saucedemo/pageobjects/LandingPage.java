package saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponent;

//using inheritance
public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	//constructor to initiliaze the driver
	public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(id="user-name") //uses initElements to use the driver
	WebElement username;
		
	@FindBy(id="password")
	WebElement userpassword;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	public void loginApplication(String loginusername, String loginpassword)
	{
		username.sendKeys(loginusername);
		userpassword.sendKeys(loginpassword);
		loginbutton.click();
	}
		
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
}
