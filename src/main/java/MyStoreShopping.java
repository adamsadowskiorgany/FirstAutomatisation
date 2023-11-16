import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
public class MyStoreShopping {

    WebDriver webDriver;
    WebDriverWait wait;

    public MyStoreShopping(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = wait;
    }
    public void ISearchProduct(String product) {
        WebElement inputSearch = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"))); inputSearch.sendKeys(product);

        webDriver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")).sendKeys(Keys.ENTER);
    }




}
