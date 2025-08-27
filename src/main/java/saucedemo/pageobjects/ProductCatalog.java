package saucedemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{

	WebDriver driver;
	
	//constructor to initiliaze the driver
	public ProductCatalog(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(css=".inventory_item") //uses initElements to use the driver
	List<WebElement> products;
	
	// cycles through list of products displayed and checking for the "productName" (string variable) value
	By productsBy = By.cssSelector(".inventory_item");
	By addToCart = By.cssSelector(".btn_primary"); //add to cart button
	
	public List<WebElement>getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
		
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	// click on add to cart once the product is identified
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(By.cssSelector(".btn_primary")).click();
	}
}
