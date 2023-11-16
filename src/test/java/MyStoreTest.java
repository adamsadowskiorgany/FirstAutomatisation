import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreTest {

    WebDriver webDriver;
    WebDriverWait wait;

    MyStoreLogin myStoreLogin;

    @Before
    public void openBrowser() {
        webDriver = MyUtils.getWebDriver("Chrome");
        wait = new WebDriverWait(webDriver, 3);
        webDriver.manage().window().maximize();
        myStoreLogin = new MyStoreLogin(webDriver);
    }

    @Test
    public void OpenMyStore() {
        myStoreLogin.iChooseShopPage();
        myStoreLogin.iGoToLoginPage();
        myStoreLogin.iTypeLogin("noga@gmail.com");
        myStoreLogin.iTypePassword("noga1234");
        myStoreLogin.iClickLoginButton();

    }

}
