//package EjemploEnClase.test;
//
//import EjemploEnClase.Persona;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.util.Map;
//
//public class PadronTest {
//    static tudai.tdv.java.Padron padron = new tudai.tdv.java.Padron();
//
//    public PadronTest() {
//    }
//
//    public static void main(String[] args) throws Exception {
//        cargarPadronEjemplo();
//
//    }
//
//    @BeforeClass
//    public static void cargarPadronEjemplo() throws Exception {
//
//
//        Persona p1 = new Persona("Juan", "26.150.235", "1979-01-01", 42, true);
//        Persona p2 = new Persona("Pedro", "27.280.234", "1980-02-01", 41, true);
//        Persona p3 = new Persona("Maria", "28.184.259", "1981-03-01", 47, true);
//        Persona p4 = new Persona("Cecilia", "32.234.528", "1983-04-01", 38, true);
//        Persona p5 = new Persona("Carlos", "33.124.235", "1985-04-01", 36, true);
//        Persona p6 = new Persona("Jose", "35.345.534", "1987-04-01", 34, true);
//
//        padron.AddVotante(p1);
//        padron.AddVotante(p2);
//        padron.AddVotante(p3);
//        padron.AddVotante(p4);
////        padron.AddVotante(p5);
////        padron.AddVotante(p6);
////
//        System.out.println(padron.getPartipantes().get(p6.getDNI()));
//    }
//
//    // EJERCICIO 1 -A
//    @Test
//    @DisplayName("Intenta agregar una persona que existe")
//    public void testAgregarVotanteA(Persona p){
//        int cantVotantesAntes = padron.getPartipantes().size();
//        Assert.assertNull(padron.getPartipantes().get(p.getDNI()));
//    }
//
//
//
//    @Test
//    @DisplayName("Intenta votar una persona que no existe")
//    public void testExpectedPersonaNoEncontradaException() {
//        Assertions.assertThrows(tudai.tdv.java.PersonaNoEncontradaException.class ,()->{
//            //Persona que no existe en en el padron
//            Persona p = new Persona("Mickey","2.234.528","1983-04-01",38,true);
//            //Persona que existe en en el padron
//            //Persona p = new Persona("Juan", "26.150.235", "1979-01-01", 42, true);
//            padron.setVoto(p.getDNI());
//        });
//    }
//
//    @Test
//    public void testAgregarVotante() {
//        int cantVotantesAntes = padron.getPartipantes().size();
//        padron.AddVotante(new Persona("Fermin", "45.321.456", "2002-10-10", 22, true));
//        int cantVotantesDespues = padron.getPartipantes().size();
//        Assert.assertEquals(cantVotantesAntes + 1, cantVotantesDespues);
//    }
//
//    // Verificando que es el mismo objeto
//    @Test
//    public void testAgregaVotanteExacto() {
//        Persona p = new Persona("Fermin", "45.321.456", "2002-10-10", 22, true);
//
//        padron.AddVotante(p);
//        Persona pGuardada = padron.getPersona("45.321.456");
//        Assert.assertSame("No se recibio la misma persona que se esperaba", p, pGuardada);
//    }
//}