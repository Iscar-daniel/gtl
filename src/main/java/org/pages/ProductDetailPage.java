package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pageObject.PageObject;

public class ProductDetailPage extends PageObject {


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return webDriver.findElement(By.className("inventory_details_name")).toString();
    }

    public Float getProductPrice() {
        return new Float(webDriver.findElement(By.className("inventory_details_price")).getText().substring(1));
    }

    public void clickAddToCart() {
        webDriver.findElement(By.xpath("//button[contains(@id,'add-to-cart')]")).click();

    }


}
