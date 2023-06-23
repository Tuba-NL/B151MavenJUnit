package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
    TimeOutException:
    Sayfada aradigimiz elementi wait ile belirttigimiz max sürede bulamadigi durumda
    TimeOutException hatasi aliriz
     */

    @Test
    public void TimeOutExceptionTest1() {
        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //searchBox görünür oluncaya kadar bekleyiniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLIS elementor-search-form-9f26725']")));

        //HATALI KOD

        /*
        TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlis bir
        locate aldik. Webelementi eklerken o webelementin locate ini bulamadigi icin max belittigimiz sure
        kadar ve TimeOutException hatasini verdi.



         BASKASININ NOTUUUU
         -------------------
          TimeOutException:
        Explicit wait kullanildiginda, ve element bulunamadiginda
        alinir.
        Explicit wait & yanlis locator-> timeout
        Explicit wait & doğru locator & sure yeterli degil -> timeout
        Explicit wait & dogru locator & sure yeterli & iframe var ->
        time out


            Solution:
       -Sureyi arttirmak
       -Farkli explicit kullanmak: wait visibilityOfElementLocated
        YERINE presenceOfElementLocated. Yada javascript executor
        da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
       -Locatori tekrar kontrol etmek
       -Frameworkunde hazir reusable method lar var Bu durumda
        timeoutexception aldigimda hızlıca o metotlar yardımıyla
        problemi cozebiliyoruz


         */

    }

    @Test
    public void TimeoutExceptionTest2() {


        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));

        Assert.assertTrue(helloWorldYazisi.isDisplayed());


        //HATALI KOD


        /*

        Duration.ofSeconds(1); ortalama 6 sn geciyor ancak 1 sn yazdik. Hata verecektir.

        HOCANIN NOTU
        ------------
        Gercekte Hello World! yazisi ort 6 snde gözüküyor. TimeoutException alabilmek icin
        Explicit Wait'e bekleme süresin e 1 sn verdik. Bu sebeple TimeoutException hatasi aldik
        */
    }
}