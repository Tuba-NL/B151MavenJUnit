package techproed.ssg.day04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators01 extends TestBase {

    Faker faker = new Faker();
    String password = faker.internet().password();

    @Test
    public void relativeLocatorsTesti() {

        driver.get("https://www.kitapyurdu.com/");
        driver.findElement(By.linkText("Üye Ol")).click();

        WebElement adKutusu = driver.findElement(By.id("register-name"));
        adKutusu.sendKeys(faker.name().firstName());
        bekle(3);

        WebElement soyadKutusu = driver.findElement(with(By.tagName("input")).below(adKutusu));
        soyadKutusu.sendKeys(faker.name().lastName());
        bekle(1);

        WebElement epostaKutusu = driver.findElement(with(By.tagName("input")).below(soyadKutusu));
        epostaKutusu.sendKeys(faker.internet().emailAddress());
        bekle(1);

        WebElement sifre = driver.findElement(with(By.tagName("input")).below(epostaKutusu));
        sifre.sendKeys(password);
        bekle(1);

        WebElement sifreTekrar = driver.findElement(with(By.tagName("input")).below(sifre));
        sifreTekrar.sendKeys(password);
        bekle(1);

        WebElement kabul1 = driver.findElement(with(By.tagName("div")).below(sifreTekrar));
        kabul1.click();
        bekle(1);

        WebElement kabul2 = driver.findElement(with(By.tagName("div")).below(kabul1));
        kabul2.click();
        bekle(1);

        WebElement uyeOlButonu = driver.findElement(with(By.tagName("button")).below(kabul2));
        uyeOlButonu.click();
        bekle(1);

    }


    }

