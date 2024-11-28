package com.cucumber;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart {
	WebDriver w ;
	@Given("Launch the chrome browser")
	public void launch_the_chrome_browser() {
		w= new ChromeDriver();
	}

	@Given("Open Flipkart Site")
	public void open_flipkart_site() {
		w.get("https://www.flipkart.com/");
	}

	@When("Search the product")
	public void search_the_product() {
		w.findElement(By.name("q")).sendKeys("iphone 16",Keys.ENTER);
	}

	@When("Clickon the search product")
	public void clickon_the_search_product() {
		w.findElement(By.partialLinkText("Apple iPhone 16 (Teal, 128 GB)")).click();
	}

	@Then("Verify the product has been open or not by title")
	public void verify_the_product_has_been_open_or_not_by_title() {
		String parent = w.getWindowHandle();
	    Set<String> child = w.getWindowHandles();
	    for (String ch : child) {
			if (!ch.equals(parent)) {
				
				w.switchTo().window(ch);
				String exptitle = "AppleiPhone 16 (Teal, 128 GB)";
				String acttitle = w.getTitle();
				
				Assert.assertEquals(exptitle, acttitle);
			}
			}

	}

}
