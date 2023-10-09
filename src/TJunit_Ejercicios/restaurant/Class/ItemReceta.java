package TJunit_Ejercicios.restaurant.Class;

public class ItemReceta {
    Ingrediente ingrediente;
    int cantidad;

    public ItemReceta(Ingrediente ingrediente, int cantidad) {
        super();
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ItemReceta{" +
                "                            ingrediente=" + ingrediente +
                ",                             cantidad=" + cantidad +
                '}' + "\n";  // Agregado un salto de línea aquí
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
