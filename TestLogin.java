package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;

import java.time.Duration;

public class TestLogin {
    WebDriver webDriver;
    public LogIn logIn;
    public LogOut logOut;

    public static final String LOGIN_URL = "https://jpetstore.aspectran.com/account/signonForm";
    private static final String INVALID_USERNAME="bftht";
    private static final String VALID_USERNAME="j2ee";
    private static final String INVALID_PASSWORD="btHNh";
    private static final String VALID_PASSWORD="j2ee";

    @BeforeMethod
    public void pageSetUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\New folder\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logIn=new LogIn(webDriver);
        logOut=new LogOut(webDriver);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(LOGIN_URL);

    }

    @Test(priority = 10)
    public  void successfulLoginUser() {

        logIn.insertUsername(VALID_USERNAME);
        logIn.insertPassword(VALID_PASSWORD);
        logIn.clickOnLoginButton();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jpetstore.aspectran.com/catalog/","Welcome!");
        Assert.assertTrue(logOut.getLogOutButton().isDisplayed());
    }

    @Test (priority = 20)
    public void unsuccessfulLoginWithInvalidUsername() {
        logIn.insertUsername(INVALID_USERNAME);
        logIn.insertPassword(VALID_PASSWORD);
        logIn.clickOnLoginButton();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jpetstore.aspectran.com/account/signonForm?retry=true");

    }

    @Test (priority = 30)
    public void unsuccessfulLoginWithInvalidPassword() {
        logIn.insertUsername(VALID_USERNAME);
        logIn.insertPassword(INVALID_PASSWORD);
        logIn.clickOnLoginButton();
        Assert.assertTrue(logIn.getLoginButton().isDisplayed());
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jpetstore.aspectran.com/account/signonForm?retry=true");

    }
    @Test (priority = 40)
    public void unsuccessfulLoginWithInvalidUsernameAndPassword() {
        logIn.insertUsername(INVALID_USERNAME);

        logIn.insertPassword(INVALID_PASSWORD);
        logIn.clickOnLoginButton();
        Assert.assertTrue(logIn.getLoginButton().isDisplayed());
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jpetstore.aspectran.com/account/signonForm?retry=true");

    }

    @Test(priority = 50)
    public void userSuccessfulLogOut() {
        logIn.insertUsername(VALID_USERNAME);
        logIn.insertPassword(VALID_PASSWORD);
        logIn.clickOnLoginButton();
        logOut.clickOnLogOutButton();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://jpetstore.aspectran.com/catalog/");
    }


   @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

}



