package techproed.day16_SeleniumWait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {

    @Test
    public void Test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());

        //Cikan Alert`u kapatalim.
        acceptAlert();

    }
}
