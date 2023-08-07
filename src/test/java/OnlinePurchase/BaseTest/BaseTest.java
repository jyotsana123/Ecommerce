package OnlinePurchase.BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import OnlinePurchase.PageObject.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;
	public WebDriver initializeDriver()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public LandingPage lauchWebsite()
	{
		driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
}
