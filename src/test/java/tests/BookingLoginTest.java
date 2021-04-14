package tests;

import com.mailslurp.clients.ApiException;
import org.testng.annotations.Test;
import utils.MailAPI;

public class BookingLoginTest extends BaseTest {


    @Test
    public void SignUpAndCheckEmail() throws ApiException {
        String email = MailAPI.createTestEmail();
        String password = "testPass14042021";
        registerPage.open();
        registerPage.typeEmailAndPassword(email, password);
        registerPage.clickSubmitButton();
        homePage.profileMenuButtonIsDisplayed();

        String confirmationLink = MailAPI.getConfirmationLink();
        driver.get(confirmationLink);
        homePage.emailConfirmedDisplayed("Thanks for confirming your email address.");

        loginPage.open();
        loginPage.typeEmailAndPasswordAndClickSignIn(email, password);
        homePage.profileMenuButtonIsDisplayed();

        mySettingsPage.open();
        mySettingsPage.isEmailCorrect(email);
    }



}
