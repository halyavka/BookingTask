package utils;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.Inbox;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAPI {

    private static final Long TIMEOUT_MILLIS = 30000L;
    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MailAPI.class);
    private static ApiClient mailslurpClient;
    private static Inbox inbox;

    static  {
        mailslurpClient = Configuration.getDefaultApiClient();
        mailslurpClient.setApiKey(Config.MAIL_API_KEY);
        mailslurpClient.setConnectTimeout(TIMEOUT_MILLIS.intValue());
    }

    public static String createTestEmail() throws ApiException {
        log.info("Create new email account...");
        InboxControllerApi inboxControllerApi = new InboxControllerApi(mailslurpClient);
        inbox = inboxControllerApi.createInbox(null, null,null, null,null,null,null, null);
        Assert.assertNotNull(inbox.getId(), "Email account was not created!");
        Assert.assertTrue(inbox.getEmailAddress().contains("@mailslurp.com"), "Email account was not created!");
        log.info("Created: " + inbox.getEmailAddress());
        return inbox.getEmailAddress();
    }

    public static String getConfirmationLink() throws ApiException {
        log.info("Find confirmation email");
        WaitForControllerApi waitForControllerApi = new WaitForControllerApi(mailslurpClient);
        Email email = waitForControllerApi.waitForLatestEmail(inbox.getId(), TIMEOUT_MILLIS, true);
        Assert.assertEquals(email.getSubject(), "One more click to confirm your account");
        Pattern p = Pattern.compile("href=\"(.*)\"\\s?style");
        Matcher matcher = p.matcher(email.getBody());
        Assert.assertTrue(matcher.find());
        return matcher.group(1);
    }

}
