package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends PageObject {


    WebDriver webDriver;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public LoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public LoginPage() {

    }

    public void inserUsername(String text){
        webDriver.findElement(By.id("user-name")).sendKeys(text);
    }

    public void insertPassword(String text){
        webDriver.findElement(By.id("password")).sendKeys(text);
    }

    public void clickLogin(){
        webDriver.findElement(By.id("login-button")).click();
    }
    public boolean isHomepageAvailable(){
        WebDriverWait wait= new WebDriverWait(webDriver, Duration.ofSeconds(30));
        By logo=By.className("app_logo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        return webDriver.findElement(logo).isDisplayed();
    }
}
