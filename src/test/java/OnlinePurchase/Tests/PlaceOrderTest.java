package OnlinePurchase.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import OnlinePurchase.PageObject.ConfirmationPage;
import OnlinePurchase.PageObject.LandingPage;
import OnlinePurchase.PageObject.PaymentPage;
import OnlinePurchase.PageObject.ProductCatalogue;

public class PlaceOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		ProductCatalogue pc = lp.loginApplication("anshika@gmail.com", "Iamking@000");
//		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//		driver.findElement(By.id("login")).click();

		//ProductCatalogue pc = new ProductCatalogue(driver);
		pc.addToCart("ADIDAS ORIGINAL");
	/*	String product = "ADIDAS ORIGINAL";
		// Getting list of all available products
		List<WebElement> products = driver.findElements(By.xpath("//h5"));
		for (int i = 0; i < products.size(); i++) {
			String item = products.get(i).getText();
			System.out.println(item);
			if (item.contains(product)) {
				// Click on add to cart button on "ADIDAS ORIGINAL" product
				driver.findElements(By.xpath("//div/button[2]")).get(i).click();
				break;
			}
		} */

		// wait till toast message "Product added to cart" is get displayed, then after
		// click on cart icon to see products on cart
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));

		// Click on cart button
		//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		pc.clickOnCartButton();
		// Click on checkout button
		//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		PaymentPage pp = pc.clickOnCheckoutButton();

		// Enter shipping information
	/*	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector(".ta-results"));
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			System.out.println(option);
			if (option.contains("India")) {
				driver.findElements(By.cssSelector(".ta-results")).get(i).click();

			}
		} */
		
		//PaymentPage pp = new PaymentPage(driver);
		pp.selectCountry("ind");

		// Click on placeorder button
	/*	Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click(); */
		ConfirmationPage cp = pp.clickOnPlaceOrderButton();

		// Verify Thank you page
		String msg = cp.getConfirmationMessage();
		//String confirmationMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		
	}

}
