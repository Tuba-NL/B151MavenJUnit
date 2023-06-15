package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
-Authentication kimlik dogrulama yöntemidir
- söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
- Authentication üzerinde sag click yapıp locate alınamaz
- Authentication bir alert degildir
- Authentication yapabilmek icin uygulamanın kullanıcılara,
Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
- https://username:password@URL gibi

 */

    // Aşağıdaki bilgileri kullanarak authentication yapınız:

    // Url: https://the-internet.herokuapp.com/basic_auth
    // Username: admin
    // Password: admin
    //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız



    @Test
    public void basicAuthentication() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

    // Url: https://the-internet.herokuapp.com/basic_auth

    // Username: admin
    // Password: admin
       // https://username:password@URL
        //Yukarida belirtilen formata uygun kimlik dogrulamasi yapilacaktir.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//Acilan yeni pencereye gectik.

        //Basligin "Elemental Selenium" olmadigini dogrulayin
        System.out.println("Sayfa Basligi : " + driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());


        //DDM`den java secelim.
        WebElement ddm = driver.findElement(By.xpath("//select"));
        /*
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
        */
        selectVisibleText(ddm,"Java");//-->Method ile
    }
}
