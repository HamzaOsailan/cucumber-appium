package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import utility.ActionsBot;
import utility.PageBase;

public class LoginAndSignUp extends PageBase{

    static By Email =By.xpath("//*[@content-desc='input-email']");
    static By password =By.xpath("//*[@content-desc='input-password']");
    static By confirmPassword =By.xpath("//*[@content-desc='input-repeat-password']");
    By loginNav = By.xpath("//*[@text='Login']");

    By loginButton =By.xpath("//*[@text='LOGIN']");
    static By signUpButton =By.xpath("//*[@content-desc='button-SIGN UP']");

    By LoginSuccessfullyTest =By.xpath("//*[@resource-id='android:id/message']");
    static By SignUpSuccessfullyTest= By.xpath("//*[@resource-id='android:id/message']");

    static By SignUpPageButton =By.xpath("//*[@text='Sign up']");
//    public LoginAndSignUp(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
//        super(driver, bot, wait);
//    }
    public WebDriver driver;

    public LoginAndSignUp(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }


    //    @Given("successful login")
//    public String SignUp(){
//        bot.click(SignUpPageButton);
////        wait.until(ExpectedConditions.presenceOfElementLocated(SignUpPageButton));
//        bot.type(Email,"hamzaosailan@hotmail.com");
//        bot.type(password,"Xoxo5566xu1z");
//        bot.type(confirmPassword,"Xoxo5566xu1z");
//        bot.click(signUpButton);
//        wait.until(ExpectedConditions.presenceOfElementLocated(SignUpSuccessfullyTest));
//        return driver.findElement(SignUpSuccessfullyTest).getText();
//    }
//    @When("successful SignUp")
    public String Login(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(Email));
//        bot.type(Email,"hamzaosailan@hotmail.com");
//        bot.type(password,"Xoxo5566xu1z");
//        bot.LongPress(loginButton);
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(LoginSuccessfullyTest));
//        return driver.findElement(LoginSuccessfullyTest).getText();

        driver.findElement(loginNav).click();
        driver.findElement(Email).sendKeys("hello");
        driver.findElement(password).sendKeys("hello");
        driver.findElement(loginButton).click();

        return driver.findElement(SignUpSuccessfullyTest).getText();
    }
}
