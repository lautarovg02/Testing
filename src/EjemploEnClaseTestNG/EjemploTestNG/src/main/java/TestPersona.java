package EjemploEnClaseTestNG.EjemploTestNG.src.main.java;

import EjemploEnClaseJunit.Persona;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestPersona {
    @DataProvider
    public Object[][] GeneradorPersona() {
        System.out.println("Genero casos");
        return new Object[][]{
                {new Persona("Juan", "26.150.235", "1979-01-01", 44, true)},
                {new Persona("Pedro", "27.280.234", "1980-02-01", 43, true)},
                {new Persona("Maria", "28.184.259", "1981-03-01", 47, true)},
                {new Persona("Cecilia", "32.234.528", "1983-04-01", 40, true)},
                {new Persona("Carlos", "33.124.235", "1985-04-01", 36, true)},
                {new Persona("Jose", "35.345.534", "1987-04-01", 34, true)}
        };
    }

    @Test(dataProvider = "GeneradorPersona", invocationCount = 2)
    public void testEdadBienCalculada(Persona p) {
        int edadReportada = p.getEdad();
        int edadReal = getEdad(p.getFechaNacimiento());
        Assert.assertEquals(edadReal, edadReportada);
    }


    /*****+ TEST con parametros: En test Persona agregamos ****/
    @Test
    @Parameters({"nombre","dni","fnac"})
    public void testConParametros(@Optional("Pepe") String nombre , @Optional("20.345.678") String dni, @Optional("2001-2-3")String fNac)
    {
        Persona p = new Persona(nombre, dni, fNac, 0, false);
        System.out.println(p);
    }
    @Test (expectedExceptions = {EdadNopermitidaException.class})
    public void testNoPermitirEdadesNegativas() throws EdadNopermitidaException {
        Persona p= new Persona("Anibal","26.150.235","1979-01-01",44,true);
//Fuerzo a una edad negativa
        p.setEdad(-1);
    }


    public int getEdad(String fechaNacimiento) {
        try {
            // Crea un objeto SimpleDateFormat para parsear la fecha de nacimiento.
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Parsea la fecha de nacimiento.
            Date fechaNac = sdf.parse(fechaNacimiento);

            // Obtiene la fecha actual.
            Date fechaActual = new Date();

            // Crea un objeto Calendar para calcular la diferencia entre las fechas.
            Calendar calNac = Calendar.getInstance();
            Calendar calActual = Calendar.getInstance();
            calNac.setTime(fechaNac);
            calActual.setTime(fechaActual);

            // Calcula la diferencia de años.
            int edad = calActual.get(Calendar.YEAR) - calNac.get(Calendar.YEAR);

            // Verifica si el cumpleaños ya pasó este año.
            if (calNac.get(Calendar.MONTH) > calActual.get(Calendar.MONTH) ||
                    (calNac.get(Calendar.MONTH) == calActual.get(Calendar.MONTH) &&
                            calNac.get(Calendar.DAY_OF_MONTH) > calActual.get(Calendar.DAY_OF_MONTH))) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Manejo de errores
        }
    }
}



