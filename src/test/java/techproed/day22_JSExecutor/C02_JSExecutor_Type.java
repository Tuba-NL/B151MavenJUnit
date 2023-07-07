package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_JSExecutor_Type extends TestBase {

    // https://techproeducation.com sayfasına gidin
    // Arama kutusuna "QA" yazıp aratın


    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin

        driver.get("https://techproeducation.com");
        bekle(2);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam
        bekle(2);


        // Arama kutusuna "QA" yazıp aratın

        //1.Yol
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        //aramaKutusu.sendKeys("QA" + Keys.ENTER);
        //normal kodumuz bu

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'", aramaKutusu);

        jsSendKeys( "QA",aramaKutusu);




      /*
        2.Yol
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);

        sendAttributeJS(aramaKutusu,"QA");
        */

    }
}
