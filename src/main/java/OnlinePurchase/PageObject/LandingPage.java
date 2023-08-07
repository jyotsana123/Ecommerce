package OnlinePurchase.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail") //Ques: How this annotation knows about the driver?
	WebElement userName;   //Ans: there is one method initElements which you need to write first and which will take care to constructing that by using driver as a argument

	//WebElement userName = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userName.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
}









//driver.get("https://rahulshettyacademy.com/client");
//driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//driver.findElement(By.id("login")).click();