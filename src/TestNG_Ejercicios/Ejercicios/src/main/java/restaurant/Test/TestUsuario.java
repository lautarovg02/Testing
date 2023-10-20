package restaurant.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restaurant.Class.Usuario;
import restaurant.Exceptions.SinSaldoException;

import java.util.Iterator;

public class TestUsuario {

    @Test
    @DataProvider
    public Object[][] GeneradorDeUsuarios(){
        System.out.println("Generando Casos");
        return new Object[][]{
                {new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com")},
                {new Usuario("Barney Gomez", 0, 1100, "el14gomez@springfield.com")},
                {new Usuario("Edna Krabappel", 1, 1220, "ednak@springfield.com")},
                {new Usuario("Messi", 0, 2000, "homerojsimpson@springfield.com")},
        };
    }

    /*
    * 4. Pruebe si ante la insuficiencia de saldo del usuario, se dispara la excepción SinSaldoException
    */
    @Test(dataProvider = "GeneradorDeUsuarios", invocationCount = 3)
    public void testInsuficienciaDeSaldoDelUsuario(Usuario u) throws SinSaldoException {
        System.out.println("-----------------------------------------------------");
        System.out.println("Saldo Del Usuario "  + u.getNombreYApellido() +" --> : " + u.getSaldo());
        System.out.println("Que paso si le descontamos $1000....");
        System.out.println("\n");
        u.descontarSaldo(1000);


    }
}
