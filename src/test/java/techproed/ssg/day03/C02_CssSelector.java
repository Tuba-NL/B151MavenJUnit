package techproed.ssg.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_CssSelector extends TestBase {

    @Test
    public void cssSelectorTesti() {

        driver.get("https://theautomationzone.blogspot.com/2020/07/css-selector-practice.html");

        System.out.println(driver.findElement(By.cssSelector("#id1")).getText());
        System.out.println(driver.findElement(By.cssSelector(".class1")).getText());
        System.out.println(driver.findElement(By.cssSelector("[name=name1]")).getText());
        System.out.println(driver.findElement(By.cssSelector("[name=a][id=a]")).getText());
    }
}