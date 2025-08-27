package saucedemo.AbstractComponents;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
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
	
	// to handle the google chrome browser warning
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
	
	// to handle the google chrome browser warning
	public void handleAlert2() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("prefs", Map.of(
		    "credentials_enable_service", false,
		    "profile.password_manager_enabled", false
		));
		
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

        // Disable password manager and credentials service
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
	}
	
	
}
