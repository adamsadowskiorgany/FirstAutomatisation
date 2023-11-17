import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class MyStoreCheckout {

    WebDriver webDriver;



    public MyStoreCheckout(WebDriver webDriver) {
        this.webDriver = webDriver;


    }
    public void IProceedToCheckout()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));
        element.click();
        webDriver.findElement(By.cssSelector("a[href*=\"controller=order\"].btn.btn-primary")).click();
//
       }

      public void IConfirmAddress() {
        webDriver.findElement(By.cssSelector("button[name=\"confirm-addresses\"]")).click();
      }

      public void IConfirmShippingWay() {
        webDriver.findElement(By.cssSelector("button[name='confirmDeliveryOption']")).click();
      }
public void IClickPayByCheck() {
        webDriver.findElement(By.xpath("//*[@id=\"payment-option-1-container\"]/label/span")).click();

}
public void iAcceptTermsOfUse() {
    webDriver.findElement(By.cssSelector("label[class='js-terms']")).click();
}
public void iPlaceOrder() {
    WebDriverWait wait = new WebDriverWait(webDriver, 3);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"))); element.click();

}
public void TakeScreenshot(String FileUtils) {

    File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

    // Ścieżka do miejsca, gdzie zapiszę plik oraz końcowa nazwa pliku pod zmienną FileUtils
    String destinationPath = System.getProperty("user.dir") + "/src/main/screenshots/" + FileUtils +".png";


    try {
        // Zapisywanie zrzutem ekranu do docelowej lokalizacji
        java.nio.file.Files.copy(screenshot.toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        System.out.println("Błąd podczas kopiowania pliku: " + e.getMessage());
    }
}
}




