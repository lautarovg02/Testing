package TJunit_Ejercicios.restaurant.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import TJunit_Ejercicios.restaurant.Class.Ingrediente;
import TJunit_Ejercicios.restaurant.Class.ItemReceta;
import TJunit_Ejercicios.restaurant.Class.Receta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestReceta {

    public static Receta p;
    public static List<Receta> recetas = new ArrayList<>();

    @BeforeClass
    public static void cargarEjemplos(){
        //Ingredientes
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000,450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000,300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000,400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000,2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100,800);

        //Item Receta
        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);

        //Recetas
        Receta tortilla = new Receta("Tortilla", 15,200);
        tortilla.addIngrediente(ir4);
        tortilla.addIngrediente(ir5);


        Receta hamburguesa = new Receta("hamburguesa grande", 5,3000);
        hamburguesa.addIngrediente(ir2);
        hamburguesa.addIngrediente(ir1);
        hamburguesa.addIngrediente(ir3);
        hamburguesa.addIngrediente(ir6);

        Receta papasFritas = new Receta("papas fritas", 7,300);
        papasFritas.addIngrediente(ir5);
        papasFritas.addIngrediente(ir3);

        Receta pastafrola = new Receta("Pastafrola", 130, 1500);
        recetas.add(tortilla);
        recetas.add(pastafrola);
        recetas.add(papasFritas);
        recetas.add(hamburguesa);
    }

    @Test
    @DisplayName("Verificar que una Receta tenga al menos un Ingrediente")
    public void testIngredientesParaRecetas(){
        Receta receta = recetas.get(obtenerNumeroRandom(recetas.size()-1));
        System.out.println(receta);
        Assert.assertFalse( "Error: No puede crear una reseta sin ingredientes" ,receta.getIngredientes().isEmpty());
    }


    public int obtenerNumeroRandom(int max){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(max) + 1;
        return numeroAleatorio;
    }

}
