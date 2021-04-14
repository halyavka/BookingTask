package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Config;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By confirmPassField = By.id("confirmed_password");
    private By newPasswordField = By.id("new_password");
    private By signUpButton = By.cssSelector("form.nw-register button.bui-button");

    public void open() {
        driver.get(Config.URL + "/register");
    }

    public void typeEmailAndPassword(String email, String password) {
        driver.findElement(usernameField).sendKeys(email);
        driver.findElement(singInButton).click();
        driver.findElement(newPasswordField).sendKeys(password);
        driver.findElement(confirmPassField).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(signUpButton).click();
    }

}
