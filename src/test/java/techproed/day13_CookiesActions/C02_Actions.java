package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {

    //https://the-internet.herokuapp.com/context_menu sitesine gidin
    //Kutuya sag tıklayın
    //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
    //Tamam diyerek alert'i kapatın

    @Test
    public void Test01() {
    //https://the-internet.herokuapp.com/context_menu sitesine gidin
    driver.get("https://the-internet.herokuapp.com/context_menu");

    //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        //Sag klik yapabilmek icin oncelikle Actions class`indan bir obje olusturmaliyiz.
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).//sag klik yapma methodu kullandik, arguman olarak WebElementin locate`ini yazdik.
           perform();//actions objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz

    //Alert'te cikan yazinin"You selected a context menu" oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //TestBase deki getTextAlert() methodu kullandık --> driver.switchTo().alert().getText();
        bekle(2);

        //Tamam diyerek alert’i kapatın
        acceptAlert();//-->TestBase deki methodu kullandık --> driver.switchTo().alert().accept()
    }
}


