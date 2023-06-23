package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_NT_NullPointerException  {



        /*
    NULL_POINTER_EXCEPTION
      Obje yada değişken oluşturup bunlara atama yapmadığımız zaman direk oluşturmuş olduğumuz
   obje yada değişkeni kullanmak istersek nullPointerException hatasi alırız.
     */


    WebDriver driver;
    Faker faker;
    Actions actions;
    int sayi;
    String name;

    @Test
    public void Test01() {
         /*
         driver = new ChromeDriver(); normalde bu atamayi yapmamiz gerekir. Bu atamayi yapmadigimiz taktirde ya da
        unuttugumuz zaman NullPointerException hatasi aliriz
         */

        driver.get("https://amazon.com");

    }

    @Test
    public void Test02() {
        //faker = new Faker();
        System.out.println(faker.name().fullName());//-->java.lang.NullPointerException
    }

    @Test
    public void Test03() {
        // actions = new Actions(driver);
        actions.doubleClick().perform();//-->java.lang.NullPointerException
    }
}
