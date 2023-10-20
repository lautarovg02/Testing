package restaurant.Class;


import restaurant.Interface.Consumible;

public class Ingrediente implements Consumible {
    String nombre;
    String unidad;
    int cantidad;
    float precioCompra;

    public Ingrediente(String nombreIngrediente, String unidadDeMedida, int stockInicial, float precioCompra) {
        this.nombre = nombreIngrediente;
        this.unidad = unidadDeMedida;
        this.cantidad = stockInicial;
        this.precioCompra = precioCompra;
    }


    public void consumirStock(int cantidad) throws TestNG_Ejercicios.Ejercicios.src.main.java.restaurant.Exceptions.ExceptionCantidadDeIngredientenNoDisponible {
        if(this.getStock() < cantidad) throw new TestNG_Ejercicios.Ejercicios.src.main.java.restaurant.Exceptions.ExceptionCantidadDeIngredientenNoDisponible("La cantidad de ingredientes que necesita no puede ser menor al stock disponible");
        this.cantidad -= cantidad;
    }
    public void reponerStock(int cantidad) {

        this.cantidad += cantidad;
    }

    public int getStock() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public float getPrecioCompra() {
        return this.precioCompra;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "                            nombre='" + nombre + '\'' +
                ",                             unidad='" + unidad + '\'' +
                ",                             cantidad=" + cantidad +
                ",                             precioCompra=" + precioCompra +
                '}' + "\n";  // Agregado un salto de línea aquí
    }
}
