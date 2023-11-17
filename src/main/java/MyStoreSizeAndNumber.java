import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreSizeAndNumber {
    WebDriver webDriver;


    public MyStoreSizeAndNumber(WebDriver webDriver) {
        this.webDriver = webDriver;

    }
    public void IClickProductAgain() {
        WebElement clickProduct = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[1]/a/img"))); clickProduct.click();

    }

    public void ITypeSizeAndQuantity(String size, int quantity) {
        webDriver.findElement(By.xpath("//*[@id=\"group_1\"]")).sendKeys(size);
        WebElement quantityInput = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quantity_wanted\"]")));
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        quantityInput.sendKeys(Integer.toString(quantity));

    }
    public void IAddToCart() {
        webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
    }
}
