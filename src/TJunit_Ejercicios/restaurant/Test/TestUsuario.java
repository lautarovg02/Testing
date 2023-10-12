package TJunit_Ejercicios.restaurant.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import TJunit_Ejercicios.restaurant.Class.Usuario;

import java.util.ArrayList;
import java.util.List;

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

}
