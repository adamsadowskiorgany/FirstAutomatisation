import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreCheckout {

    WebDriver webDriver;
    WebDriverWait wait;

    public MyStoreCheckout(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = wait;
    }
    public void IProceedToCheckout()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));
        element.click();
//
       }
}

