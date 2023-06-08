package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static techproed.day08_BeforeClassAfterClass_Assertion.C03_BeforeClassAfterClass.driver;

public class C05_RadioButtonClassWork {


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void radioButton() throws InterruptedException {
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        driver.findElement(By.xpath("//*[@title='Tüm çerezlere izin ver']")).click();

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
/*
        //“radio buttons” elementlerini locate edin
        WebElement bayan = driver.findElement(By.xpath("(//*[@type=\"radio\"])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@type=\"radio\"])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@type=\"radio\"])[3]"));
        Thread.sleep(2000);

        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!bayan.isSelected()){
            Thread.sleep(2000);
            bayan.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

 */
    }
}
