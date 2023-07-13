package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    protected WebDriver webDriver;


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void clickCheckout() {
        webDriver.findElement(By.id("checkout")).click();
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
        return new Float(webDriver.findElement(By.className("inventory_item_price]")).getText().substring(1));
    }

    public void clickFinish() {
        webDriver.findElement(By.id("finish")).click();
    }


}