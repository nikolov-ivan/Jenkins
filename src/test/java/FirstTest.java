import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FirstTest {
    @Test
    public void test() throws IOException, InterruptedException {

        // Създаване на желания Chrome капацитет
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // За Linux системи
        options.addArguments("--window-size=1920x1080"); // За задаване на размер на прозореца

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);

        driver.get("http://www.google.com");

        Thread.sleep(5000);

        File res = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File file = new File("screenshot.png");

        FileUtils.copyFile(res, file);

        driver.quit();


    }

//    @Test
//    public void test2() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//
//        driver.quit();
//    }
}
