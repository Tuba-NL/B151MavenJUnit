package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_NT_TimeOutException extends TestBase {


    @Test
    public void Test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

          /*

          org.openqa.selenium.TimeoutException: normalde helloWorldText webelemnti 5-6 saniye civarinda
          etkilesime girerken biz max. bekleme suresini 2 saniye verdigimiz icin bu hatayi aldik. Dolayisiyla
          bu exception'i handle edebilmek icin dogru sureyi ve dogru methodu kullanmamiz gerekir.
         */


        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }



    @Test
    public void Test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlisLocate")));

        /*
        Yukardaki örnekte max. süreyi doğru vermemize rağmen yanlis locate aldığımız için yine
        org.openqa.selenium.TimeoutException hatası alırız. Dolayısıyla bu exception'ı handle edebilmek için
        locate'i doğru almalıyız
         */
    }

    @Test
    public void Test03() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan butona tiklayalim
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));
             /*
        org.openqa.selenium.TimeoutException:
         */


        //checkBox'in secili oldugunu dogrulayalim(checkBox`i locate etmeliyiz.)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());
    }
}
