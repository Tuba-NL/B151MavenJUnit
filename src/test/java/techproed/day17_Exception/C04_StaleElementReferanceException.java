package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {

    /*
    StaleElementReferanceException:
    Bir web sayfasindaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.
        Yani bir webelementi locate ettikten sonrs sayfada refresh ya da back-forward kullaniyorsak
    yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasini aliriz.

    Bunu handle edebilmek icin webelemente yeniden ayni locate`i atamaliyiz.
    (webelementin locate`ini hatirlatma gibi diyebiliriz.

    */

    @Test
    public void StaleElementReferanceExceptionTest1() {


        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfayi yenileyelim
        driver.navigate().refresh();


        //LMS LOGIN butonuna tiklayalim
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
    }


    @Test
    public void StaleElementReferanceExceptionTest2() {

        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        login.click();

       /*
       LMS LOGIN webelementini locate ettikten sonra sayfayi yeniledigimiz icin LMS LOGIN webelementi eskidi(bayatladi),
       sonrasinda bayatlayan webelement`e click yaptigimiz icin StaleElementReferanceException hatasi aldik.

       Bu exception`i handle edebilmek icin refresh yaptiktan sonra tekrar ayni locate`i webelemente atamamiz gerekiyor.
        */
    }

    @Test
    public void StaleElementReferanceExceptionTest3() {

        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();


    }
}