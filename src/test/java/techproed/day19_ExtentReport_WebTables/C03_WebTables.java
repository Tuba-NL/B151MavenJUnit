package techproed.day19_ExtentReport_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    /*
WEBTABLE;
    <table> tagı ile başlar
        <thead> başlıklar için bu tag ile devam eder
        <tr> basliklarin satiri
            <th> table head
                <td> başlıktaki veriler
            <tbody> başlıklar altındaki verileri temsil eder
                    <tr> table row(satır)
                        <td> table data (tablodaki veri)

 */


    @Test
    public void Test01() {

        extentReport("Chrome","WebTable");
        extentTest = extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println("table1.getText() = " + table1.getText());
        extentTest.info("Table1 yazdirildi.");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*****************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. Satır verileri yazdirildi.");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                            //last()--istenilene gore son satir ya da sutun bilgilerini verir.
        System.out.println("1.Tablo Son Satir Bilgileri = " + sonSatir.getText());
        extentTest.info("Son satir verileri yazdirildi");
        System.out.println("******************************************");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("Besinci Sutun Basligi = " + besinciBaslik.getText());
        List<WebElement> veriler = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        veriler.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sütun verileri yazdirildi");
        /*
        for (WebElement w: veriler){
            System.out.println(w.getText());
        }
        */

        //    Task 5: 3. satirdaki 1. ve 2. sutun bilgilerini yazdiriniz
        System.out.println("*****************************************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
            ucuncuSatirr.forEach(t-> System.out.print(t.getText()+"\t"));
            extentTest.info(" 3. satirdaki 1. ve 2. sutun bilgileri yazdirildi.");


        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        System.out.println();
        System.out.println("******************************************************");
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        printData(2,3); //fbach@yahoo.com
        extentTest.info("2. satir 3. sutun bilgileri yazdirildi.");


        //3. satir 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        printData(3,2); //Jason
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3.satir 2. sutun bilgisi Jack degil, Jason oldugu goruldu.");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satirSutun.getText();
    }
        //ÖDEV
        //C03_WebTables class'ı için aldığımız rapora gidelim
        //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
        //Başlığın Extent Report olduğunu test edelim
        //Rapor temasını dark yapalım
        //Dashboard bölümüne gidip tabloyu yazdırınız
        //Tester'ın "isminiz" olduğunu doğrulayalım
        //Sayfayı kapatalım


}

