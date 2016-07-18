package cucumberSteps;

import static org.hamcrest.Matchers.equalTo;
import static utils.WebDriverUtils.DEFAULT_TIMEOUT;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.lift.Matchers;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.WebDriverUtils;


/**
 * Created by Mihail_Damasheuski on 6/23/2016.
 */

public class StepsDefinition {

    private final static ErrorCollector collector = new ErrorCollector();
    private final static String me = "XaycuTo";

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue() {
            long threadId = Thread.currentThread().getId();
            System.out.println(String.format(">>> Current thread: %s <<<",threadId));
            WebDriver wd = new FirefoxDriver();
            wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            wd.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            wd.manage().window().maximize();
            return wd;
        }
    };

    @Given("^manage driver$")
    public void driverStep(){
        System.out.println("driver managed");
    }

    @When("^go to \"(.+)\" website$")
    public void goToWebSite(String URL){
        driver.get().get(URL);
        HomePage homePage = PageFactory.initElements(driver.get(), HomePage.class);
        collector.checkThat("check VK icon",homePage.getVcIcon(), Matchers.displayed());
        collector.checkThat("check FaceBook icon",homePage.getFaceBookIcon(), Matchers.displayed());
        collector.checkThat("check Twitter icon",homePage.getTwitterIcon(), Matchers.displayed());
        collector.checkThat("check Bnet icon",homePage.getbNetIcon(), Matchers.displayed());
        System.out.println("visit website");
    }

    @When("^click register button$")
    public void clickRegisterBtn(){
        HomePage homePage = PageFactory.initElements(driver.get(), HomePage.class);
        homePage.clickRegBtn();
        System.out.println("click register btn");

    }

    @When("^fill in register form fields with creds: \"(.+)\", \"(.+)\"$")
    public void fillForm(String login, String pswd){
        HomePage homePage = PageFactory.initElements(driver.get(), HomePage.class);
        homePage.fillForm(login,pswd);

        System.out.println("filling form");
    }

    @When("^submit form$")
    public void clickDoneBtn(){
        HomePage homePage = PageFactory.initElements(driver.get(), HomePage.class);
        homePage.logIn();
        System.out.println("clicking Login btn");
    }

    @Then("^confirm registration$")
    public boolean isLogined(){
        HomePage homePage = PageFactory.initElements(driver.get(), HomePage.class);
        new WebDriverWait(driver.get(),DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(homePage.getUserBtn()));
        collector.checkThat(WebDriverUtils.getText(homePage.getUserBtn()),equalTo(me));
        System.out.println("confirmation step");
        return true;

    }

    @Then("^kill driver$")
    public void closeDriver(){

        driver.get().close();
        driver.remove();
    }
}
