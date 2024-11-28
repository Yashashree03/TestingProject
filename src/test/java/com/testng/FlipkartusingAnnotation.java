package com.testng;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartusingAnnotation {
	WebDriver w;
	
	@BeforeClass
	public void launchbrowser() {
		w = new ChromeDriver();
	}
	
	@BeforeMethod
	public void opensite() {
		w.get("https://www.flipkart.com/");
	}
	
	@Test(priority = 1)
	public void searchproductiphone() {
		w.findElement(By.name("q")).sendKeys("iphone14",Keys.ENTER);
		w.findElement(By.cssSelector("a[class=\"CGtC98\"]")).click();
	}
	@Test(priority = 2)
	public void productAC() {
		w.findElement(By.name("q")).sendKeys("daikin ac 1.5 ton",Keys.ENTER);
		List<WebElement> ac = w.findElements(By.cssSelector("a[class=\"CGtC98\"]"));
		for (WebElement web : ac) {
			if(web.getText().contains("Daikin 2023 Model 1.5 Ton 3 Star Split AC with PM 2.5 Filter")) {
				web.click();
				break;
			}
			
			
		}
		
	}
	@AfterMethod
	public void switchwindow() throws Exception {
		String parent = w.getWindowHandle();
		Set<String> child = w.getWindowHandles();
		for (String c : child) {
			if(!c.equals(parent)) {
				w.switchTo().window(c);
				Thread.sleep(2000);
				w.close();
				w.switchTo().window(parent);
			}
		}
	}
	@AfterClass
	public void close() {
		w.close();
	}

}
