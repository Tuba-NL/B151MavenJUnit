package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim.
        driver.get("https://jqueryui.com/droppable/");

        //(Drag me to my target) webelementini Drop here webelementinin uzerine birakalim.
        /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

          /*
     Eger bir hareketli webelementi tutup baska bir webelementin uzerine birakmak istersek
     suruklemek istedigimiz webelementi locate'ini alip uzerine birakacagimiz webelementin locate'ini de alarak
     dragAndDrop(source(kaynak),target(hedef)) methodu ile islemi gerceklestirebiliriz
         */
    }

    @Test
    public void Test02() {
        //https://jqueryui.com/droppable/ adresine gidelim.
        driver.get("https://jqueryui.com/droppable/");

        //(Drag me to my target) webelementini Drop here webelementinin uzerine birakalim.
        /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basili tuttuk.
                moveToElement(drop).//-->Bu method ile basili tuttugumuz we`ti diger we`tin uzerine goturduk.
                release().//-->Bu method ile basili tuttugumuz we`i serbest biraktik.
                perform();//-->islemi sonlandirdik.
    }

    @Test
    public void Test03() {

        //https://jqueryui.com/droppable/ adresine gidelim.
        driver.get("https://jqueryui.com/droppable/");

        //(Drag me to my target) webelementini Drop here webelementinin uzerine birakalim.
        /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(150,28).//-->Belirtmis oldugumuz koordinatlara we`i tasir.
                release().perform();

    }
}