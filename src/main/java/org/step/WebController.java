package org.step;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.pages.CheckoutPage;
import org.pages.Homepage;
import org.pages.LoginPage;
import org.pages.ProductDetailPage;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class WebController {


    WebDriver webDriver;
    LoginPage loginPage;
    Homepage homepage;
    ProductDetailPage detailPage;
    CheckoutPage checkoutPage;


    public WebController(WebDriver driver) {

        this.webDriver = driver;
        this.loginPage = new LoginPage(webDriver);
        this.homepage = new Homepage(webDriver);
        this.detailPage = new ProductDetailPage(webDriver);
        this.checkoutPage = new CheckoutPage(webDriver);
    }

    public void openPage() {
        webDriver.get("https://www.saucedemo.com/");
    }

    public void login() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.inserUsername("standard_user");
        loginPage.insertPassword("secret_sauce");
        loginPage.clickLogin();
    }

    public boolean isHomepageAvailable() {

        return loginPage.isHomepageAvailable();

    }

    public void clickDropdown(String value) {
        homepage.clickDropdown(value);
    }

    public boolean isMaxToMin() {
        Boolean isSorted = true;
        List<Float> listPrices = homepage.getAllPrices();
        Float maxValue = listPrices.get(0);
        for (Float price : listPrices
        ) {
            if (price > maxValue) {
                isSorted = false;
                break;
            }
        }

        return isSorted;
    }

    public void selectProduct(int number) {
        homepage.clickImage(number);
    }

    public boolean isHomepageAndDetailSame(int i) {
        boolean isSame = true;
        String homepageProductName = homepage.getProductName(i);
        Float homepageProductPrice = homepage.getProductPrice(i);
        homepage.clickImage(i);
        String detailProductName = detailPage.getProductName();
        Float detailProductPrice = detailPage.getProductPrice();

        if ((homepageProductName.equalsIgnoreCase(detailProductName)) || (homepageProductPrice.floatValue() != detailProductPrice.floatValue())) {
            isSame = false;
        }
        return true;
    }

    public boolean isDetailAndCheckoutSame() {
        boolean isSame = true;
        String detailProductName = detailPage.getProductName();
        Float detailProductPrice = detailPage.getProductPrice();
        buyProduct();
        String checkoutPageProductName = checkoutPage.getProductName();
        Float checkoutPageProductPrice = checkoutPage.getProductPrice();

        if ((detailProductName.equalsIgnoreCase(checkoutPageProductName)) || (checkoutPageProductPrice.floatValue() != detailProductPrice.floatValue())) {
            isSame = false;
        }
        return true;
    }


    public void buyProduct() {
        detailPage.clickAddToCart();
        homepage.clickCart();

    }


    public void takeScreenshot() {
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("image/result.jpg");
        try {
            destFile.mkdir();
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkoutProduct() {
        checkoutPage.clickCheckout();
        checkoutPage.fillFirstname("firstly");
        checkoutPage.fillLastName("lastly");
        checkoutPage.fillZipCode("11111");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

    }

    public boolean isOrderProcessed() {
        return checkoutPage.isThankyouTextAvailable();
    }

}
