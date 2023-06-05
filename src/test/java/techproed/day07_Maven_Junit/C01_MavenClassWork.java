package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        // Login alanina  "username" yazdirin
         WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
         login.sendKeys("username");

        // Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();

        // Online Banking bölümüne tıklayın
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("100");

        // Date kismina "2020-09-10" yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
       // driver.findElement(By.cssSelector("input[id='pay_saved_payees']")).click();-->css ile locate aldim

        // "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement mesaj = driver.findElement(By.xpath("//span[.='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // Sayfayi kapatın
        driver.close();




    }
}
