package saucedemo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	//constructor to initiliaze the driver
	public CartPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(css=".inventory_item_name") //uses initElements to use the driver
	private List<WebElement> cartProducts;
	
	@FindBy(css = ".checkout_button")
	WebElement checkoutEle;

// 	Cart Page; cycling through to look for the item that was added and click on checkout
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	// click on checkout
	public void goToCheckout()
	{
		checkoutEle.click();
	}
}
