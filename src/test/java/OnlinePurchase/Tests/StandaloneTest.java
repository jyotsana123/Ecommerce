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
import org.testng.annotations.Test;

import OnlinePurchase.BaseTest.BaseTest;
import OnlinePurchase.PageObject.ConfirmationPage;
import OnlinePurchase.PageObject.LandingPage;
import OnlinePurchase.PageObject.PaymentPage;
import OnlinePurchase.PageObject.ProductCatalogue;

public class StandaloneTest extends BaseTest {

		@Test
		public void purchase() throws InterruptedException
		{
		LandingPage lp = lauchWebsite();
		ProductCatalogue pc = lp.loginApplication("anshika@gmail.com", "Iamking@000");
		pc.addToCart("ADIDAS ORIGINAL");
		pc.clickOnCartButton();
		PaymentPage pp = pc.clickOnCheckoutButton();
		pp.selectCountry("ind");
		ConfirmationPage cp = pp.clickOnPlaceOrderButton();
		String msg = cp.getConfirmationMessage();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");	
	}

}
