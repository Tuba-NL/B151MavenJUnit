package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_NT_GetAttribute extends TestBase {

    //  https://www.carettahotel.com/ a gidiniz
    //  Tarih kısmını JS ile locate ediniz.
    //  Yazili metinleri alıp ve yazdırınız

    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        bekle(2);

        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();


        //  Tarih kısmını JS ile locate ediniz.

        JavascriptExecutor js = (JavascriptExecutor) driver;
       // WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        /*
        Java Script kodlariyla yazilmis webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz.
        Js executor kullanarak ister html ister java script ile yazilmis olsun bir webelementin locatini js executor ile alabiliriz.
        Yukaridaki ornekte sayfadaki tarih webelemntini js executor ile locate ettik.
         */

        date.clear();
        date.sendKeys("5/25/2023");

        //  Date webelementinin Attribute degerlerini yazdiralim

        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("id Attribute Degeri = " + idAttributeDegeri);
        System.out.println("type Attribute Degeri = " + typeAttributeDegeri);
        System.out.println("name Attribute Degeri = " + nameAttributeDegeri);
        System.out.println("value Attribute Degeri = " + valueAttributeDegeri);

       /*
        Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
        yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
         */
    }

    @Test
    public void test02() {

        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com/");


        //Submit butonunun rengini Kirmizi yazınız
        WebElement button = driver.findElement(By.xpath("//div[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",button);

    }
}
