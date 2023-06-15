package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;


public class C02_Alert extends TestBase {





    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.

    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert()  {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    Bir metod olusturun: acceptAlert
        //    1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

      bekle(2);


        //    uyarıdaki OK butonuna tıklayın
        driver.switchTo(). // Gecmek,Degistirmek
                alert().   // Alert'e gecis yaptı
                accept();  // cıkan uyarıda OK yada TAMAM butonuna basar


      bekle(2);


        //    ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult, actuelResult);


    }


    @Test
    public void dismissAlert()  {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        //   Bir metod olusturun: dismissAlert
        //    2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
      bekle(2);


        //    uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
      bekle(2);


        //    ve result mesajının "successfuly" icermedigini test edin.
        String actuelResult = driver.findElement(By.xpath("//*[@id= 'result']")).getText();
        String expectedResult = "successfuly";
        Assert.assertFalse(actuelResult.contains(expectedResult));


    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
       bekle(2);


        //  Bir metod olusturun: sendKeysAlert
        //  3. butona tıklayın,
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
       bekle(2);

        //  uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());
        //getText() uyaridaki mesaji bize String olarak getirir.

        //uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Tuba");
      bekle(2);

        //OK butonuna tıklayın
        driver.switchTo().alert().accept();
       bekle(2);

        //ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actuelResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actuelResult.contains("Tuba"));



    }
}