import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreSizeAndNumber {
    WebDriver webDriver;
    WebDriverWait wait;

    public MyStoreSizeAndNumber(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = wait;
    }
    public void IClickProductAgain() {
        WebElement clickProduct = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[1]/a/img"))); clickProduct.click();
//
    }

    public void ITypeSizeAndQuantity(String size, String quantity) {}
}
