package pages;

import static utils.WebDriverUtils.DEFAULT_TIMEOUT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Mihail_Damasheuski on 6/23/2016.
 */
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@rel='login-popup']")
    private WebElement regBtn;

    @FindBy(xpath = "//div[@class='soc-icons']/a[@class='icon icon-vk']")
    private WebElement vcIcon;

    @FindBy(xpath = "//div[@class='soc-icons']/a[@class='icon icon-facebook']")
    private WebElement faceBookIcon;

    @FindBy(xpath = "//div[@class='soc-icons']/a[@class='icon icon-twitter']")
    private WebElement twitterIcon;

    @FindBy(xpath = "//div[@class='soc-icons']/a[@class='icon icon-bnet-icon']")
    private WebElement bNetIcon;

    @FindBy(xpath = "//form[@id='form-login']//input[@name='nickname']")
    private WebElement emailField;

    @FindBy(xpath = "//form[@id='form-login']//input[@name='password']")
    private WebElement pswdField;

    @FindBy(xpath = "//form[@id='form-login']//input[@id='login']")
    private WebElement loginBtn;

    @FindBy(xpath = ".//*[@id='top']/ul[@class='links top']/li[@class='me']/span[@class='sign']/a")
    private WebElement userBtn;

    public WebElement getUserBtn() {
        return userBtn;
    }

    public void clickRegBtn(){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(regBtn));
        regBtn.click();
    }

    public void fillForm(String login,String pswd){
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(pswdField));
        pswdField.clear();
        pswdField.sendKeys(pswd);
    }



    public void logIn(){
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }



    public WebElement getVcIcon() {
        return vcIcon;
    }

    public WebElement getFaceBookIcon() {
        return faceBookIcon;
    }

    public WebElement getTwitterIcon() {
        return twitterIcon;
    }

    public WebElement getbNetIcon() {
        return bNetIcon;
    }
}
