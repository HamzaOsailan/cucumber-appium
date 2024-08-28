package StepD;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ActionsBot;
import utility.TestBase;

import java.net.MalformedURLException;

import static utility.TestBase.tearDown;
//import java.net.URL;
//import java.time.Duration;

public class StepDefinition {

    TestBase testBase =new TestBase();
    public WebDriver driver;


    By webviewNav = By.xpath("//*[@text='Webview']");
    By loginNav = By.xpath("//*[@text='Login']");
    By forms =By.xpath("//*[@text='Forms']");


    @Before("@setup")
    public void setUp() throws Throwable {
        driver = testBase.startserver();
    }

    @Given("the app is open")
    public void the_app_is_open() throws MalformedURLException {
        driver.findElement(loginNav).click();
        System.out.println("a");


    }
    @When("I click the login button")
    public void i_click_the_login_button() {
     driver.findElement(webviewNav).click();
        System.out.println("b");
    }
    @Then("I should see the login screen")
    public void i_should_see_the_login_screen() {
        driver.findElement(forms).click();
        System.out.println("c");
    }
    @Then("tearDown")
    public void tear_down() {
        tearDown();
    }

}
