package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
     public WebDriver webDriver;
    public WebElement username;
     public WebElement password;
    public WebElement loginButton;

    public LogIn(WebDriver webDriver){
        this.webDriver=webDriver;

    }
    public WebElement getUsername() {
        return webDriver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[1]/input[1]"));
    }

    public WebElement getPassword() {
        return webDriver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[2]/input[1]"));
    }

    public WebElement getLoginButton() {
        return webDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
    }


    public void insertUsername(String name) {
        getUsername().clear();
        getUsername().sendKeys(name);
    }

    public void insertPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }


}

