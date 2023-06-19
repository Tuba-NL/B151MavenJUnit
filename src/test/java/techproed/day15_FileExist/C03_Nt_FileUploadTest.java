package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_Nt_FileUploadTest extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //"File Uploaded!" textinin goruntulendigini test edelim.

    @Test
    public void Test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

             /*
    Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception aliyorsak
    direk upload istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz.

     Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa o webelemente
         sendKeys() methodu ile dosya gonderemeyebilirsiniz. Boyle bir durumla karsilasirsaniz
         Robot class' indan obje ile methodlar kullanarak bunu asabilirsiniz
 */

        String dosyaYolu = "C:\\Users\\gebruiker\\Desktop\\text.txt";
        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
        //dosyaSec.click();-->click yapmadi hata aldik

         //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

         //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

         //"File Uploaded!" textinin goruntulendigini test edelim.
      Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
