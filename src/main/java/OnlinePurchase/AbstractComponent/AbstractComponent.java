package OnlinePurchase.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
		//How to know this class about driver.
		//Ans: we inherit this class in ProductCatalogue class, So we can send driver variable from child to parent by using super keyword.
		//     this variable is caught under constructor in parent class.      
		//     driver is initialized in ProductCatalogue class.
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		//This is generic method so you can not hard code your By locator "By.cssSelector(".toast-message")"
		//So pass this it as a argument, findBy is just a variable name to store the locator where you want to use this wait method

	}

}

/*
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));

WebElement starts with driver.findElement
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));  
in this By.cssSelector(".toast-message") is not webElement, it is just a By locator
*/