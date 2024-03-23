package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyInValidLoginDetails extends BaseTest {
	
	@Test
	public void toVerifyValidUserNameInValidPassword()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz456");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@Test
	public void toVerifyInValidUserNameValidPassword()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz1212");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@Test
	public void toVerifyInValidUserNameInValidPassword()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz1212");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz456");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}

}
