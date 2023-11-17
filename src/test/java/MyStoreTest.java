import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreTest {

    WebDriver webDriver;
    WebDriverWait wait;

    MyStoreLogin myStoreLogin;

    MyStoreShopping myStoreShopping;


    MyStoreSizeAndNumber myStoreSizeAndNumber;

    MyStoreCheckout myStoreCheckout;

    @Before
    public void openBrowser() {
        webDriver = MyUtils.getWebDriver("Chrome");
        wait = new WebDriverWait(webDriver, 3);
        webDriver.manage().window().maximize();
        myStoreLogin = new MyStoreLogin(webDriver);
        myStoreShopping = new MyStoreShopping(webDriver);
        myStoreSizeAndNumber = new MyStoreSizeAndNumber(webDriver);
        myStoreCheckout = new MyStoreCheckout(webDriver);
    }

    @After
    public void closeBrowser() {
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    @Test
    public void OpenMyStore() {
        myStoreLogin.iChooseShopPage();
        myStoreLogin.iGoToLoginPage();
        myStoreLogin.iTypeLogin("noga@gmail.com");
        myStoreLogin.iTypePassword("noga1234");
        myStoreLogin.iClickLoginButton();
        myStoreLogin.iAmLoggedIn();
        myStoreShopping.ISearchProduct("Hummingbird Printed Sweater");
        myStoreSizeAndNumber.IClickProductAgain();
        myStoreSizeAndNumber.ITypeSizeAndQuantity("M", 7);
        myStoreSizeAndNumber.IAddToCart();
        myStoreCheckout.IProceedToCheckout();
        myStoreCheckout.IConfirmAddress();
        myStoreCheckout.IConfirmShippingWay();
        myStoreCheckout.IClickPayByCheck();
        myStoreCheckout.iAcceptTermsOfUse();
        myStoreCheckout.iPlaceOrder();
        myStoreCheckout.TakeScreenshot("MyStoreOrder1");
    }
}
