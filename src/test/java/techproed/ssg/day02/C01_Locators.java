package techproed.ssg.day02;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_Locators extends TestBase {

  /*
    Test Görevi:
        https://www.kitapyurdu.com/ adresine gidiniz.
        “En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        “Devamını Oku…” butonuna basınız.
        Ürünü sepete ekleyiniz.
        Sepete gidiniz.
        Ürüne ait kontrol kutusunu işaretleyiniz.
        Ürün miktarını değiştiriniz.
     */

    @Test
    public void locatorsTesti(){
        // Web sitesine gidilir.
        driver.get("https://www.kitapyurdu.com/");

        // “En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        List<WebElement> encokSatilanlarList = driver.findElements(By.className("bestseller-item"));
        // System.out.println(encokSatilanlarList.get(0).getText());//ilk kitap bilgileri gelir
        String ilkKitap = encokSatilanlarList.get(0).getText().split("\n")[0];
        System.out.println(ilkKitap);
        encokSatilanlarList.get(0).click();// ilkurune tiklar , sistem de urun degisse bile bu sekilde bize hep ilkini verir
        bekle(1);

        // Seçilen ürüne ait sayfanın açıldığını doğrulayınız
        WebElement kitapAdi = driver.findElement(By.xpath("//h1"));
        System.out.println(ilkKitap);
        System.out.println(kitapAdi.getText());
        Assert.assertEquals(ilkKitap,kitapAdi.getText());// kod burada hata veriyor


        // “Devamını Oku…” butonuna basınız.
        WebElement devaminiOku = driver.findElement(By.partialLinkText("Devamı"));
        devaminiOku.click();

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkle = driver.findElement(By.linkText("Sepete Ekle"));
        sepeteEkle.click();

        // Sepete gidiniz.
        WebElement sepeteGit = driver.findElement(By.linkText("sepetinize"));
        sepeteGit.click();

        // Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement urunKontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(urunKontrolKutusu.isSelected());

        if (!urunKontrolKutusu.isSelected()){
            urunKontrolKutusu.click();
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        Assert.assertEquals("1", urunMiktari.getAttribute("value"));
        urunMiktari.clear();
        urunMiktari.sendKeys("3");
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));


    }

}



