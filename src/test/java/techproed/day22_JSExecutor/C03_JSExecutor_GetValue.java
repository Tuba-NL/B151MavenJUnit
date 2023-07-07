package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_GetValue extends TestBase {


    @Test
    public void jsGetTest() {

        //  https://www.carettahotel.com/ sayfasına gidiniz
        driver.get("https://www.carettahotel.com/");

        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        // Check-In Date kismini JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");//ID ILE LOCATE ALDIK


        /*

         CSS SELECTOR KULLANARAK`DA LOCATE ALINABILIR
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        */

        /*
        Eger bir web sayfasinda webelementler olustulurken JS kullanilmissa , normal olarak locate almakta zorlanabiliriz.
        Bu gibi durumlarda JSExecutor kullanarak webelementi locate edebiliriz.

        EGER HTML KODLARINDA SCRIPT ATTRIBUTU VARSA O HTML KODLAR JS ILE YAZILMISTIR. BU DURUMDA
        JSEXECUTER ILE ISLEM YAPMALYIZ
         */

        // Check-In Date kısmına 5/25/2023 tarihini yazınız
        date.clear();
        date.sendKeys("5/25/2023");

        // Check-In Date kisminin degerini yazdirin.
        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println("valueAttribute = " + valueAttribute);
    }
}
