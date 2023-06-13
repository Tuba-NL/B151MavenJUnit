package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Nt_Alert extends TestBase {


    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Alert Uzerindeki Yazi : "+getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);

        //Ve alert'ü kapatalım
        alertAccept();//-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        bekle(2);
        //On button click, confirm box will appear karşsindaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptal'e basalım
        alertDismiss();

        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

    @Test
    public void Test03() {

        driver.get("https://demoqa.com/alerts");
        bekle(2);
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Erol");
        bekle(2);
        alertAccept();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Tuba"));

    }
}