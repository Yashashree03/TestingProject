package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertiontest {
	WebDriver w;
	
	@Test
	public void googlesearch() {
		w = new ChromeDriver();
		w.get("https://www.google.com/");
		w.findElement(By.id("APjFqb")).sendKeys("watch",Keys.ENTER);
		String actualtitle = w.getTitle();
		System.out.println(actualtitle);
		String exptitle ="watch - Google Search";
//		Hard assertion
//		Assert.assertEquals(exptitle, actualtitle);
		System.out.println("Hello");
		
//		Soft assertion
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualtitle, exptitle);
		
	}

}
