package OnlinePurchase.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OnlinePurchase.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmationMsg;
	
	public String getConfirmationMessage()
	{
		return confirmationMsg.getText();
	}
}
