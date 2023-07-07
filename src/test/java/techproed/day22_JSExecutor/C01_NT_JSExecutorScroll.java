package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NT_JSExecutorScroll extends TestBase {

    //Techpro education ana sayfasına git
    //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    //Sayfayı en alta scroll yapalım
    //Sayfayi en üste scroll yapalım


    @Test
    public void Test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam
        bekle(2);


        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOfferWE = driver.findElement(By.xpath("//span[.='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOfferWE);
        bekle(2);
        tumSayfaResmi();



        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyUsWE);
        bekle(2);
        tumSayfaResmi();


        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al

        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);


        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        bekle(2);
    }

    @Test
    public void Test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam
        bekle(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");//-->x=0, y=2000 pixel bir noktaya scroll yapar


    }
    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[.='we offer']"));
        jsScrollWE(weofferWE);
        bekle(2);
        tumSayfaResmi();//-->TestBase deki ScreenShot methodu

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUsWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(2);
        //Sayfayi en üste scroll yapalım
        scrollHome();
    }
}
