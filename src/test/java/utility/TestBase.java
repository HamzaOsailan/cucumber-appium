package utility;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class TestBase {

    public static WebDriver driver;
    public static ActionsBot bot;
    public static Logger logger;
    public static Wait<WebDriver> wait;
    public static JSONObject testData;  // Make this accessible globally

    // Method to load test data from JSON
    public static void loadTestData() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            testData = (JSONObject) jsonObject.get("expandTesting");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public WebDriver startserver() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("8.1");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");
        options.setNoReset(false);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize WebDriverWait
        bot = new ActionsBot(driver, wait, logger);

        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
