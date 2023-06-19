package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Nt_FilesExists {

    @Test
    public void Test01() {
       /*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
için;
    Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
assing ederiz.
 */
    String dosyaYolu = "C:/Users/gebruiker/Desktop/TEXT.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa true yoksa false doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void Test02() {

        String dosyaYolu = "C:\\Users\\gebruiker\\Desktop\\deneme.txt";//--> "C" den once ve en sondaki cift tirnaktan once /" olmayacak

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void Test03() throws InterruptedException {
        /*
        Bir server'da farkli isletimsistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman,
        daha dinamik olmasi acisindan System.getProperty("os.name") bu sekilde isletim sistemini alir
        her isletim sisteminin kullanici yolu farkli olacagindan  System.getProperty("user.home")
        ile bilgisayarimizdaki kullanici yolunu alip bu sekilde String  bir degiskene farkli yol ismi ileSystem.getProperty("user.home")
        atayarak her seferinde farkli yollari almayla ugrasmamis oluruz. Dosya diyelimki masaustunde ve her isletim
        sisteminde bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assign ederiz.

         */
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->Isletim sisteminin adini verir.
        System.out.println("Isletim Sistemi Adi : "+ isletimSistemiAdi);
        System.out.println("Kullanici Yolu : " + System.getProperty("user.home"));//-->Bilgisayarimizdaki kullanici yolunu verir.
        if(isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali ";//-->Mac isletim sistemi yolu
        }
        String ortakYol = "/Desktop/deneme.txt";
        String dosyaYolu = farkliYol + ortakYol;

        System.out.println("Dosya Yolu : " + Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu sekilde belirtmis oldugumuz dosyayi sileriz
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildigimiz icin assertFalse kullandik.
        Thread.sleep(3000);

        //Sildigimiz dosya isminde yeni bir dosya olusturalim.
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
    Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
    yukardaki delete islemini kullanabiliriz
 */
    }

    @Test
    public void Test04() {

        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */
        String dosyaYolu = "C:/Users/gebruiker/Desktop/TEXT.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
/*
        NOT:
        Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
        yolunu almak istediğimiz dosyanun üzerine gelip shift+sayKlik tusuna basarak yol olarak kopyala
        seçeneği ile dosya yolunu kopyalayabiliriz.

 */
    }
}
