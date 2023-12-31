package TJunit_Ejercicios.restaurant.Test;

import TJunit_Ejercicios.restaurant.Class.*;
import TJunit_Ejercicios.restaurant.Exceptions.SinSaldoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestPedido extends Testing {

    public static List<Pedido> pedidos = new ArrayList<>();
    public static Pedido pedido;


    @BeforeClass
    public static void cargarEjemplos() {

        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000, 450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000, 300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000, 400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000, 2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100, 800);
        Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
        Producto agua = new ProductoBasico("Agua", 10, 22);


        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);


        Receta tortilla = new Receta("Tortilla", 15, 200);
        tortilla.addIngrediente(ir4);
        tortilla.addIngrediente(ir5);


        Receta hamburguesa = new Receta("hamburguesa grande", 5, 3000);
        hamburguesa.addIngrediente(ir2);
        hamburguesa.addIngrediente(ir1);
        hamburguesa.addIngrediente(ir3);
        hamburguesa.addIngrediente(ir6);

        Receta papasFritas = new Receta("papas fritas", 7, 300);
        papasFritas.addIngrediente(ir5);
        papasFritas.addIngrediente(ir3);

        Usuario u1 = new Usuario("Homero Simpson", 0, 1350, "homerojsimpson@springfield.com");
        Usuario u2 = new Usuario("Barney Gomez", 0, 220, "el14gomez@springfield.com");
        Usuario u3 = new Usuario("Edna Krabappel", 1, 3450, "ednak@springfield.com");
        Usuario u4 = new Usuario("Homero", 0, 30, "homerojsimpson@springfield.com");

        Producto p1 = new ProductoBasico("Lata Coca Cola", 10, 20);
        Producto p2 = new ProductoBasico("Lata Sprite", 10, 22);
        Producto p3 = new ProductoElaborado("Retorti", 120);
        ((ProductoElaborado) p3).setReceta(tortilla);
        Producto p4 = new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado) p4).setReceta(hamburguesa);
        Producto p5 = new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado) p3).setReceta(papasFritas);


        // Generando Pedidos
        Pedido p = new Pedido();
        p.setUsuario(u1);
        p.agregarItem(new ItemPedido(1, p1));
        p.agregarItem(new ItemPedido(1, p3));

        Pedido pedido2 = new Pedido();
        pedido2.setUsuario(u2);
        pedido2.agregarItem(new ItemPedido(3, p1));
        pedido2.agregarItem(new ItemPedido(1, p3));

        Pedido pedido3 = new Pedido();
        pedido3.setUsuario(u3);
        pedido3.agregarItem(new ItemPedido(1, p1));
        pedido3.agregarItem(new ItemPedido(2, p3));

        pedidos.add(p);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

    }

    /*
     * Ejercicio 1 - d
     * Un pedido reduce en saldo de un usuario
     */
    @Test
    @DisplayName("Verificar que se le descuente el monto del pedido al Usuario")
    public void testDescontarPedidoAUsuario() throws SinSaldoException {
        Pedido pedido = pedidos.get(obtenerNumeroRandom(pedidos.size() - 1));
        float saldoUsuario = pedido.getUsuario().getSaldo();
        float costoDelPedido = pedido.getTotalPedido();
        pedido.solicitarPedido();
        float saldoFinal = pedido.getUsuario().getSaldo();
        System.out.println("costoDelPedido " + costoDelPedido);
        System.out.println("saldoUsuario " + saldoUsuario);
        System.out.println("saldoFinal " + saldoFinal);

        Assert.assertEquals("Error: Nose desconto el saldo del pedido. Saldo Antes del pedido:  " + saldoUsuario  + ", Saldo luego del pedido: "+ saldoFinal + ". ", saldoFinal, (saldoUsuario - costoDelPedido), 0.0);

        // Informar que la prueba ha pasado correctamente
        System.out.println("\nLa prueba de ganancia del Pedido pasó correctamente, el monto del pedido se desconto con exito al saldo del Usuario: ");
        System.out.println("Costo del Pedido --> : " + costoDelPedido);
        System.out.println("Saldo del Usuario antes del descuento del monto --> : " + saldoUsuario);
        System.out.println("Saldo del Usuario luedo del descuento del monto --> : " + saldoFinal);

    }

}
