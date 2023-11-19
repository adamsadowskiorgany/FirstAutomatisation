

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    WebDriver webDriver;
    WebDriverWait wait;
    GooglePage googlePage;

    MusicShop musicShop;

    @Before
    public void openBrowser() {
        webDriver = MyUtils.getWebDriver("Chrome");
        wait = new WebDriverWait(webDriver, 3);
        webDriver.manage().window().maximize();
        googlePage = new GooglePage(webDriver);
        musicShop = new MusicShop(webDriver);
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
    public void findPhraseTest() {
        googlePage.openGoogleSearch();
        googlePage.acceptCookies();
        googlePage.typePhrase("aktualna godzina");
        googlePage.performSearch();
    }

    @Test
    public void openMyWeb() {
        musicShop.openMuzykShop();
        musicShop.selectShop();
        musicShop.selectProduct();
        musicShop.backToPreviousPage();
        musicShop.forwardToNextPage();

    }
}