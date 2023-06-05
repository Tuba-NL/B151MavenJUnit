package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {

    /*
    Notasyonlara sahip methodlar olusturabilmek icin mouse+sag tik +generate(kisayol alt + insert) yaparak
    after methodu icin teardown'u seceriz.
    before methodu icin setup'i seceriz.
    test methodu icin de test'i seceriz
     Junit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
     Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir
    */


    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodu oncesi bir kez calisir");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodu sonrasi bir kez calisir");

    }

    @Test
    public void test01() {
        System.out.println("Ilk test");

    }


    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }

    @Test
    public void test03() {
        System.out.println("Ucuncu test");
    }


}
