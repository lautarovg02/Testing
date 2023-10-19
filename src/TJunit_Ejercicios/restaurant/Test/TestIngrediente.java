package TJunit_Ejercicios.restaurant.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class TestIngrediente extends Testing {
    static TJunit_Ejercicios.restaurant.Class.Ingrediente ingrediente;

    @BeforeClass
    public static void cargarEjemplos() {
        // * USUARIOS
        TJunit_Ejercicios.restaurant.Class.Usuario u1 = new TJunit_Ejercicios.restaurant.Class.Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        TJunit_Ejercicios.restaurant.Class.Usuario u2 = new TJunit_Ejercicios.restaurant.Class.Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        TJunit_Ejercicios.restaurant.Class.Usuario u3 = new TJunit_Ejercicios.restaurant.Class.Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        TJunit_Ejercicios.restaurant.Class.Usuario u4 = new TJunit_Ejercicios.restaurant.Class.Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

        // * INGREDIENTES
        TJunit_Ejercicios.restaurant.Class.Ingrediente huevo = new TJunit_Ejercicios.restaurant.Class.Ingrediente("huevo", "unidades", 240, 350);
        TJunit_Ejercicios.restaurant.Class.Ingrediente harina = new TJunit_Ejercicios.restaurant.Class.Ingrediente("harina", "gramos", 10000, 450);
        TJunit_Ejercicios.restaurant.Class.Ingrediente pan = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Pan", "gramos", 0, 450);
        TJunit_Ejercicios.restaurant.Class.Ingrediente papa = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Papa", "gramos", 20000, 300);
        TJunit_Ejercicios.restaurant.Class.Ingrediente sal = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Sal", "gramos", 1000, 400);
        TJunit_Ejercicios.restaurant.Class.Ingrediente carnePicada = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Carne picada", "grmos", 10000, 2200);
        TJunit_Ejercicios.restaurant.Class.Ingrediente panHamburguesa = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Pan de Hamburguesa", "unidades", 100, 800);
        TJunit_Ejercicios.restaurant.Class.Ingrediente cebolla = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Cebolla", "gramos", 500, 200);
        TJunit_Ejercicios.restaurant.Class.Ingrediente ajo = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Ajo", "gramos", 100, 150);
        TJunit_Ejercicios.restaurant.Class.Ingrediente tomate = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Tomate", "gramos", 300, 300);
        TJunit_Ejercicios.restaurant.Class.Ingrediente queso = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Queso", "gramos", 800, 500);
        TJunit_Ejercicios.restaurant.Class.Ingrediente aceiteOliva = new TJunit_Ejercicios.restaurant.Class.Ingrediente("Aceite de Oliva", "mililitros", 500, 700);

        //* AGREGANDO CONSUMIBLES(INGREDIENTES) A LA ALMACEN
        TJunit_Ejercicios.restaurant.Class.Almacen.Stock.addAll(List.of(huevo,harina,sal,papa,carnePicada,panHamburguesa));
        TJunit_Ejercicios.restaurant.Class.Almacen.Stock.addAll(List.of(cebolla, ajo, tomate, queso, aceiteOliva));
        System.out.println("Ingredientes de la Almacen -->: " + TJunit_Ejercicios.restaurant.Class.Almacen.Stock);
    }

    @Test
    @DisplayName("Verificar que cuando se reponga Stock este Aumente")
    public  void testVerificarElAumentoDeStock(){
        ingrediente = (TJunit_Ejercicios.restaurant.Class.Ingrediente) TJunit_Ejercicios.restaurant.Class.Almacen.Stock.get(TJunit_Ejercicios.restaurant.Class.Almacen.Stock.size()-1);
        System.out.println("Ingrediente a testear --> : " + ingrediente.getNombre());
        int stock = ingrediente.getStock();
        ingrediente.reponerStock(4);
        int stockLuegoDeAgregar = ingrediente.getStock();
        Assert.assertNotEquals("Error: El stock no se incrementa luego de hacer la reposicion -->: Stock Antes de Reponer: " + stock +  ", Stock luego de Reponer: " + stockLuegoDeAgregar, stockLuegoDeAgregar, stock);
        System.out.println("\nLa prueba de Aumento del Stock pasó correctamente, el monto del pedido se desconto con exito al saldo del Usuario:  -->: Stock Antes de Reponer: " + stock + ", Stock luego de Reponer: " + stockLuegoDeAgregar);
    }

}
