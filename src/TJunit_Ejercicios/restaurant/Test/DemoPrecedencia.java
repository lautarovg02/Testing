package EjemploEnClaseJunit.test;


import org.junit.*;

import static org.junit.Assert.fail;

public class DemoPrecedencia {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("DemoPrecedencia -> BeforeClass ");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("DemoPrecedencia -> AfterClass ");
    }


    @Before
    public void setUp() throws Exception {
        System.out.println("DemoPrecedencia -> Before");

    }
    /**
     * Metodo tearDown para instancias de test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("DemoPrecedencia -> After");
    }

    @Test
    public void testFuncion1() {
        System.out.println("DemoPrecedencia -> testFuncion1");
//        Assert.assertTrue(2 + 2 == 5);
        Assert.assertEquals(2 + 2, 4);
    }

    @Test
    public void testFuncion2() {
        System.out.println("DemoPrecedencia -> TestFuncion2");
    }
    @Test
    public void testFuncion3() {
        System.out.println("DemoPrecedencia -> TestFuncion3");
    }

}
