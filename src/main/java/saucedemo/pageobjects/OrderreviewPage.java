package saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponent;

//using inheritance
public class OrderreviewPage extends AbstractComponent{

	WebDriver driver;
	
	//constructor to initiliaze the driver
	public OrderreviewPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(id = "finish")
	WebElement contfromordrvw;
	
	public void gotoorderconfirmpg()
	{
		contfromordrvw.click();
	}
	
}
