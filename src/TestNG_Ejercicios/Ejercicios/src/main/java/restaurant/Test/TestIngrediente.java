package restaurant.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restaurant.Class.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestIngrediente {
    static List<Ingrediente> ingredientes = new ArrayList<>();

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

    @BeforeClass
    public static void crearIngredientes(){
        // * INGREDIENTES
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 30, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10, 450);
        Ingrediente pan = new Ingrediente("Pan", "gramos", 10, 450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 30, 300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 15, 400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 23, 2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 10, 800);
        Ingrediente cebolla = new Ingrediente("Cebolla", "gramos", 32, 200);
        Ingrediente ajo = new Ingrediente("Ajo", "gramos", 20, 150);
        Ingrediente tomate = new Ingrediente("Tomate", "gramos", 12, 300);
        Ingrediente queso = new Ingrediente("Queso", "gramos", 20, 500);
        Ingrediente aceiteOliva = new Ingrediente("Aceite de Oliva", "mililitros", 500, 700);

        ingredientes.addAll(List.of(aceiteOliva,queso,tomate,ajo,huevo,harina,cebolla,pan,sal,papa,carnePicada,panHamburguesa));
    }

    public static Ingrediente obtenerIngredienteRandom(){
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
    @Test(invocationCount = 10)
    public void testDescontarIngredientesCuandoLaCantDisponibleEsCero() throws TestNG_Ejercicios.Ejercicios.src.main.java.restaurant.Exceptions.ExceptionCantidadDeIngredientenNoDisponible {
        Ingrediente ingrediente = obtenerIngredienteRandom();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ingrediente a testear: " + ingrediente.getNombre() + "-- Cantidad de Stock disponible : " + ingrediente.getStock() +"\n");
        ingrediente.consumirStock(10);
        int cantLuegoDeDescontar = ingrediente.getStock();
        Assert.assertTrue(cantLuegoDeDescontar >= 0);
        System.out.println("La prueba a pasado con exito, la cantidad de ingredientes que necesitaba estaba disponible " + "\n");
        System.out.println("Cantidad de Stock disponible luego del test : " + ingrediente.getStock());
    }

    @Test(dataProvider = "GeneradorDeIngredientesCon10Items")
    public void testGeneradorDeIngredientes(Ingrediente i){
        System.out.println(i);
        Assert.assertNotEquals("Error: este objeto es nulo" , i, null);
    }


}
