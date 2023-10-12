package TJunit_Ejercicios.restaurant;

import TJunit_Ejercicios.restaurant.Class.*;
import TJunit_Ejercicios.restaurant.Exceptions.SinSaldoException;

public class Main {

    public static void main(String[] args) {
        // * USUARIOS
        Usuario u1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario u2 = new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        Usuario u3 = new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario u4 = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

        // * INGREDIENTES
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000,450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000,300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000,400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000,2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100,800);

        // * ITEMS DE RECETA
        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);

        // * RECETAS
        Receta receta_tortilla = new Receta("Tortilla", 15,200);
        receta_tortilla.addIngrediente(ir4);
        receta_tortilla.addIngrediente(ir5);

        Receta receta_hamburguesa = new Receta("receta_hamburguesa grande", 5,3000);
        receta_hamburguesa.addIngrediente(ir2);
        receta_hamburguesa.addIngrediente(ir1);
        receta_hamburguesa.addIngrediente(ir3);
        receta_hamburguesa.addIngrediente(ir6);

        Receta receta_papasFritas = new Receta("papas fritas", 7,300);
        receta_papasFritas.addIngrediente(ir5);
        receta_papasFritas.addIngrediente(ir3);

        // * PRODUCTOS BASICOS
        Producto lata_coca_cola = new ProductoBasico("Lata Coca Cola", 10, 20);
        Producto lata_sprite = new ProductoBasico("Lata Sprite", 10, 22);
        Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
        Producto agua = new ProductoBasico("Agua", 10, 22);

        // * PRODUCTOS ELABORADOS
        Producto tortilla = new ProductoElaborado("Retorti", 120);
        ((ProductoElaborado) tortilla).setReceta(receta_tortilla);

        Producto hamburguesa_BIG_0 = new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado) hamburguesa_BIG_0).setReceta(receta_hamburguesa);

        Producto patatas = new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado) tortilla).setReceta(receta_papasFritas);

        // * MOSTRADOR
        Mostrador m1 = new Mostrador();
        m1.setNombreOperador("Jose");

        Mostrador m2 = new Mostrador();
        m2.setNombreOperador("Maria");

//        Cocina c = new Cocina();
        //c.start();

        Pedido p = new Pedido();
        p.setUsuario(u1);
        p.agregarItem(new ItemPedido(1, lata_coca_cola));
        p.agregarItem(new ItemPedido(1, tortilla));
        try {
            p.solicitarPedido();

            //Mostrador ordenesActuales = new Mostrador();

            //ordenesActuales.agregar(p);

            p.prepararPedido();
            p.terminarPedido();
            p.entregarPedido();


        } catch (SinSaldoException ex) {
            System.out.println("No posee saldo suficiente");
        }

        System.out.println("Saldo Usuario " + u1.getSaldo());
    }


}
