package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileMenuButton = By.id("profile-menu-trigger--title");
    private By emailConfirmedTitle = By.cssSelector("div.access-panel p.nw-step-description");

    public void profileMenuButtonIsDisplayed() {
        Assert.assertTrue(driver.findElement(profileMenuButton).isDisplayed());
    }

    public void emailConfirmedDisplayed(String msg) {
        Assert.assertEquals(driver.findElement(emailConfirmedTitle).getText(), msg);
    }

}
