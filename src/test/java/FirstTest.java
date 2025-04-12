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
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu"); // За Linux системи
            options.addArguments("--window-size=1920x1080"); // За задаване на размер на прозореца

            WebDriver driver = new RemoteWebDriver(new URL("http://gridUrl:4444"), options);
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
