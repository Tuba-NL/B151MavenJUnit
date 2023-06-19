package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_File_Upload extends TestBase {

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void Test01() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));

       // "C:\Users\gebruiker\Desktop\deneme.txt"
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\deneme.txt";

        String dosyayolu = farkliKisim + ortakKisim;

        dosyaSec.sendKeys(dosyayolu);
        bekle(2);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        bekle(2);

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement upLoadYazi = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(upLoadYazi.isDisplayed());
    }
}
