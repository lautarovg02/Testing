package TJunit_Ejercicios.restaurant.Interface;

import TJunit_Ejercicios.restaurant.Exceptions.SinSuficientesIngredientesException;

public interface Vendible {
	public float getPrecioVenta();
	public void preparar() throws SinSuficientesIngredientesException;
}
