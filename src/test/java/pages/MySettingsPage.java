package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Config;

public class MySettingsPage extends BasePage {

    public MySettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(Config.URL + "/mysettings/personal");
    }

    private By emailAddressText = By.xpath("//*[text()='Email address']/ancestor::div[@class='my-settings-edit-row']//div[@class='my-settings-flex-grow']");

    public void isEmailCorrect(String email) {
        Assert.assertEquals(driver.findElement(emailAddressText).getText().split("\n")[0], email);
    }

}
