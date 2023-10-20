package restaurant.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restaurant.Class.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestIngrediente {

    /*
    * Ejercicio 1. Implemente un generador de Ingredientes con 10 items.
    */
    @DataProvider
    public Object[][] GeneradorDeIngredientesCon10Items(){
        System.out.println("Generando casos");
        return new Object[][]{
                {new Ingrediente("huevo", "unidades", 10, 350)},
                {new Ingrediente("harina", "gramos", 10, 450)},
                {new Ingrediente("Pan", "gramos", 10, 450)},
                {new Ingrediente("Papa", "gramos", 10, 300)},
                {new Ingrediente("Sal", "gramos", 10, 400)},
                {new Ingrediente("Carne picada", "grAmos", 10, 2200)},
                {new Ingrediente("Pan de Hamburguesa", "unidades", 10, 800)},
                {new Ingrediente("Cebolla", "gramos", 10, 200)},
                {new Ingrediente("Ajo", "gramos", 10, 150)},
                {new Ingrediente("Tomate", "gramos", 10, 300)}

        };
    }

    public static Ingrediente obtenerIngredienteRandom(){
        List<Ingrediente> ingredientes = new ArrayList<>();
        // * INGREDIENTES
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000, 450);
        Ingrediente pan = new Ingrediente("Pan", "gramos", 0, 450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000, 300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000, 400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000, 2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100, 800);
        Ingrediente cebolla = new Ingrediente("Cebolla", "gramos", 500, 200);
        Ingrediente ajo = new Ingrediente("Ajo", "gramos", 100, 150);
        Ingrediente tomate = new Ingrediente("Tomate", "gramos", 300, 300);
        Ingrediente queso = new Ingrediente("Queso", "gramos", 800, 500);
        Ingrediente aceiteOliva = new Ingrediente("Aceite de Oliva", "mililitros", 500, 700);

        ingredientes.addAll(List.of(aceiteOliva,queso,tomate,ajo,huevo,harina,cebolla,pan,sal,papa,carnePicada,panHamburguesa));
        Random random = new Random();
        return ingredientes.get(random.nextInt(ingredientes.size()-1));
    }

    @Test(invocationCount = 4)
    public void testNombreDeIngredienteMenorA10Caracteres(){
        Ingrediente ingrediente = obtenerIngredienteRandom();
        String nombre = ingrediente.getNombre();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ingrediente a testear: " + nombre + "\n");
        Assert.assertTrue(nombre.length() <= 10,"Error: El nombre de este ingrediente es mayor a 9 --> " + nombre + "\n");
        System.out.println("La prueba a pasado con exito, el nombre de su ingrediente es menor a 10" + "\n");

    }

    @Test(dataProvider = "GeneradorDeIngredientesCon10Items")
    public void testGeneradorDeIngredientes(Ingrediente i){
        System.out.println(i);
        Assert.assertNotEquals("Error: este objeto es nulo" , i, null);
    }
}
