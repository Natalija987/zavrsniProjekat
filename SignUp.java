package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
    private WebDriver webDriver;
    private Select select;

    @FindBy(name = "username")
    WebElement userID;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "repeatedPassword")
    WebElement repeatPassword;
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastname;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "phone")
    WebElement phone;
    @FindBy(name = "address1")
    WebElement address1;
    @FindBy(name = "address2")
    WebElement address2;
    @FindBy(name = "city")
    WebElement city;
    @FindBy(name = "state")
    WebElement state;
    @FindBy(name = "zip")
    WebElement zip;
    @FindBy(name = "country")
    WebElement country;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[1]/td[2]/select[1]")
    WebElement language;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[2]/td[2]/select[1]")
    WebElement category;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[3]/td[2]/input[1]")
    WebElement checkMyList;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[4]/td[2]/input[1]")
    WebElement checkMyBanner;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/button[1]")
    WebElement saveAccountInformation;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/span[1]")
    WebElement unsuccesfullRegistration;


    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[2]/div[1]/div[2]/div[1]/a[4]")
    WebElement signOut;


    public SignUp(WebDriver webDriver, Select select) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        this.select = select;
    }

    public SignUp() {

    }

    public void inputUserId(String userID) {
        this.userID.sendKeys(userID);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void inputRepeatPassword(String repeatPassword) {
        this.repeatPassword.sendKeys(repeatPassword);
    }

    public void inputFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        this.lastname.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void inputPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void inputAddress1(String address1) {
        this.address1.sendKeys(address1);
    }

    public void inputAddress2(String address2) {
        this.address2.sendKeys(address2);
    }

    public void inputCity(String city) {
        this.city.sendKeys(city);
    }

    public void inputState(String state) {
        this.state.sendKeys(state);
    }

    public void inputZip(String zip) {
        this.zip.sendKeys(zip);
    }

    public void inputCountry(String country) {
        this.country.sendKeys(country);
    }


    public void selectLanguage(String language) {
        Select dropdown = new Select(this.language);
        dropdown.selectByVisibleText(language);
    }


    public void selectCategory(String category) {
        Select dropdown = new Select(this.category);
        dropdown.selectByVisibleText(category);
    }

    public void clickOnCheckMyList() {
        this.checkMyList.click();
    }

    public void clickOnCheckMyBanner() {
        this.checkMyBanner.click();
    }

    public void saveAccountInformation() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true)", this.saveAccountInformation);
        this.saveAccountInformation.click();
    }

    public void clickOnSignOut() {
        this.signOut.click();


    }

    public void unsuccesfullRegistration() {
        this.unsuccesfullRegistration = unsuccesfullRegistration;
    }

    public String getUnsuccesfullRegistrationText() {
        return unsuccesfullRegistration.getText();
    }
}
