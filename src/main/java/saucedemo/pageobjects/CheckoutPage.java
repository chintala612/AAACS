package saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponent;

//using inheritance
public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	
	//constructor to initiliaze the driver
	public CheckoutPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(id="first-name") //uses initElements to use the driver
	WebElement firstname;
		
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id = "continue")
	WebElement contfromcartpage;
	
	public void custdtlscartpg(String custfirstname, String custlastname, String custpostalcode)
	{
		firstname.sendKeys(custfirstname);
		lastname.sendKeys(custlastname);
		postalcode.sendKeys(custpostalcode);
	}
		
	public void gotoorderreviewpg()
	{
		contfromcartpage.click();
	}
	
}
