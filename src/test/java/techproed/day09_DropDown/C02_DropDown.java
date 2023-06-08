package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

    /*
    -getFirstSelectedOption() ==> Dropdown`daki en son sectigimiz option`u bize dondurur.

    -getOptions() ==> Dropdown`daki tum optionlari bize dondurur.
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
         driver.close();

    }

    @Test
    public void test01() {

        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement ddmSelectaState = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(ddmSelectaState);
        select.selectByValue("AZ");
        //select.selectByVisibleText("Arizona");


        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement sonSecilenOption = select.getFirstSelectedOption();
        String sonSecilenOptionStr = sonSecilenOption.getText();
        Assert.assertEquals("Arizona", sonSecilenOptionStr);

        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız

        //1-)Foreach ile cozumu:
        List<WebElement> tumOptionlar = select.getOptions();
        for (WebElement each : tumOptionlar) {
            System.out.println(each.getText());
        }
        //2-)Lambda ile cozumu:
        //tumOptionlar.stream().forEach(t-> System.out.println(t.getText()));

          /*
         //3-)Tum opsiyonlarin locateni alarak cozumu:
        List<WebElement> tumOpsiyonlar = driver.findElements(By.xpath("//select[@id='state']//option"));
         tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

         */
    }
}
