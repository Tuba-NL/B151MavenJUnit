package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class C02_ExcelWrite  {

    @Test
    public void excelWriteTest1() throws IOException {

        //Bir "Nufus" sutunu olusturun
        //Baskent nufuslarini excel dosyasina yaziniz.
        // (D.C: 1100, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //capital dosyasini bizim sistemimize getirdik.

        Workbook workbook = WorkbookFactory.create(fis);
        //dosyayi workbook`a atadik.

         /*
        -->Bir hucreye veri ekleyebilmek icin belirtmis oldugumuz satirdan sonra hangi
         hucreye(cell) ekleme yapacaksak createCell(cell numarasi) methodu ile cell icine eklenecek
        veri icin setCellValue() methodu kullanarak istedigimiz veriyi ekleyebiliriz.

         */

        workbook.getSheet("sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");//tirnak kullanmadan da yazilabilir.
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1300");


        //Excel'de bir hucre olusturmak icin "createCell()" methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin "setCellValue()" methodu kullanilir.

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //Datalari bizim class'imizdan Capitals dosyasina gonderecegiz,
        // bunun icin "FileOutputStream" objesi olusturmamiz gerekir

        workbook.write(fos);
        //workbook`daki datalari fos`a yazdik.

             /*
    Excel'e veri ekleme işleminden sonra FileOutputStream ile eklediğimiz verileri workbook objesi ile
    write() methodu kullanarak kaydederiz.
    Bu şekilde excel'e veriler kaydedilmiş olur. Sonra yapacağımız farklı işlemlerde hata almamamız için
    fos(FileOutStream).close() ve workbook.close() methodlarıyla yaptığımız işlemleri kaydedip sonlandırmış oluruz.
     */
        /*
        fis ile verileri ekledikten sonra fos ile dosyaya kaydederiz
         */

    }
}
