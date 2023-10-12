package TJunit_Ejercicios.restaurant.Test;

import TJunit_Ejercicios.restaurant.Class.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class TestAlmacen extends Testing {


    static List<ProductoElaborado> elaborados = new ArrayList<>();
    static ProductoElaborado productoElaborado;
    static Receta receta;

    @BeforeClass
    public static void cargarEjemplos() {
        // * USUARIOS
        Usuario u1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario u2 = new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        Usuario u3 = new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario u4 = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

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

        //* AGREGANDO CONSUMIBLES(INGREDIENTES) A LA ALMACEN
        Almacen.Stock.addAll(List.of(huevo,harina,sal,papa,carnePicada,panHamburguesa));
        Almacen.Stock.addAll(List.of(cebolla, ajo, tomate, queso, aceiteOliva));

        // * ITEMS DE RECETA
        ItemReceta cant_Huevos_1 = new ItemReceta(huevo, 1);
        ItemReceta cant_Huevos_3 = new ItemReceta(huevo, 3);
        ItemReceta cant_CarnePicada_100 = new ItemReceta(carnePicada, 100);
        ItemReceta cant_Sal_20 = new ItemReceta(sal, 20);
        ItemReceta cant_Huevos_4 = new ItemReceta(huevo, 4);
        ItemReceta cant_Papa_3 = new ItemReceta(papa, 3);
        ItemReceta cant_PanHamburguesa_1 = new ItemReceta(panHamburguesa, 1);
        ItemReceta cant_Cebolla_1 = new ItemReceta(cebolla, 1);
        ItemReceta cant_Ajo_2 = new ItemReceta(ajo, 2);
        ItemReceta cant_Tomate_2 = new ItemReceta(tomate, 3);
        ItemReceta cant_Tomate_3 = new ItemReceta(tomate, 3);
        ItemReceta cant_Queso_200 = new ItemReceta(queso, 200);
        ItemReceta cant_AceiteOliva_50 = new ItemReceta(aceiteOliva, 50);
        ItemReceta cant_Pan_1 = new ItemReceta(pan, 1);

        // * RECETAS
        Receta receta_salsa = new Receta("Salsa de Tomate", 10, 100);
        receta_salsa.addIngrediente(cant_Tomate_3);
        receta_salsa.addIngrediente(cant_Ajo_2);
        receta_salsa.addIngrediente(cant_AceiteOliva_50);

        Receta receta_ensalada = new Receta("Ensalada", 8, 150);
        receta_ensalada.addIngrediente(cant_Tomate_3);
        receta_ensalada.addIngrediente(cant_Cebolla_1);
        receta_ensalada.addIngrediente(cant_Queso_200);
        receta_ensalada.addIngrediente(cant_AceiteOliva_50);

        Receta receta_ajoaceite = new Receta("Ajoaceite", 5, 120);
        receta_ajoaceite.addIngrediente(cant_Ajo_2);
        receta_ajoaceite.addIngrediente(cant_AceiteOliva_50);

        Receta receta_omelette = new Receta("Omelette", 12, 180);
        receta_omelette.addIngrediente(cant_Huevos_3);
        receta_omelette.addIngrediente(cant_Cebolla_1);
        receta_omelette.addIngrediente(cant_Queso_200);

        Receta receta_panConTomate = new Receta("Pan con Tomate", 5, 80);
        receta_panConTomate.addIngrediente(cant_Pan_1);
        receta_panConTomate.addIngrediente(cant_Tomate_2);
        receta_panConTomate.addIngrediente(cant_AceiteOliva_50);

        Receta receta_tortilla = new Receta("Tortilla", 15, 200);
        receta_tortilla.addIngrediente(cant_Huevos_4);
        receta_tortilla.addIngrediente(cant_Papa_3);

        Receta receta_hamburguesa = new Receta("receta_hamburguesa grande", 5, 3000);
        receta_hamburguesa.addIngrediente(cant_CarnePicada_100);
        receta_hamburguesa.addIngrediente(cant_Huevos_1);
        receta_hamburguesa.addIngrediente(cant_Sal_20);
        receta_hamburguesa.addIngrediente(cant_PanHamburguesa_1);

        Receta receta_papasFritas = new Receta("papas fritas", 7, 300);
        receta_papasFritas.addIngrediente(cant_Papa_3);
        receta_papasFritas.addIngrediente(cant_Sal_20);

        // * PRODUCTOS ELABORADOS
        Producto salsaTomate = new ProductoElaborado("Salsa de Tomate", 80);
        ((ProductoElaborado) salsaTomate).setReceta(receta_salsa);

        Producto ensalada = new ProductoElaborado("Ensalada", 100);
        ((ProductoElaborado) ensalada).setReceta(receta_ensalada);

        Producto ajoaceite = new ProductoElaborado("Ajoaceite", 70);
        ((ProductoElaborado) ajoaceite).setReceta(receta_ajoaceite);

        Producto omelette = new ProductoElaborado("Omelette", 150);
        ((ProductoElaborado) omelette).setReceta(receta_omelette);

        Producto panConTomate = new ProductoElaborado("Pan con Tomate", 60);
        ((ProductoElaborado) panConTomate).setReceta(receta_panConTomate);

        Producto tortilla = new ProductoElaborado("Tortilla", 120);
        ((ProductoElaborado) tortilla).setReceta(receta_tortilla);

        Producto hamburguesa_BIG_0 = new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado) hamburguesa_BIG_0).setReceta(receta_hamburguesa);

        Producto patatas = new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado) patatas).setReceta(receta_papasFritas);

        // * AGREGANDO PRODUCTOS ELABORADOS
        elaborados.add((ProductoElaborado) hamburguesa_BIG_0);
        elaborados.add((ProductoElaborado) tortilla);
        elaborados.add((ProductoElaborado) patatas);
        elaborados.add((ProductoElaborado) panConTomate);
        elaborados.add((ProductoElaborado) omelette);
        elaborados.add((ProductoElaborado) ajoaceite);
        elaborados.add((ProductoElaborado) ensalada);
        elaborados.add((ProductoElaborado) salsaTomate);

        System.out.println("Productos Elaborados de la Almacen ->: " + elaborados);

    }

    /*
     * Ejercicio 1 - f
     * No es posible realizar una receta si no se cuenta con todos los ingredientes
     */
    @Test
    @DisplayName("Verificar que la almacen disponga de stock para realizar la receta de un Producto Elaborado")
    public void testContarConTodosLosIngredientesParaUnaReceta(){
        productoElaborado = elaborados.get(obtenerNumeroRandom(elaborados.size()-1));
        System.out.println("Producto a testear -->: " + productoElaborado.getNombreComercial());
        receta = productoElaborado.getReceta();
        Assert.assertTrue("Error: La cantidad de ingredientes que tiene en su Stock no es suficiente para realizar la receta de " + receta.getNombreInterno()+ ". El ultimo ingrediente mostrado por pantalla en la anterior iteracion es el que no cumple", Almacen.esPosibleCocinar(receta));
        // Informar que la prueba ha pasado correctamente
        System.out.println("\nLa prueba de cumplir con los Ingredientes necesarios para la Receta de " + receta.getNombreInterno()+ " pasó correctamente.");

    }
}
