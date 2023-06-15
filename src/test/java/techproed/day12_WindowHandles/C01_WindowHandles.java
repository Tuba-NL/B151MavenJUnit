package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {


    //  https://the-internet.herokuapp.com/windows adresine gidin.
    //  ilk sayfasının Handle degerini alın yazdırın
    //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
    //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
    //  "Click Here" butonuna tıklayın.
    //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
    //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
    //  ikinci sayfaya tekrar geçin.
    //  ilk sayfaya tekrar dönün.


    @Test
    public void Test01() {//1. yontem Set ile;

//  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilk Sayfa Handle = " + ilkSayfaHandle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", text.getText());

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals("The Internet", ilkSayfaTitle);

//  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//*[.= 'Click Here']"));
        clickHere.click();//--> yeni bir sekme acildi.

      /*
    Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
    handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
    methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
    mantigiyla bir loop icinde cozebiliriz
 */
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println("windowHandleSet = " + windowHandleSet); //Tum sekmelerin sirasiyla handle degerlerini verir.


        String ikincisayfaHandle = "";

        for (String each : windowHandleSet) {

            if (!each.equals(ilkSayfaHandle)) {
                //window handle setinden gelen her bir eleman ilkSayfaHandle a esit degilse ,

                ikincisayfaHandle = each;//o zaman ikinci Sayfa Handle a esittir
            }
        }
        System.out.println("Ikinci Sayfa Handle = " + ikincisayfaHandle);
        driver.switchTo().window(ikincisayfaHandle);


//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window", ikinciSayfaTitle);


        bekle(2);

//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        //driver otomatik acilan 2.sekmededir. 1. sayfaya donmeliyiz
        driver.switchTo().window(ilkSayfaHandle);//1.sekmeye dondurduk

        Assert.assertEquals("The Internet", ilkSayfaTitle);

        bekle(2);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikincisayfaHandle);

        bekle(2);

//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);



    }

    @Test
    public void test02() {//2. yontem ArrayList ile;
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
         driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
        bekle(2);
    }

    @Test
    public void Test03() { //3. yontem Set ve ArrayList kullanmadan SwitchTo().Window() methodu ile;
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    /*
    Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
    methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }

    @Test
    public void Test04() {//TestBase`deki Methodlarla;
        
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
       switchToWindow(1);


        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);


        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
       switchToWindow(0);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        switchToWindow(1);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        switchToWindow(0);
        bekle(2);
    }
}




