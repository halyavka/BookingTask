package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.LoginPage;
import pages.MySettingsPage;
import pages.RegisterPage;
import utils.Config;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import static org.testng.Assert.assertNotNull;

public class BaseTest {

    protected WebDriver driver;

    protected HomePage homePage;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected MySettingsPage mySettingsPage;

    @BeforeSuite
    public void initSuite() {
        assertNotNull(Config.MAIL_API_KEY);
    }

    @BeforeClass
    public void initDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(URI.create(Config.SELENOID_REMOTE_URL).toURL(), Driver.getChromeCapabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.WAIT_TIMEOUT));
        initPages();
    }

    private void initPages() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        mySettingsPage = new MySettingsPage(driver);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}
