

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public GooglePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public GooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openGoogleSearch() {
        webDriver.get("https://www.google.com/");
    }

    public void acceptCookies() {
        WebElement element = webDriver.findElement(By.xpath("//button/div[text()='Zaakceptuj wszystko']"));
        element.click();
    }
    public void typePhrase(String phrase) {
        WebElement element = webDriver.findElement(By.tagName("textarea"));
        element.sendKeys(phrase);
    }

    public void performSearch() {
//        WebElement element = webDriver.findElement(By.tagName("textarea"));
//        element.sendKeys(Keys.ENTER);
        webDriver.findElements(By.cssSelector("input[role='button']")).get(0).click();
    }
}