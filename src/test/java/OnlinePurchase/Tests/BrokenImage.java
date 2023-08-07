package OnlinePurchase.Tests;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		for(WebElement image :images)
		{
			String imageSrc = image.getAttribute("src");
			URL imageUrl = new URL(imageSrc);
			URLConnection urlConnection = imageUrl.openConnection();
			HttpsURLConnection httpurlconnection = (HttpsURLConnection)urlConnection;
			httpurlconnection.setConnectTimeout(5000);
			httpurlconnection.connect();
			if(httpurlconnection.getResponseCode()==200)
			{
				System.out.println(imageSrc+" >> "+httpurlconnection.getResponseCode()+" >> "+httpurlconnection.getResponseMessage());
			}
			else
			{
				System.err.println(imageSrc+" >> "+httpurlconnection.getResponseCode()+" >> "+httpurlconnection.getResponseMessage());
			}
			httpurlconnection.disconnect();
		}
		

	}

}

//How to find broken images
/*
 * https://www.youtube.com/watch?v=6NXZQYs-Eig&t=10s
 *  1. Collect all the image links present on a web page based on the <a> tag
    2. Send HTTP request for each link
    3. Verify the HTTP response code
    4. Determine if the link is valid or broken based on the HTTP response code
    5. Repeat the process for all links captured with the first step
    */
