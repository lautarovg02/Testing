package TJunit_Ejercicios.restaurant.Test;

import java.util.Random;

public abstract class Testing {

    public static int obtenerNumeroRandom(int max){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(max) + 1;
        return numeroAleatorio;
    }

    public static void cargarEjemplos() {}
}
