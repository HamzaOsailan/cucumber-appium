package StepD;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestBase;

import java.net.MalformedURLException;
import java.time.Duration;

import static utility.TestBase.*;

public class StepDefinition {

    TestBase testBase = new TestBase();
    public WebDriver driver;
    private WebDriverWait wait;

    By webviewNav = By.xpath("//*[@text='Webview']");
    By loginNav = By.xpath("//*[@text='Login']");
    By forms = By.xpath("//*[@text='Forms']");
    AppiumBy email = (AppiumBy) AppiumBy.accessibilityId("input-email");
    By password = By.xpath("//*[@content-desc='input-password']");
    By loginButton = By.xpath("//*[@text='LOGIN']");
    By successfully = By.xpath("//*[@resource-id='android:id/message']");

    @Before("@setup")
    public void setUp() throws Throwable {
        driver = testBase.startserver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Initialize WebDriverWait
       loadTestData();
    }

    @Given("the app is open")
    public void the_app_is_open() throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(loginNav)).click();
        Thread.sleep(6000);
        // Retrieve test data
        String username = (String) testData.get("Username");
        String passwordValue = (String) testData.get("Password");

        System.out.println(username);
        System.out.println(passwordValue);

        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(passwordValue);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(loginButton).click();
        // Implement necessary verification or actions after clicking the login button
    }

    @Then("I should see the login screen")
    public void i_should_see_the_login_screen() {
        // Add assertion or verification logic as needed
        System.out.println("Login screen is visible.");
    }

    @Then("tearDown")
    public void tear_down() {
        tearDown();  // Properly terminate the driver session
    }
}
