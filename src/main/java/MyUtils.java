
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyUtils {

    public static WebDriver getWebDriver(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                return new ChromeDriver();
            }
            case "FIREFOX": {
                System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
                return new FirefoxDriver();
            }
            default: {
                System.out.println("Nie istnieje taka przegladarka");
                Assert.fail("Nie istnieje taka przeglądarka");
                return null;
            }
        }
    }
}