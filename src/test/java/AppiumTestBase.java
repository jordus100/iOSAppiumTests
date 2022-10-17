import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.net.URL;

class AppiumTestBase {

    private final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    protected AppiumDriver driver;
    URL remoteUrl;

    @BeforeTest
    @Parameters({"deviceUID", "systemPort"})
    public void setUp(String deviceUDID, String systemPort) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:automationName", "Safari");
        desiredCapabilities.setCapability("safari:deviceUDID", deviceUDID);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 60);
        desiredCapabilities.setCapability("systemPort", systemPort);
        desiredCapabilities.setCapability("adbExecTimeout", 60000);
        try {
            remoteUrl = new URL(APPIUM_SERVER_URL);
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
        driver = new SafariDriver(remoteUrl, desiredCapabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 50);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
