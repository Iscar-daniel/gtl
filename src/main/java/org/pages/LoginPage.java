package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pageObject.PageObject;


public class LoginPage extends PageObject {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inserUsername(String text) {
        webDriver.findElement(By.id("user-name")).sendKeys(text);
    }

    public void insertPassword(String text) {
        webDriver.findElement(By.id("password")).sendKeys(text);
    }

    public void clickLogin() {
        webDriver.findElement(By.id("login-button")).click();
    }

    public boolean isHomepageAvailable() {
        By logo = By.className("app_logo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        return webDriver.findElement(logo).isDisplayed();
    }
}
