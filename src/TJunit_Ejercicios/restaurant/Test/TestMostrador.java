package TJunit_Ejercicios.restaurant.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import TJunit_Ejercicios.restaurant.Class.*;
import TJunit_Ejercicios.restaurant.Exceptions.ExceptionUsuario;

import java.util.ArrayList;
import java.util.List;

public class TestMostrador extends Testing {

    public static Mostrador m1 = new Mostrador();
    public static List<ItemPedido> itemPedidos = new ArrayList<>();
    public static List<Usuario> usuarios = new ArrayList<>();
    public static Pedido pedido;

    @BeforeClass
    public void cargarEjemplos() {
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000, 450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000, 300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000, 400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000, 2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100, 800);
        Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
        Producto agua = new ProductoBasico("Agua", 10, 22);

        //Agregando los ingredientes a las recetas
        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);


        //Agregando Recetas
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

        //Agregando usuarios para el pedido
        Usuario u1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario u2 = new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        Usuario u3 = new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario u4 = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);

        ////Agregando productos para el pedido
        Producto p1 = new ProductoBasico("Lata Coca Cola", 10, 20);
        Producto p2 = new ProductoBasico("Lata Sprite", 10, 22);
        Producto p3 = new ProductoElaborado("Retorti", 120);

        //agregando
        ((ProductoElaborado) p3).setReceta(tortilla);
        Producto p4 = new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado) p4).setReceta(hamburguesa);
        Producto p5 = new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado) p3).setReceta(papasFritas);

        itemPedidos.add(new ItemPedido(1, p5));
        itemPedidos.add(new ItemPedido(2, p3));
        itemPedidos.add(new ItemPedido(1, p4));
        itemPedidos.add(new ItemPedido(4, p5));
        itemPedidos.add(new ItemPedido(3, p2));

        //agregando un mostrador
        m1.setNombreOperador("Jose");

        //agregando un pedido a nombre de homero
        Pedido p = new Pedido();
        p.setUsuario(u1);
        p.agregarItem(new ItemPedido(1, p1));
        p.agregarItem(new ItemPedido(1, p3));

        m1.agregarPedido(p);

        Pedido pedido2 = new Pedido();
        p.setUsuario(u3);
        p.agregarItem(new ItemPedido(1, p1));
        p.agregarItem(new ItemPedido(1, p3));

        m1.agregarPedido(pedido2);
    }

    /*
     * Ejercicio 1 - a
     *  No se pueden agregar usuarios repetidos
     */
    @Test
    @DisplayName("Verificar que no haya dos pedidos que tengan el mismo usuario")
    public void testAgregarUsuarioApedido() {
        List<ItemPedido> itemPedidosRandoms = new ArrayList<>();
        itemPedidosRandoms.add(itemPedidos.get(obtenerNumeroRandom(itemPedidos.size() - 1)));
        Usuario usuarioRandom = usuarios.get(obtenerNumeroRandom(usuarios.size() - 1));
        pedido = new Pedido(itemPedidosRandoms, usuarioRandom);


        for (Pedido p : m1.getPedidos()) {
            Assert.assertNotEquals("Error: Ya existe un Pedido con este usuario("+ pedido.getUsuario().getNombreYApellido()+ "), es el pedido --> : " + p.getId() + ", con Usuario(" + p.getUsuario().getNombreYApellido() + ")", p.getUsuario(), pedido.getUsuario());
        }

        System.out.println("\nLa prueba de que no haya dos Pedidos que tengan el mismo Usuario pasó correctamente");
        System.out.println("\nNo existia ningun Pedido con el Usuario -->: " + pedido.getUsuario().getNombreYApellido());


    }
}
