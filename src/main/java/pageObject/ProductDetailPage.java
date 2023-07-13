package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailPage {

    protected WebDriver webDriver;


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickDropdown(String value) {
        Select dropdownHomepage = new Select(webDriver.findElement(By.className("product_sort_container")));
        dropdownHomepage.selectByValue(value);
    }


    public String getProductName() {
        return webDriver.findElement(By.className("inventory_details_name large_size")).toString();
    }

    public Float getProductPrice() {
        return new Float(webDriver.findElement(By.className("inventory_details_price]")).getText().substring(1));
    }

    public void clickImage(int number) {
        webDriver.findElement(By.xpath("//div[@class='inventory_item'][" + number + "]//div[@class='inventory_item_img']")).click();
    }

    public void clickAddToCart() {
        webDriver.findElement(By.xpath("//button[contains(@id,'add-to-cart')]")).click();

    }


}
