package OnlinePurchase.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import OnlinePurchase.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h5") //Ques: How this annotation knows about the driver?
	List<WebElement> products;   //Ans: there is one method initElements which you need to write first and which will take care to constructing that by using driver as a argument

	//List<WebElement> products = driver.findElements(By.xpath("//h5"));
	
	@FindBy(xpath="//div/button[2]")
	List<WebElement> addTocartButton;  //driver.findElements(By.xpath("//div/button[2]"))
	
	By message = By.cssSelector(".toast-message");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutButton;
	
	
	public void addToCart(String product)
	{
		//String product = "ADIDAS ORIGINAL";
		// Getting list of all available products
		//List<WebElement> products = driver.findElements(By.xpath("//h5"));
		for (int i = 0; i < products.size(); i++) {
			String item = products.get(i).getText();
			System.out.println(item);
			if (item.contains(product)) {
				// Click on add to cart button on "ADIDAS ORIGINAL" product
				addTocartButton.get(i).click();
				break;
			}
		}

	}
	
	public void clickOnCartButton()
	{
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));  */
		waitForElementToAppear(message);
		cart.click();
	}
	
	public PaymentPage clickOnCheckoutButton()
	{
		// Click on checkout button
		//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		checkOutButton.click();
		PaymentPage pp = new PaymentPage(driver);
		return pp;
	}
	
	
}


