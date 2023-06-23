package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {

    /*
    SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */


    //Techproeducation sayfasına gidelim
    //Çıkan reklamı kapatalım
    //Ve ekran görüntüsünü alalım


    @Test
    public void Test01() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım

                 /*
        -İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
        -İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
        -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        dosya yolunu belirteceğiz
        */

        String dosyayolu = "src/test/java/techproed/TumSayfaResmi/screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyayolu));


    }

    @Test
    public void Test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("ScreenShot/screenShot.png"));
    }

    @Test
    public void Test03() throws IOException {

        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
        */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyayolu));
    }

    @Test
    public void Test04() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyayolu));
    }


}

