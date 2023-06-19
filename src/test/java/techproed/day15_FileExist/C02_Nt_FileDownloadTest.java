package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Nt_FileDownloadTest extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=file-
    //download adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void Test01() {
        String filePath = "C:\\Users\\gebruiker\\Downloads\\b10 all test cases, code (1).docx";

        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadi");
        }

           /*
    Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
    burda dosyayı sildik
     */

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");


        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[.='b10 all test cases, code.docx']")).click();

          /*
    İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
     */
        bekle(3);//--> indirme süresini göz önünde bulundurarak bekle koyduk

        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:\\Users\\gebruiker\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

           /*
    Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
    burda dosyayı sildik
     */

         /*

        //2.Way:
        String dosyaYolu = "C:\\Users\\gebruiker\\Downloads\\b10 all test cases, code.docx";
        File file = new File(dosyaYolu);
        Assert.assertTrue(file.exists());
        bekle(2);
        file.delete();

    */


    }
}
