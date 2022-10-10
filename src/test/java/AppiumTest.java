import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class AppiumTest extends AppiumTestBase {

    @Test
    public void testWebsiteOpen() {
        driver.get("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) wdriver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .equals("complete"));
    }
}
