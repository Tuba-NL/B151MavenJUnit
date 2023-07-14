package techproed.ssg.day05;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;


public class C02_HesapMakinesiTesti extends C01_HesapMakinesi{

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass: Her class`tan once calisir.");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass: Her class`tan sonra calisir.");
    }

    @Before
    public void setUp() {
        System.out.println("Before her testen once calisir.");

    }

    @After
    public void tearDown()  {
        System.out.println("After her testen sonra calisir.");
    }

    @Test
    public void testTopla() {
        int sonuc = topla(3,5);
        Assert.assertEquals(8,sonuc);
    }

    @Test
    public void testCikar() {
        int sonuc = cikar(5,3);
        Assert.assertEquals(2,sonuc);
    }

    @Test(timeout = 10)
    public void testCarp() {
        int sonuc = carp(2,5);
        Assert.assertEquals(10,sonuc);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testbol() {
      //   bol(5,0);//ArithmeticException
       List<Integer> sayilar = new ArrayList<>();//IndexOutOfBoundsException
        sayilar.get(0);
    }

    @Ignore("Bu test atlanıyor.")
    @Test
    public void atlananTest() {

        System.out.println("Bu test atlandi");
    }
}
