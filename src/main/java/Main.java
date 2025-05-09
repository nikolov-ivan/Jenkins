import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        try {
            // Създаване на желания Chrome капацитет
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platform", "LINUX");
            capabilities.setCapability("version", "latest");

            // URL на Hub-а
            URL gridUrl = new URL("http://localhost:4444/wd/hub");

            // Създаване на WebDriver с отдалечено свързване към Hub-а
            WebDriver driver = new RemoteWebDriver(gridUrl, capabilities);

            // Примерен тест
            driver.get("http://www.google.com");
            System.out.println("Page Title is: " + driver.getTitle());

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
