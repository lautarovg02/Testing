package TJunit_Ejercicios.restaurant.Test;

import TJunit_Ejercicios.restaurant.Class.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class TestIngrediente extends Testing{
    static Ingrediente ingrediente;

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
        System.out.println("Ingredientes de la Almacen -->: " + Almacen.Stock);
    }

    @Test
    @DisplayName("Verificar que cuando se reponga Stock este Aumente")
    public  void testVerificarElAumentoDeStock(){
        ingrediente = (Ingrediente) Almacen.Stock.get(Almacen.Stock.size()-1);
        System.out.println("Ingrediente a testear --> : " + ingrediente.getNombre());
        int stock = ingrediente.getStock();
        ingrediente.reponerStock(4);
        int stockLuegoDeAgregar = ingrediente.getStock();
        Assert.assertNotEquals("Error: El stock no se incrementa luego de hacer la reposicion -->: Stock Antes de Reponer: " + stock +  ", Stock luego de Reponer: " + stockLuegoDeAgregar, stockLuegoDeAgregar, stock);
        System.out.println("\nLa prueba de Aumento del Stock pasó correctamente, el monto del pedido se desconto con exito al saldo del Usuario:  -->: Stock Antes de Reponer: " + stock + ", Stock luego de Reponer: " + stockLuegoDeAgregar);
    }

}
