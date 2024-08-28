package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    public static WebDriver driver;
    public ActionsBot bot;
    public static Logger logger;
    protected  Wait<WebDriver> wait;


    public WebDriver startserver() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("8.1");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");
//        options.setApp(apkPath);
        options.setNoReset(false);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/"), options);
        bot = new ActionsBot(driver, wait, logger);

        return driver;
    }

public static void tearDown(){
        driver.quit();
}
//    @Step("Terminating the phone")
//    @AfterMethod

}
