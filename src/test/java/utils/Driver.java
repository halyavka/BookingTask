package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    public static DesiredCapabilities getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("enableVNC", true);
        capability.setCapability("enableVideo", false);
        options.addArguments("ignore-certificate-errors");
        options.addArguments("ignore-urlfetcher-cert-requests");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        return capability;
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
