package TJunit_Ejercicios.restaurant.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import TJunit_Ejercicios.restaurant.Class.Usuario;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestUsuario extends Testing{

    public static List<Usuario> ejemplos = new ArrayList<>();
    public static Usuario usuarioTest;

    @BeforeClass
    public static void cargarEjemplos() {
        Usuario u1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario u2 = new Usuario("Barney Gomez", 0, 0, "el14gomezspringfield.com");
        Usuario u3 = new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario u4 = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
        ejemplos.add(u1);
        ejemplos.add(u2);
        ejemplos.add(u3);
        ejemplos.add(u4);
    }

    /*
    * Ejercicio 1 - b
    *  No se puede crear un usuario con un correo electrónico inválido (contiene @)
    */

    @Test
    @DisplayName("Verificar que crecion de Usuario Con@")
    public void testCrearUsuario(){
        usuarioTest = ejemplos.get(obtenerNumeroRandom(ejemplos.size()-1));
        String correo = usuarioTest.getEmail();
        Assert.assertTrue( "Error: Su correo no contiene @ --> : " + correo + " ." ,correo.contains("@"));

        // Informar que la prueba ha pasado correctamente
        System.out.println("\nLa prueba del Correo del Usuario pasó correctamente. El Correo del mismo contiene @ --> Email:  " + usuarioTest.getEmail() + ".");

    }

    /*
    * Ejercicio 2 - b
    * Implementar los ítems (b) y ( e) utilizando test dinámicos.
    */

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromEmailsOfUsers(){
        List<Usuario> testList = new ArrayList<>();
        Usuario u1 = new Usuario("Felipe Rivarola", 0,3000,"felirivarola14@gmail.com");
        Usuario u3 = new Usuario("Josefina Guerras", 0,3000,"joguerras22@gmail.com");
        Usuario u2 = new Usuario("Josefina Guerras", 0,3000,"joguerras22@gmail.com");
        Usuario u4 = new Usuario("Carlos Montenegro", 0, 3000, "carlos.montenegrogmail.com");
        Usuario u5 = new Usuario("Laura Fernandez", 0, 3000, "laura.fernandez@gmail.com");
        Usuario u6 = new Usuario("Luis Ramirez", 0, 3000, "luis.ramirez@gmail.com");
        Usuario u7 = new Usuario("María Rodriguez", 0, 3000, "maria.rodriguezgmail.com");
        Usuario u8 = new Usuario("Javier Soto", 0, 3000, "javier.soto@gmail.com");

        testList.addAll(List.of(u1,u2,u3,u4,u5,u6,u7,u8));
        return testList.stream().map(usuario  -> DynamicTest.dynamicTest("Testing: " + usuario , () ->{
            usuarioTest = usuario;
            String correo = usuarioTest.getEmail();
            Assert.assertTrue( "Error: Su correo no contiene @ --> : " + correo + " ." ,correo.contains("@"));

            System.out.println("\nLa prueba del Correo del Usuario pasó correctamente. El Correo del mismo contiene @ --> Email:  " + usuarioTest.getEmail() + ".");
        }));
    }

}
