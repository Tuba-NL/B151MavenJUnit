package techproed.day21_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_NT_JSExecutor_Click extends TestBase {

    /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz.
    <script> tagi ile olusturdugumuz webelementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void Test01() {
        //Amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        bekle(2);

        //Sell linkinin resmini alalim.
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Basligin sell icerdigini test edelim.
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim.
        tumSayfaResmi();


    }

    @Test
    public void Test02() {
        //Amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        bekle(2);

        //Sell linkinin resmini alalim.
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tiklayiniz.
       sellLinki.click();
       /*
       JS executor ile Webelementin onunde uyari cikmasina ragmen Webelemente click yapti cunku
       kodlara direkt ulasiyor.
       Normal kullandigimiz click methodu burda onunde farkli bir element olduğu için
       ElementClickInterceptedException:hatası verdi.
       Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
        */

        //Basligin sell icerdigini test edelim.
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim.
        tumSayfaResmi();

    }

    @Test
    public void Test03() {
        //Amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        bekle(2);

        //Sell linkinin resmini alalim.

       // driver.findElement(By.xpath("(//*[@class='a-button-text'])[1]")).click();//-->uyari kapatildi
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz.
        click(sellLinki);

        //Basligin sell icerdigini test edelim.
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim.
        tumSayfaResmi();

    }
}
