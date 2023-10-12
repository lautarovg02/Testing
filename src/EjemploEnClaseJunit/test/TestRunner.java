package EjemploEnClaseJunit.test;

import org.junit.runner.JUnitCore;


public class TestRunner {

    public static void main(String args[]) {
        System.out.println("Test runner -> comienzo del Runner");
        JUnitCore.runClasses(EjemploEnClaseJunit.test.TestSuite.class);
        System.out.println("Test runner -> Fin del Runner");
    }



}