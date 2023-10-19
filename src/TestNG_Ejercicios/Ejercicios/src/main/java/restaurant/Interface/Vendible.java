package restaurant.Interface;

import restaurant.Exceptions.SinSuficientesIngredientesException;

public interface Vendible {
	public float getPrecioVenta();
	public void preparar() throws SinSuficientesIngredientesException;
}
