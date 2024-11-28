package com.cucumber;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo {
	WebDriver w;
	@Given("Launch browser")
	public void launch_browser() {
		 w = new ChromeDriver();
		   w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("Open saucedemo browser")
	public void open_saucedemo_browser() {
		w.get("https://www.saucedemo.com/");
	}

	@When("Enter username and password")
	public void enter_username_and_password(String user) {
		w.findElement(By.id("user-name")).sendKeys(user);
	}

	@When("Click on login")
	public void click_on_login() {
		 w.findElement(By.id("login-button")).click();
	}

	@Then("Verify url of the website")
	public void verify_url_of_the_website() {
		String expurl = "https://www.saucedemo.com/inventory.html";
	    String acturl = w.getCurrentUrl();
	    Assert.assertEquals(expurl, acturl);

	}

	@Then("Logout of the website")
	public void logout_of_the_website() {
		w.findElement(By.id("react-burger-menu-btn")).click();
		w.findElement(By.linkText("Logout")).click();
	}

}
