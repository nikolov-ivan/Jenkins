import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATest {
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/");

            // Изчакваме Elements секцията и кликваме
            WebElement elementsCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']")));
            elementsCard.click();

            // Изчакваме Text Box секцията и кликваме
            WebElement textBoxMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Text Box']")));
            textBoxMenu.click();

            // Попълваме формата
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("John Doe");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("john.doe@example.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))).sendKeys("123 Main Street");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress"))).sendKeys("456 Another Street");

            driver.findElement(By.id("submit")).click();

            // Връщаме се назад
            driver.navigate().back();

            // Отиваме на Buttons секцията
            WebElement buttonsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Buttons']")));
            buttonsMenu.click();

            // Double Click
            WebElement doubleClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
            actions.doubleClick(doubleClickBtn).perform();

            // Right Click
            WebElement rightClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
            actions.contextClick(rightClickBtn).perform();

            // Връщаме се назад
            driver.navigate().back();

            // Отиваме на Check Box секцията
            WebElement checkBoxMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check Box']")));
            checkBoxMenu.click();

            // Expand all
            WebElement expandAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Expand all']")));
            expandAllBtn.click();

            // Избираме чекбокс
            WebElement notesCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='rct-title' and text()='Notes']")));
            notesCheckBox.click();

            // Допълнително изчакване за естествено поведение
            Thread.sleep(15000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
