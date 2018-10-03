package com.amazon.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
	WebDriver dir;
	By hmSearchbx = By.id("twotabsearchtextbox");
	By hmSearchBtn = By.xpath("//input[@value='Go']");
	By hmResult = By
			.xpath("//li[@id='result_0']//img[@class='s-access-image cfMarker']");
	By hmAddCartbtn = By.id("add-to-cart-button");
	By hmAddCartLink = By.id("nav-cart");
	By hmCartValue = By.id("a-autoid-0-announce");
	By hmProceedbtn = By.xpath("//input[@value='Proceed to checkout']");

	public AmazonHomePage(WebDriver dir) {
		this.dir = dir;
	}

	public void setSearchInput(String input) {
		dir.findElement(hmSearchbx).sendKeys(input);
	}

	public void clickSearchBtn() {
		dir.findElement(hmSearchBtn).click();
	}

	public void clicklink() {
		dir.findElement(hmResult).click();
	}

	public String getPageTitle() {
		return dir.getTitle();
	}

	public void clickAddtoCartbtn() {
		dir.findElement(hmAddCartbtn).click();
	}

	public String getValueofCart() {
		dir.findElement(hmAddCartLink).click();
		return dir.findElement(hmCartValue).getText();
	}

	public void clickProceedtocheckout() {
		dir.findElement(hmProceedbtn).click();
	}

}
