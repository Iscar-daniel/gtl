package step;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.CheckoutPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.ProductDetailPage;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class WebSteps {


    WebDriver webDriver;
    LoginPage loginPage = new LoginPage();
    Homepage homepage = new Homepage();
    ProductDetailPage detailPage = new ProductDetailPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    public WebDriver openPage() {
        WebDriver webDriver = new ChromeDriver();
        this.webDriver = webDriver;
        return webDriver;
    }

    public void login(WebDriver webDriver) {
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
        String checkoutPageProductName = checkoutPage.getProductName();
        Float checkoutPageProductPrice = checkoutPage.getProductPrice();

        if ((detailProductName.equalsIgnoreCase(detailProductName)) || (homepageProductPrice.floatValue() != detailProductPrice.floatValue())) {
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
        File destFile = new File("image");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
