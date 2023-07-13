package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Homepage {

    protected WebDriver webDriver;


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickDropdown(String value) {
        Select dropdownHomepage = new Select(webDriver.findElement(By.className("product_sort_container")));
        dropdownHomepage.selectByValue(value);
    }

    public List<Float> getAllPrices() {
        List<WebElement> price = webDriver.findElements(By.className("//div[@class='inventory_item_price]")).stream().toList();
        List<Float> listPrice = new ArrayList<>();
        for (WebElement i : price
        ) {
            listPrice.add(new Float(i.getText().substring(1)));
        }
        return listPrice;
    }

    public String getProductName(int number) {
        return webDriver.findElement(By.xpath("//div[@class='inventory_item']["+number+"]//div[@class='inventory_item_name']")).getText();
    }

    public Float getProductPrice(int number){
        return new Float(webDriver.findElement(By.xpath("//div[@class='inventory_item']["+number+"]//div[@class='inventory_item_price]")).getText().substring(1));
    }

    public void clickImage(int number)
    {
        webDriver.findElement(By.xpath("//div[@class='inventory_item']["+number+"]//div[@class='inventory_item_img']")).click();
    }

    public void clickCart(){
        webDriver.findElement(By.className("shopping_cart_link")).click();
    }
}
