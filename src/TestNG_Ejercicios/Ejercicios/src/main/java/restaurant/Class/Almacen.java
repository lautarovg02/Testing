package restaurant.Class;


import restaurant.Interface.Consumible;

import java.util.LinkedList;
import java.util.List;

public class Almacen {
    public static List<Consumible> Stock = new LinkedList<>();

    public static void IngresarConsumibles(Consumible cual, int cuanto) {
        cual.reponerStock(cuanto);
    }

    public static void ExtraerConsumibles(Consumible cual, int cuanto) {
        cual.consumirStock(cuanto);
    }

    public static boolean esPosibleCocinar(Receta r) {
        for (int i = 0; i < r.ingredientes.size(); i++) {
            ItemReceta item = r.getIngredientes().get(i);
            System.out.println(item.getIngrediente().getNombre() + ": necesita --> :  " + item.getCantidad() + " .");
            System.out.println(item.getIngrediente().getNombre() + ": tenemos --> : " + item.getIngrediente().getStock()+ " .");

            if (item.cantidad > item.getIngrediente().getStock())
            return false;
        }

        return true;
    }


}
