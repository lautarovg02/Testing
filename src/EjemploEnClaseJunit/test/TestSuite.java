package EjemploEnClaseJunit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

/*
 *Clases que van a ser testeadas por completo
*/
@Suite.SuiteClasses({
        DePrecedencia.class,
        PersonaTest.class,

})

public class TestSuite {
//CLASE VACIA
}