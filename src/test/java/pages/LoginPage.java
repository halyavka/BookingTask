package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;
import utils.Driver;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By passwordField = By.id("password");

    public void open() {
        driver.get(Config.URL + "/sign-in");
    }

    public void typeEmailAndPasswordAndClickSignIn(String email, String password) {
        driver.findElement(usernameField).sendKeys(email);
        driver.findElement(singInButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.WAIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(singInButton).click();
        //Driver.sleep(3); // unknown behaviour
        //driver.findElement(singInButton).click();
    }

}
