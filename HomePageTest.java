package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class HomePageTest {
    public WebDriver webDriver;
    public HomePage homePage;


    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\New folder\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

    }
    @Test
    public void enterTheStoreTest(){
        webDriver.get("https://petstore.octoperf.com/");
        HomePage.getEnterButton(webDriver);
        HomePage.clickEnterBtn(webDriver);
        String currUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://petstore.octoperf.com/actions/Catalog.action");
        webDriver.close();
    }

    @Test
    public void menuFish() throws InterruptedException {
        webDriver.get("https://jpetstore.aspectran.com/catalog/");
        HomePage.getFish(webDriver);
        HomePage.clickFish(webDriver);
        String UrlFish = webDriver.getCurrentUrl();
        Thread.sleep(1000);
        UrlFish = UrlFish.replaceAll(";jsessionid=[^?]*", "");
        Thread.sleep(1000);
        Assert.assertEquals(UrlFish, "https://jpetstore.aspectran.com/catalog/categories/FISH");
    }

        @Test
        public void menuDogs() throws InterruptedException {
            webDriver.get("https://jpetstore.aspectran.com/catalog/");
            HomePage.getDogs(webDriver);
            HomePage.clickDogs(webDriver);
            String UrlDogs = webDriver.getCurrentUrl();
            UrlDogs = UrlDogs.replaceAll(";jsessionid=[^?]*", "");
            Assert.assertEquals(UrlDogs,
                    "https://jpetstore.aspectran.com/catalog/categories/DOGS");


        }
         @Test
            public void menuCats() throws InterruptedException {
             webDriver.get("https://jpetstore.aspectran.com/catalog/");
             HomePage.getCats(webDriver);
             HomePage.clickCats(webDriver);
             Thread.sleep(1000);
             String UrlCats = webDriver.getCurrentUrl();
             UrlCats = UrlCats.replaceAll(";jsessionid=[^?]*", "");
             Assert.assertEquals(UrlCats,
                     "https://jpetstore.aspectran.com/catalog/categories/CATS");
         }

             @Test
             public void menuReptiles() throws InterruptedException {
                 webDriver.get("https://jpetstore.aspectran.com/catalog/");
                 HomePage.getReptiles(webDriver);
                 HomePage.clickReptiles(webDriver);
                 Thread.sleep(1000);
                 String UrlReptiles = webDriver.getCurrentUrl();
                 UrlReptiles = UrlReptiles.replaceAll(";jsessionid=[^?]*", "");
                 Assert.assertEquals(UrlReptiles,
                         "https://jpetstore.aspectran.com/catalog/categories/REPTILES");


             }
    @Test
    public void menuBirds() throws InterruptedException {
        webDriver.get("https://jpetstore.aspectran.com/catalog/");
        HomePage.getBirds(webDriver);
        HomePage.clickBirds(webDriver);
        Thread.sleep(1000);
        String UrlBirds = webDriver.getCurrentUrl();
        UrlBirds = UrlBirds.replaceAll(";jsessionid=[^?]*", "");
        Assert.assertEquals(UrlBirds,
                "https://jpetstore.aspectran.com/catalog/categories/BIRDS");

    }
}
