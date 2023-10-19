package restaurant.Class;


import java.util.ArrayList;
import java.util.List;

public class Receta {
	List<ItemReceta> ingredientes;
	String nombreInterno;
	int tiempoDeCoccion;
	private float precioVenta;
	public Receta( String nombreInterno, int tiempoDeCoccion, float precioVenta) {
		super();
		this.ingredientes = new ArrayList<ItemReceta>();
		this.nombreInterno = nombreInterno;
		this.tiempoDeCoccion = tiempoDeCoccion;
		this.precioVenta = precioVenta;
	}
	
	public List<ItemReceta> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<ItemReceta> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	public String getNombreInterno() {
		return nombreInterno;
	}
	public void setNombreInterno(String nombreInterno) {
		this.nombreInterno = nombreInterno;
	}
	public int getTiempoDeCoccion() {
		return tiempoDeCoccion;
	}
	public void setTiempoDeCoccion(int tiempoDeCoccion) {
		this.tiempoDeCoccion = tiempoDeCoccion;
	}
	public void addIngrediente(ItemReceta i) {
		
		ingredientes.add(i);
	}
	
	public void addIngrediente(Ingrediente ingrediente, int cantidad ) {
		ItemReceta item=new ItemReceta(ingrediente, cantidad);
		ingredientes.add(item);
	}
	
	public float calcularCosto() {
		float total = 0;
		
		for (ItemReceta item : ingredientes) {
			total += (item.getCantidad()) * (item.getIngrediente().getPrecioCompra());
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Receta{" +
				",                             nombreInterno='" + nombreInterno + '\'' +
				"                            ingredientes=" + ingredientes +
				",                             tiempoDeCoccion=" + tiempoDeCoccion +
				",                             precioVenta=" + precioVenta +
				'}' + "\n";  // Agregado un salto de línea aquí
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}
	
}
