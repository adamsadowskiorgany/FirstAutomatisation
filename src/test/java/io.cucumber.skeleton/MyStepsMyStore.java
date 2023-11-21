package io.cucumber.skeleton;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

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

        WebElement addressInput = webDriver.findElement(By.xpath("//*[@id=\"field-address1\"]")); addressInput.sendKeys(address);
        WebElement cityInput = webDriver.findElement(By.xpath("//*[@id=\"field-city\"]")); cityInput.sendKeys(city);

        WebElement postalCodeInput = webDriver.findElement(By.xpath("//*[@id=\"field-postcode\"]")); postalCodeInput.sendKeys(postalCode);
        WebElement countryInput = webDriver.findElement(By.xpath("//*[@id=\"field-id_country\"]")); countryInput.sendKeys(country);
        WebElement phoneInput = webDriver.findElement(By.xpath("//*[@id=\"field-phone\"]")); phoneInput.sendKeys(phone);}



    @And("I submit the form")
    public void iSubmitTheForm() {
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("the new address should be added successfully")
    public void theNewAddressShouldBeAddedSuccessfully() {
        String expectedResult = "Address successfully added!";
        String currentText =  webDriver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText();
        Assert.assertTrue(currentText.contains(expectedResult));
    }

    @And("the details of the added address should be correct {string}")
    public void theDetailsOfTheAddedAddressShouldBeCorrect(String screen) {
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        // Ścieżka do miejsca, gdzie zapiszę plik oraz końcowa nazwa pliku pod zmienną screen
        String destinationPath = System.getProperty("user.dir") + "/src/main/screenshots/" + screen +".png";


        try {
            // Zapisywanie zrzutem ekranu do docelowej lokalizacji
            java.nio.file.Files.copy(screenshot.toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Błąd podczas kopiowania pliku: " + e.getMessage());
        }
    }
    @After
    public void closeBrowser() {
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

}
