package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {

    @Test
    public void Test01() {

    //google anasayfasina goidelim
        driver.get("https://www.google.com");

    //shift tusuna basili olarak selenium yazdirialim ve shift tusunu serbest birakarak java yazdiralim
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();//-->cerezi kapattim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//-->Arama Kutusunda shift tusuna bastik.
                sendKeys("selenium").//-->selenium metnini shift tusuna basili kaldigi icin buyuk yazdi.
                keyUp(Keys.SHIFT).//-->shift tusunu serbest biraktik.
                sendKeys("-java",Keys.ENTER).//--> shift`i serbest biraktigimiz icin bu kismi kucuk yazdi.
                perform();


    }

    @Test
    public void Test02() {


        //google anasayfasina goidelim
        driver.get("https://www.google.com");

        //shift tusuna basili olarak selenium yazdirialim ve shift tusunu serbest birakarak java yazdiralim
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();//-->cerezi kapattim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        //Action class'i mouse ile isimiz oldugunda kullaniriz.
        // Klavye ile islem yapacagimizda action'dan obje olusturmaya gerek yok direk Keys.SHIFT kullanabiliriz

        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java");
       // aramaKutusu.submit();
       // aramaKutusu.sendKeys(Keys.RETURN);
          aramaKutusu.sendKeys(Keys.ENTER);
          /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void Test03() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();//-->cerezi kapattim

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium");
        aramaKutusu.submit();

        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
/*
        StaleElementReferenceException daha once locate'ini aldigimiz weblementin locate'i sayfa
        yenilendigi icin degismis ve onceden aldigimiz locate ile isleme devam edince bu exeption'i aldik.
      */


        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->Sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");
        bekle(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);

    }
}
