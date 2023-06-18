package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {

    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
    //Acilan sayfanin Title in "Your Account" icerdigini dogrula

    @Test
    public void Test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountListWe = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListWe).perform();
        //moveToElement() methodu ile mouse`u istedigimizi webElementin uzerine goturebiliriz.
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
