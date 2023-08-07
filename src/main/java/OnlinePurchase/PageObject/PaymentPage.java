package OnlinePurchase.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	public PaymentPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']") //Ques: How this annotation knows about the driver?
	WebElement countryBox;   //Ans: there is one method initElements which you need to write first and which will take care to constructing that by using driver as a argument

	//WebElement userName = driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".ta-results")
	List<WebElement> options;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderButton;
	
	
	public void selectCountry(String country) throws InterruptedException
	{
		//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		countryBox.sendKeys(country);
		//List<WebElement> options = driver.findElements(By.cssSelector(".ta-results"));
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			System.out.println(option);
			if (option.contains("India")) {
				options.get(i).click();
				//Thread.sleep(1000);
			}
		}
	}
	
	public ConfirmationPage clickOnPlaceOrderButton() throws InterruptedException
	{
		//Thread.sleep(1000);
		// Click on placeorder button
				Actions a = new Actions(driver);
				a.sendKeys(Keys.PAGE_DOWN).build().perform();
				//Thread.sleep(1000);
				//driver.findElement(By.cssSelector(".action__submit")).click();
				placeOrderButton.click();
				ConfirmationPage cp = new ConfirmationPage(driver);
				return cp;
	}
}
