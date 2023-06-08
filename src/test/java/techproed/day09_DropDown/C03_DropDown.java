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

public class C03_DropDown {


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
    public void test01() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement ddmProgram = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select = new Select(ddmProgram);
        select.selectByVisibleText("Java");


        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement sonSecilenOption = select.getFirstSelectedOption();
        String sonSecilenOptionStr = sonSecilenOption.getText();
        Assert.assertEquals("Java",sonSecilenOptionStr);
        Thread.sleep(2000);


        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

        List<WebElement> tumOpsiyonlar = select.getOptions();

        for (WebElement w:tumOpsiyonlar) {
            System.out.println(w.getText());
        }
        //Lambda ile cozum:
       // tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("******************************************");

        // Sayfadaki tum Dropdown'lardaki tum optionları konsolda yazdırınız
        List<WebElement> tumDropDownTumOpsiyonlar = driver.findElements(By.tagName("option"));

       // tumDropDownTumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

        for (WebElement each :tumDropDownTumOpsiyonlar) {
            System.out.println(each.getText());

        }

    }
}
