package techproed.ssg.day01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02 extends TestBase {
/*
    Test Görevi:
    https://www.kitapyurdu.com/ adresine gidiniz.
    Arama motorunda “Java” kelimesini aratınız.
    Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
    Sepetinize gidiniz.
    Eklenen iki ürünün de sepette göründüğünü doğrulayınız.
    İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
    “Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
    Ürünlere ait kontrol kutularını seçili hale getiriniz.
    Kontrol kutularının seçili olduğunu doğrulayınız.
    İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
    İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
    “Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız.

 */

    @Test
    public void Test01() {

       // https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");
        bekle(2);

       // Arama motorunda “Java” kelimesini aratınız.
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Java", Keys.ENTER);
        bekle(2);

       //Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
        driver.findElement(By.xpath("(//div[@class='cover'])[2]")).click();
        driver.findElement(By.xpath("//span[.='Sepete Ekle']")).click();
        bekle(2);
        driver.navigate().back();
        driver.findElement(By.xpath("(//div[@class='cover'])[3]")).click();
        driver.findElement(By.xpath("(//*[.='Sepete Ekle'])[1]")).click();

        bekle(2);

       //Sepetinize gidiniz.
       driver.findElement(By.xpath("(//span[@class='fl'])[1]")).click();

       // Eklenen iki ürünün de sepette göründüğünü doğrulayınız.
       // İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
       //“Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
       //Ürünlere ait kontrol kutularını seçili hale getiriniz.
       //Kontrol kutularının seçili olduğunu doğrulayınız.
       // İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        //İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
        //“Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız.

    }
}
