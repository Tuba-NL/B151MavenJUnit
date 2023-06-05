package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(1000);

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1000);

        //3.Login alanine "username" yazdirin
        WebElement username = driver.findElement(By.xpath("//*[@type='text']"));
        username.sendKeys("username");
        Thread.sleep(1000);

        //4.Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("password");
        Thread.sleep(1000);

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
    /*
        yukaridaki 3-4 ve 5. stepleri burada bir seferde yaptik.

        WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        login.sendKeys("username", Keys.TAB,"password", Keys.TAB,Keys.TAB,Keys.ENTER);
        */

        //6.Online Banking Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);

        /*
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        //-->(//*[text()=.])[11] Bu şekilde text ile aldığımız bir xpath'de text değişse
         bile biz o webelementi handle edebiliriz.
         */


        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("1000");
        Thread.sleep(1000);


        //8.tarih kismina "2020-09-10" yazdirin
        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");
        Thread.sleep(1000);


        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
        Thread.sleep(1000);
        /*
        7-8 ve 9. stepleri bu sekilde tek kodla yapabiliriz
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
         */

        //10."The payment was successfully submitted." mesajinin ciktigini control edin

        /*
                WebElement sonucYazisi = driver.findElement(By.xpath("(//span)[1]"));
        System.out.println(sonucYazisi.getText());
        if (sonucYazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Webelementin görünür olup olmadığını doğrulamak için yaptık
        if (sonucYazisi.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

         */
        WebElement mesaj = driver.findElement(By.xpath("(//*[.='The payment was successfully submitted.'])[2]"));
        if (mesaj.isDisplayed()) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //11.Sayfayi kapatin
        driver.close();

    }
}
