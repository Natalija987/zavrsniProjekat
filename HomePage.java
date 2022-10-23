package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver webDriver;

    public static final String URL = "https://petstore.octoperf.com/";
    public static final String ENTER_THE_STORE_BUTTON = "//a[contains(text(),'Enter the Store')]";
    public static final String MENU_URL = "https://petstore.octoperf.com/actions/Catalog.action";
    public static final String MENU_FISH_BTN_XPATH = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[2]/div[1]/div[1]/a[1]";
    public static final String MENU_DOGS_BTN_XPATH = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[2]/div[1]/div[1]/a[2]";
    public static final String MENU_CATS_BTN_XPATH = "//div[@id='Content']//a[3]//img[1]";
    public static final String MENU_REPTILES_BTN_XPATH = "//div[@id='Content']//a[4]//img[1]";
    public static final String MENU_BIRDS_BTN_XPATH = "//div[@id='Content']//a[5]//img[1]";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public static WebElement getEnterButton(WebDriver driver) {
        return driver.findElement(By.xpath(ENTER_THE_STORE_BUTTON));
    }
    public static void clickEnterBtn(WebDriver driver) {
        getEnterButton(driver).click();
    }

    public static WebElement getFish(WebDriver driver) {
        return driver.findElement(By.xpath(MENU_FISH_BTN_XPATH));
    }
    public static void clickFish(WebDriver driver) {
        getFish(driver).click();
    }

    public static WebElement getDogs(WebDriver driver) { return driver.findElement(By.xpath(MENU_DOGS_BTN_XPATH)); }
    public static void clickDogs(WebDriver driver) {    getDogs(driver).click();    }


    public static WebElement getCats(WebDriver driver) {     return driver.findElement(By.xpath(MENU_CATS_BTN_XPATH));   }
    public static void clickCats(WebDriver driver) {
        getCats(driver).click();
    }

    public static WebElement getReptiles(WebDriver driver) {return driver.findElement(By.xpath(MENU_REPTILES_BTN_XPATH));  }
    public static void clickReptiles(WebDriver driver) {
        getReptiles(driver).click();
    }

    public static WebElement getBirds(WebDriver driver) {  return driver.findElement(By.xpath(MENU_BIRDS_BTN_XPATH));  }
    public static void clickBirds(WebDriver driver) {
        getBirds(driver).click();
    }

}