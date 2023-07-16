package org.example;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.step.WebController;
import org.junit.Test;
import org.util.ProjectUtil;

import static org.util.ProjectUtil.*;
//import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;

import static org.hamcrest.Matchers.*;

/**
 * Unit test for simple App.
 */
public class CheckoutTest {
    /**
     * Rigorous Test :-)
     */

    // Initialize the WebDriver
    File file = new File(System.getProperty("user.dir") + "/src/driver/chromedriver.exe");
    ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(file).build();
    WebDriver driver = new ChromeDriver(service);
    WebController steps = new WebController(driver);
    ProjectUtil projectUtil=new ProjectUtil();
    @Test
    @Parameterized.Parameters(name = "As customer i can login to the page, and checkout a product")
    public void Login() {

//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"src/driver/chromedriver.exe");
        steps.openPage();
        //login process
        steps.login();

        //verify process
        assertThat("the title is not shown", steps.isHomepageAvailable(), equalTo(true));

        //click sort high to low
        steps.clickDropdown("hilo");

        //verify price
        assertThat("price is not sorted correctly", steps.isMaxToMin(), equalTo(true));

        //click the first product and assert that the product name and price is same
        assertThat("the data is not match", steps.isHomepageAndDetailSame(Integer.parseInt(projectUtil.getProperties("homepage.productOrder"))), equalTo(true));

        //buy the product and checkout. assert that order is being processed
        assertThat("product or price is unmatch", steps.isDetailAndCheckoutSame(), equalTo(true));
        steps.checkoutProduct();
        assertThat("checkoutprocess failed", steps.isOrderProcessed(), equalTo(true));
        //take screenshoot
        steps.takeScreenshot();
        driver.close();

    }

}
