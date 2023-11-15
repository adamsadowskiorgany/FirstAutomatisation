import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MusicShop {


    WebDriver webDriver;
    WebDriverWait wait;
    public MusicShop(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public MusicShop(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openMuzykShop() {
        webDriver.get("https://www.adamsadowskimuzyk.pl/");
    }
    public void selectShop(){
        WebElement element = webDriver.findElement(By.xpath("//*[contains(text(), 'Sklep')]"));

        element.click();
    }

    public void selectProduct(){
        WebElement element = webDriver.findElement(By.xpath("//*[contains(text(), '3in1')]"));

        element.click();
    }
    public void backToPreviousPage(){
        webDriver.navigate().back();
    }

    public void forwardToNextPage() {
        webDriver.navigate().forward();
    }
    public void refreshPage() {
        webDriver.navigate().refresh();
    }

}


