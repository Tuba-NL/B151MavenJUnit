package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {

     /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */

    @Test
    public void WindowHandle() {


        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowhandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);


        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().//Gecis yap
                newWindow(WindowType.WINDOW);//-->Yeni bir pencereye driver`i tasir.
               // WindowType.TAB --> Yeni bir sekme acar.
        driver.get("https://www.youtube.com");
        String youtubeWindowHanle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(3);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowhandle);
        bekle(3);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHanle);
        bekle(3);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(3);
    }
}
