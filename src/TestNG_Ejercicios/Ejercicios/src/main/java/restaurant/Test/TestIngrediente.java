package restaurant.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restaurant.Class.Ingrediente;

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

    @Test(dataProvider = "GeneradorDeIngredientesCon10Items")
    public void testGeneradorDeIngredientes(Ingrediente i){
        System.out.println(i);
        Assert.assertNotEquals("Error: este objeto es nulo" , i, null);
    }
}
