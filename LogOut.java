package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut {

        public WebDriver webDriver;
        public WebElement notificationMessage;
        public  WebElement logOutButton;

        public LogOut(WebDriver driver) {

            this.webDriver = driver;
        }


        public WebElement getLogOutButton() {
            return webDriver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/div[1]/div[2]/div[1]/a[4]"));
        }

        public void clickOnLogOutButton() {
            getLogOutButton().click();
        }

    }

