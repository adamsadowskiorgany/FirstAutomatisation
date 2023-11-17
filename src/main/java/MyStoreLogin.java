import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyStoreLogin {

    WebDriver webDriver;


    public MyStoreLogin(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void iChooseShopPage() {
        webDriver.get("https://mystore-testlab.coderslab.pl/");
    }
    public void iGoToLoginPage() {
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
    }


    public void iTypeLogin(String login) {
        webDriver.findElement(By.cssSelector("input[id=field-email]")).sendKeys(login);
    }


    public void iTypePassword(String password) {
        webDriver.findElement(By.cssSelector("input[id=field-password]")).sendKeys(password);
    }


    public void iClickLoginButton() {
        webDriver.findElement(By.cssSelector("button[type=submit]")).click();
    }


    public void iAmLoggedIn() {
        String expectedResult = "Noga Nogowski";
        String currentText =  webDriver.findElement(By.className("hidden-sm-down")).getText();
        Assert.assertTrue(currentText.contains(expectedResult));
    }
}
