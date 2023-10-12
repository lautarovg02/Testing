package TJunit_Ejercicios.restaurant.Test;

import TJunit_Ejercicios.restaurant.Class.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class TestProducto extends Testing {
    static final int PORCENTAJE_DE_GANANCIA_MINIMA = 20;
    static List<Producto> productos = new ArrayList<>();
    static Producto producto;


    @BeforeClass

    public static void cargarEjemplos() {
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240, 350);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000, 450);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000, 300);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000, 400);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000, 2200);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100, 800);

        //ITEMS DE LA RECETAS
        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);

        //RECETAS
        Receta receta_tortilla = new Receta("Tortilla", 15, 200);
        receta_tortilla.addIngrediente(ir4);
        receta_tortilla.addIngrediente(ir5);

        Receta receta_hamburguesa = new Receta("receta_hamburguesa grande", 5, 3000);
        receta_hamburguesa.addIngrediente(ir2);
        receta_hamburguesa.addIngrediente(ir1);
        receta_hamburguesa.addIngrediente(ir3);
        receta_hamburguesa.addIngrediente(ir6);

        Receta receta_papas_fritas = new Receta("papas fritas", 7, 300);
        receta_papas_fritas.addIngrediente(ir5);
        receta_papas_fritas.addIngrediente(ir3);

        //PRODUCTOS BASICOS(NO LLEVAN RECETA)
        Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
        Producto agua = new ProductoBasico("Agua", 10, 22);
        Producto lata_coca_cola = new ProductoBasico("Lata Coca Cola", 10, 20);
        Producto lata_sprite = new ProductoBasico("Lata Sprite", 10, 22);

        //PRODUCTOS ELABORADOS(PRODUCTOS HECHOS A PARTIR DE UNA RECETA)
        Producto tortilla = new ProductoElaborado("Retorti", 110, 120);
        ((ProductoElaborado) tortilla).setReceta(receta_tortilla);

        Producto hamburguesa_BIG_0 = new ProductoElaborado("BIG O", 120, 150);
        ((ProductoElaborado) hamburguesa_BIG_0).setReceta(receta_hamburguesa);

        Producto patatas = new ProductoElaborado("PATATAS", 65, 120);
        ((ProductoElaborado) tortilla).setReceta(receta_papas_fritas);

        productos.addAll(List.of(gaseosaCola, agua, lata_coca_cola, lata_sprite, tortilla, hamburguesa_BIG_0, patatas));
    }

    @Test
    @DisplayName("Verificar que la ganancia de los productos sea mayor al 20%")
    public void TestGananciaDeProductos() {
        producto = productos.get(obtenerNumeroRandom(productos.size()) - 1);
        float precioDeCompraPorUnidad = producto.getPrecioUnitarioCompra();
        float precioDeVentaPorUnidad = producto.getPrecioUnitarioVenta();

        float porcentajeDeGanancia = calcularPorcentajeGanancia(precioDeVentaPorUnidad, precioDeCompraPorUnidad);
        System.out.println("Producto: " + producto.getNombre() + " ,PrecioDeCompraPorUnidad: " + precioDeCompraPorUnidad + ", precioDeVentaPorUnidad: " + precioDeVentaPorUnidad + ", porcentajeDeGanancia: " + porcentajeDeGanancia);

        Assert.assertTrue("Error: El porcentaje de ganancia del producto es menor al establecido por las reglas negocio. Su porcentaje es --> : " + porcentajeDeGanancia + " .", porcentajeDeGanancia >= PORCENTAJE_DE_GANANCIA_MINIMA);

        // Informar que la prueba ha pasado correctamente
        System.out.println("\nLa prueba de ganancia del producto pasó correctamente, el porcetaje de ganancia es --> " + (int) porcentajeDeGanancia + ".");

    }

    public float calcularPorcentajeGanancia(float precioVenta, float precioCompra) {
        float ganancia = precioVenta - precioCompra;
        System.out.println(ganancia);
        return (ganancia / precioCompra) * 100;
    }
}
