

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
    WebDriver webDriver;
    WebDriverWait wait;
    GooglePage googlePage;

    MusicShop musicShop;

    @Before
    public void openBrowser() {
        webDriver = MyUtils.getWebDriver("Chrome");
        wait = new WebDriverWait(webDriver, 3);
        googlePage = new GooglePage(webDriver);
        musicShop = new MusicShop(webDriver);
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