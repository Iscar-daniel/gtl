package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);

        webDriver.get("https://www.saucedemo.com/");
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("standard_user");
        webDriver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_log")));

        Select dropdownHomepage = new Select(webDriver.findElement(By.className("product_sort_container")));
        dropdownHomepage.selectByValue("hilo");


        List<WebElement> price = webDriver.findElements(By.className("//div[@class='inventory_item_price]")).stream().toList();
        List<Float> listPrice = new ArrayList<>();
        for (WebElement i : price
        ) {
            listPrice.add(new Float(i.getText().substring(1)));
        }

        check_descending();


    }

    public boolean check_descending(List<Float> floatList){
        boolean status=true;
        List<Float> sortedList= new ArrayList<>();
        sortedList=floatList.sort(Collections.<Float>reverseOrder());
        for (int i = 0; i < floatList.size(); i++) {
            if (sortedList.get() != floatList.get(i)){
                status=false;
                break;
            }
        }
        return status;
    }
}