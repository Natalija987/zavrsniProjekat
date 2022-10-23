package test;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Account;
import pages.LogIn;
import pages.SignUp;

import java.time.Duration;

public class TestSignUp {
    private WebDriver webDriver;
    private SignUp signUp;
    private Select select;
    private LogIn logIn;
    private Account account;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\New folder\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        signUp = new SignUp(webDriver,select);
        account = new Account(webDriver);
        webDriver.get("https://jpetstore.aspectran.com/account/newAccountForm");
        webDriver.manage().window().maximize();
    }
    @Test (priority = 10)
    public void successufullSignUp() {

        signUp.inputUserId(Faker.instance().bothify("??????????"));
        signUp.inputPassword("Nac515");
        signUp.inputRepeatPassword("Nac515");
        signUp.inputFirstName("dfgge");
        signUp.inputLastName("dfggdg");
        signUp.inputEmail(Faker.instance().bothify("******@yahoo.com"));
        signUp.inputPhone("4644565");
        signUp.inputAddress1("fgdf");
        signUp.inputAddress2("fhhffh");
        signUp.inputCity("fdch");
        signUp.inputState("fhd");
        signUp.inputZip("645");
        signUp.inputCountry("ssrt");
        signUp.selectLanguage("French");
        signUp.selectCategory("Dogs");
        signUp.clickOnCheckMyList();
        signUp.clickOnCheckMyBanner();
        signUp.saveAccountInformation();
        Assert.assertEquals(account.getAccountCreatedText(), "Your account has been created. Please try login.",
                "Your account has been created");

    }

    @Test (priority = 20)
    public void unsuccessufulSignUpWrongPassword() {

        signUp.inputUserId(Faker.instance().bothify("??????????"));
        signUp.inputPassword("Nac515");
        signUp.inputRepeatPassword("Nac55");
        signUp.inputFirstName("dfgge");
        signUp.inputLastName("dfggdg");
        signUp.inputEmail(Faker.instance().bothify("******@yahoo.com"));
        signUp.inputPhone("4644565");
        signUp.inputAddress1("fgdf");
        signUp.inputAddress2("fhhffh");
        signUp.inputCity("fdch");
        signUp.inputState("fhd");
        signUp.inputZip("645");
        signUp.inputCountry("ssrt");
        signUp.selectLanguage("French");
        signUp.selectCategory("Dogs");
        signUp.clickOnCheckMyList();
        signUp.clickOnCheckMyBanner();
        signUp.saveAccountInformation();
        Assert.assertEquals(signUp.getUnsuccesfullRegistrationText(), "Passwords do not match", "Passwords do not match" );

    }

    @Test (priority = 30)
    public void testSignOut(){
        signUp.clickOnSignOut();
    }

    @AfterMethod
    public void close() {
        webDriver.close();
    }


}


