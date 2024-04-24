package A02CrossBrowser;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class crossBrowserTestA02 
{
  WebDriver driver;
	@Test
	public void CBTest() throws InterruptedException 
	  {
		Thread.sleep(10000);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sam");
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String expText = "Results";
		String actText = driver.findElement(By.cssSelector(".a-size-medium-plus.a-color-base.a-text-bold")).getText();
		Assert.assertEquals(actText, expText);
		System.out.println("Test is passed and Obtained text in browser is: "+actText);
		Thread.sleep(10000);
		driver.quit();
	  }
	  @Parameters({"bsrName"})
	  @BeforeTest
	  public void beforeTest(String bsrName) throws MalformedURLException 
	  {
		  if(bsrName.equalsIgnoreCase("chrome"))
		  {
			 ChromeOptions option = new ChromeOptions();
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/"),option);
			 System.out.println("Server connection is established with Chrome Browser");		 
		  }
		  if(bsrName.equalsIgnoreCase("firefox"))
		  {
			 FirefoxOptions option = new FirefoxOptions();
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/"),option);
			 System.out.println("Server connection is established with Firefox Browser");		 
		  }
		  if(bsrName.equalsIgnoreCase("edge"))
		  {
			 EdgeOptions option = new EdgeOptions();
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/"),option);
			 System.out.println("Server connection is established with Edge Browser");		 
		  }
	  }
}
