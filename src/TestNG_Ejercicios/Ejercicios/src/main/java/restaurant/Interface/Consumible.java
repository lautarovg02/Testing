package restaurant.Interface;

public interface Consumible {
	public void consumirStock(int cantidad) throws TestNG_Ejercicios.Ejercicios.src.main.java.restaurant.Exceptions.ExceptionCantidadDeIngredientenNoDisponible;
	public void reponerStock(int cantidad);
	public int getStock();
	public String getNombre();
	public float getPrecioCompra();
}
