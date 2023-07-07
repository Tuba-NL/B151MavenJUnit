package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

    //  https://techproeducation.com sayfasına gidin
    // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Sayfayi en üste scroll et (sayfayı kaydır)
    // Sayfayı en alta scroll et (sayfayı kaydır)

    JavascriptExecutor js;

    @Test
    public void jsExecuterScrollTest() {
        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam
        bekle(2);

        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

        // js =(JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        jsScrollWE(weOffer);
        bekle(2);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));

        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        jsScrollWE(enrollFree);
        bekle(2);


        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
      //  scroll(whyUs);
        bekle(3);

        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        jsScrollWE(enrollFree);
        bekle(3);

        // Sayfayi en üste scroll et (sayfayı kaydır)
      //  js = (JavascriptExecutor) driver;
      //  js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        scrollHome();
        bekle(3);

        // Sayfayı en alta scroll et (sayfayı kaydır)

        //  js = (JavascriptExecutor) driver;
        //  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        scrollEnd();
    }
}
