package saucedemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import saucedemo.pageobjects.CartPage;
import saucedemo.pageobjects.CheckoutPage;
import saucedemo.pageobjects.LandingPage;
import saucedemo.pageobjects.OrderconfPage;
import saucedemo.pageobjects.OrderreviewPage;
import saucedemo.pageobjects.ProductCatalog;

public class CreateOrder {

	public static void main(String[] args) {
		
		String productName = "Sauce Labs Bike Light";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
//      Landing page and loginto application			
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("standard_user", "secret_sauce");

		landingPage.handleAlert();
		landingPage.handleAlert2();	
		
//      Product Catalog page and add product to cart
		ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement>products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		
//     	click on shopping cart icon
		productCatalog.goToCartPage();
		
//     	validate product added is displayed on cart page
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		
//		click on checkout to proceed to checkout page
		cartPage.goToCheckout();

//     	Fill customer details on Checkout Page
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.custdtlscartpg("johnAAA", "carterAAA", "00001");
		
//     	click on continue to go to order review page
		checkoutPage.gotoorderreviewpg();
		
//     	Continue to Order Confirmation Page; 
		OrderreviewPage orderreviewPage = new OrderreviewPage(driver);
		orderreviewPage.gotoorderconfirmpg();

//     	Order confirmation Page verification;
		OrderconfPage orderconfPage = new OrderconfPage(driver);
		String confirmorderMessage = orderconfPage.getOrderConfText();
		Assert.assertTrue(confirmorderMessage.equalsIgnoreCase("Thank you for your order!"));
		System.out.println(confirmorderMessage);		
		driver.close();
      
	}

}

