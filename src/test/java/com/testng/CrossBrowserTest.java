package com.testng;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver w;
	@Parameters("browser")
	@BeforeClass
	public void LaunchBrowser(String brow) {
		if(brow.equals("chrome")) {
			w = new ChromeDriver();
		}else if(brow.equals("firefox")) {
			w = new FirefoxDriver();
		}
		w.get("https://www.google.com/");
	}
	@Test
	public void productsearch() {
		w.findElement(By.id("APjFqb")).sendKeys("watch",Keys.ENTER);
	}

}
