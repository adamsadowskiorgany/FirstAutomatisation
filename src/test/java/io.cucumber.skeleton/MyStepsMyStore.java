package io.cucumber.skeleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepsMyStore {

    WebDriver webDriver;
    WebDriverWait wait;
    @Given("I open a browser")
    public void iOpenABrowser() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 3);
        webDriver.manage().window().maximize();
    }

    @And("I choose shop page")
    public void iChooseShopPage() {
        webDriver.get("https://mystore-testlab.coderslab.pl/");
    }
    @And("I go to login page")
    public void iGoToLoginPage() {
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
    }

    @When("I type {string} login")
    public void iTypeLogin(String login) {
        webDriver.findElement(By.cssSelector("input[id=field-email]")).sendKeys(login);
    }

    @And("I type {string} password")
    public void iTypePassword(String password) {
        webDriver.findElement(By.cssSelector("input[id=field-password]")).sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        webDriver.findElement(By.cssSelector("button[type=submit]")).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        String expectedResult = "Noga Nogowski";
        String currentText =  webDriver.findElement(By.className("hidden-sm-down")).getText();
        Assert.assertTrue(currentText.contains(expectedResult));
    }

    @And("I go to address page")
    public void iGoToAddressPage() {
        webDriver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses ");
    }

    @When("I click create new address")
    public void iClickCreateNewAddress() {
        webDriver.findElement(By.xpath("//*[contains(text(), 'Create new address')]")).click();
    }



    @And("I fill out  alias {string}, address {string}, city {string}, postal code {string}, country {string}, phone {string}")
    public void iFillOutAliasAddressCityPostalCodeCountryPhone(String alias, String address, String city, String postalCode, String country, String phone) {
        WebElement aliasInput = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.name("alias")));
        aliasInput.sendKeys(alias);
//        webDriver.findElement(By.name("input[name='alias']")).sendKeys(alias);
//        WebElement addressInput = new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(By.name("address1")));
//        addressInput.sendKeys(address);
        webDriver.findElement(By.name("input[name='address1']")).sendKeys(address);
        webDriver.findElement(By.name("input[name='city']")).sendKeys(city);
        webDriver.findElement(By.name("input[name='postcode'']")).sendKeys(postalCode);
        webDriver.findElement(By.xpath("//*[@id=\"field-id_country\"]")).sendKeys(country);
        webDriver.findElement(By.name("input[name='phone']")).sendKeys(phone);}



    @And("I submit the form")
    public void iSubmitTheForm() {
    }

    @Then("the new address should be added successfully")
    public void theNewAddressShouldBeAddedSuccessfully() {
    }

    @And("the details of the added address should be correct")
    public void theDetailsOfTheAddedAddressShouldBeCorrect() {
    }

}
