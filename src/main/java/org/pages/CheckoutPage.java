package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pageObject.PageObject;

public class CheckoutPage extends PageObject {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public void clickCheckout() {
        webDriver.findElement(By.id("checkout")).click();
    }
    public void clickContinue() {
        webDriver.findElement(By.id("continue")).click();
    }

    public void fillFirstname(String text) {
        webDriver.findElement(By.id("first-name")).sendKeys(text);
    }

    public void fillLastName(String text) {
        webDriver.findElement(By.id("last-name")).sendKeys(text);
    }

    public void fillZipCode(String text) {
        webDriver.findElement(By.id("postal-code")).sendKeys(text);

    }

    public String getProductName() {
        return webDriver.findElement(By.className("inventory_item_name")).toString();
    }

    public Float getProductPrice() {
        return new Float(webDriver.findElement(By.className("inventory_item_price")).getText().substring(1));
    }

    public void clickFinish() {
        webDriver.findElement(By.id("finish")).click();
    }

    public boolean isThankyouTextAvailable(){
        return webDriver.findElement(By.xpath("//h2[contains(text(),'Thank you')]")).isDisplayed();
    }

}