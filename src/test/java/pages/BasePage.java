package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    protected By usernameField = By.id("username");
    protected By singInButton = By.cssSelector("form.nw-signin button.bui-button");


}
