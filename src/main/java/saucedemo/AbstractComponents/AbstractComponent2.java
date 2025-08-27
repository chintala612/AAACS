package saucedemo.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent2 {

	WebDriver driver;
	
	public AbstractComponent2(WebDriver driver) {
		// created a constructor to get the driver from the child - landingpage
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".shopping_cart_link")
	WebElement cartHeader;
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void goToCartPage()
	{
		cartHeader.click();
	}
	
	public String handleAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        String text = alert.getText();
	        System.out.println("Alert found: " + text);
	        alert.accept(); // click OK
	        return text;

	    } catch (TimeoutException e) {
	        System.out.println("No alert appeared within 10 seconds.");
	        return null; // no alert text
	    } catch (Exception e) {
	        System.out.println("Unexpected error while handling alert: " + e.getMessage());
	        return null;
	    }
	}
}
