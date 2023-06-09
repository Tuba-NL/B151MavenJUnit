package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    @Test
    public void Test01() {
        /*
    FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
    max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
 */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).//-->FluentWait max. bekleme suresini belirtir.
                pollingEvery(Duration.ofMillis(200)).//-->200 milisaniye araliklarla webelementin etkilesime girdigini kontrol et
                withMessage("Webelementi kontrol et");//-->Hata alma durumunda konsolda bu mesaji verir-->Zorunlu degil
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));


        Assert.assertEquals("Hello World!", helloWorldText.getText());
    }

    @Test
    public void Test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOf(helloWorldText));

        Assert.assertEquals("Hello World!", helloWorldText.getText());

    }

    @Test
    public void Test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        Assert.assertEquals("Hello World!", helloWorldText.getText());

    }

    @Test
    public void Test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        visibleFluentWait(helloWorldText,20,100);

        Assert.assertEquals("Hello World!", helloWorldText.getText());
    }
}
