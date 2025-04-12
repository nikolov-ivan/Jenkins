import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class FirstTest {
    @Test
    public void test() {
        try {
            // Създаване на желания Chrome капацитет
            ChromeOptions chromeOptions = new ChromeOptions();

// Showing a test name instead of the session id in the Grid UI

// Other type of metadata can be seen in the Grid UI by clicking on the
// session info or via GraphQL
            chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
            WebDriver driver = new RemoteWebDriver(new URL("http://gridUrl:4444"), chromeOptions);
            driver.get("http://www.google.com");
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
//    public void test2() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//
//        driver.quit();
//    }
}
