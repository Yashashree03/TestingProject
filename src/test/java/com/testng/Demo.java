package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	
	@Test(priority = 2, invocationCount = 2, enabled= true)
	public void google() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.google.com");
		w.quit();
	}
	
	@Test(priority = 1, enabled = true)
	public void facebook() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.facebook.com");
		w.quit();
	}

}
