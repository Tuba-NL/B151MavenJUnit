package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NT_NoSuchElementExection extends TestBase {

     /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir webelementin locate'ini yanlis aldigimizda, elementi bulamayacagi icin bu
            exception'i aliriz

         */


    @Test
    public void Test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='Ssearch']"));

         /*
        org.openqa.selenium.NoSuchElementException:
          normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
        //*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
        düzgün locate almamız gerekiyor. Webelement bir iframe içinde olabilir, bir buttona tıkladığımızda yeni bir
        pencere açılabilir yada alert çıkabilir bu gibi durumlarda da nosuchelementexception alırız
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void Test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='search']"));
             /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate'ini
        cssSelector locator ile kullanirsak bu exception'i aliriz.Dolayisiyla bunu handle etmek icin
        dogru locator'i kullanmamiz gerekir
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
