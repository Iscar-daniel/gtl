package org.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageObject {

    protected WebDriver webDriver;
    protected WebDriverWait wait ;

    public PageObject(WebDriver driver){
        this.webDriver=driver;
        wait=new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }
}
