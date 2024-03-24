package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
	
	public void openBrowser()
	{
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		driver=new EdgeDriver();
		}
	}
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
	}
	
	public void type(String locatorKey,String text)
	{
		getElement(locatorKey).sendKeys(text);
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void selectOptionFromDropdown(String locatorKey,String option)
	{
		new Select(getElement(locatorKey)).selectByVisibleText(option);
	}
	
	public WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		element = driver.findElement(getLocator(locatorKey));
		
		return element;
		
	}
	
	public By getLocator(String locatorKey)
	{
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linkText"))
		{
			by=By.linkText(locatorsProp.getProperty(locatorKey));
		}
		else 
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}
		
		return by;
		
	}
	
	public void closeBrowser()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
