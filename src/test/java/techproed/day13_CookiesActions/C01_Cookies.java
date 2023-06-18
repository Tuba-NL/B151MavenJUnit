package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    //Soru:
    //1-Amazon anasayfaya gidin
    //2-tum cookie’leri listeleyin
    //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    //6-eklediginiz cookie’nin sayfaya eklendigini test edin
    //7-ismi skin olan cookie’yi silin ve silindigini test edin
    //8-tum cookie’leri silin ve silindigini test edin


    @Test
    public void Test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cookie`leri listelemek istersek
        driver.manage().getCookies() methoduyla bir Set ya da ArrayList`e atarak listeleyebiliriz.
         */
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);-->Lambda ile Cookie`leri yazdirdik.
        Set<Cookie> cookieSet = driver.manage().getCookies();

        int sayac = 1;
        for (Cookie w : cookieSet) {
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". cookieName : " + w.getName());//Sadece Cookie`lerin isimlerini aliriz.
            System.out.println(sayac + ". cookieValue : " + w.getValue());//Sadece Cookie`lerin value`larini aliriz.
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookielerin Sayisi : " + cookieSet.size());
        Assert.assertTrue(cookieSet.size() > 5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue, actualCookieValue);
        //NOT: getCookieNamed() methodu ile bize verilen cookie isminin getValue()
        // methoduyla gercek degerini actualCookieValue degiskenine assign ettik

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cookielerin Sayisi : " + cookieSet.size());
       // System.out.println("Cookielerin Sayisi : " + Arrays.stream(driver.manage().getCookies().toArray()).count());


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("S.O. Cookie Sayisi : " + silinmedenOnce);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie`yi sildik.
        bekle(2);

        //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }
        int silindiktenSonra = cookieSet.size();
        System.out.println("S.S. Cookie Sayisi : " + silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//-->Tum cookie`leri sildik
        cookieSet = driver.manage().getCookies();//-->Tekrar cookieSet`i guncelledik.
        Assert.assertTrue(cookieSet.isEmpty());//-->Ve cookieSet`in icinin bos oldugunu isEmpty() methoduyla test ettik.
    }

}