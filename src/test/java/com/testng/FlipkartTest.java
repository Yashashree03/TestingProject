package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartTest {
	WebDriver w;
	@BeforeMethod
	public void openbrowser() {
		w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
		w.manage().window().maximize();
	}
	
	@Test
	public void searchproduct() {
		w.findElement(By.name("q")).sendKeys("iphone14",Keys.ENTER);
		w.findElement(By.cssSelector("a[class=\"CGtC98\"]")).click();
	}
	
	@AfterMethod
	public void closebrowser() throws Exception {
		Thread.sleep(2000);
		w.quit();
	}

}
