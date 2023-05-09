import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GaleriaTest {

    @Test
    void addPelicula() {
        Galeria lista = new Galeria();
        /*
        Con el objeto creado, la lista vacía debe de estar vacía por lo que su longitud tiene ser de 0
        por ello el assertFalse debe pasarlo porque la condición no es cierta.
         */
        System.out.println("Longitud inicio " + lista.longitudLista());
        assertFalse(lista.longitudLista() > 0);

        lista.addPelicula(new Pelicula("Futurama: El juego de Bender", "Dwayne Carey-Hill", "Animación"));
        /*
        Después de añadir un objeto de la clase Pelicula, la longitud aumenta a 1 y la condición del assertTrue
        se cumple.
         */
        System.out.println("Longitud final " + lista.longitudLista());
        assertTrue(lista.longitudLista() > 0);
    }

    @Test
    void removePelicula() {
        Galeria lista = new Galeria();
        lista.addPelicula(new Pelicula("Futurama: El juego de Bender", "Dwayne Carey-Hill", "Animación"));

        /*
        En esta prueba hacemos la inversa, la lista ya contiene un elemento, por lo que en el assertTrue se cumple la
        condición.
         */
        System.out.println("Longitud inicio " + lista.longitudLista());
        assertTrue(lista.longitudLista() > 0);

        lista.removePelicula(0);
        /*
        Después de haber eliminado el elemento, si el método funciona bien, la longitud de la lista queda en 0, por lo
        que la condición no se cumple y pasa el assertFalse.
         */
        System.out.println("Longitud final " + lista.longitudLista());
        assertFalse(lista.longitudLista() > 0);
    }

    @Test
    void longitudLista() {
        Galeria lista = new Galeria();

        /*
        Con la lista vacía, la predicción es que devuelva 0, comparando lo que devuelve el método a lo que esperamos
        que sea (0), vemos que se cumple la comparación y son iguales.
         */
        System.out.println("Longitud inicio " + lista.longitudLista());
        assertEquals(lista.longitudLista(), 0);

        lista.addPelicula(new Pelicula("Futurama: El juego de Bender", "Dwayne Carey-Hill", "Animación"));
        /*
        Después de añadir un elemento, lo esperado es que la longitud sea 1. Se vuelve a realizar la prueba y el
        assertEquals se cumple.
         */
        System.out.println("Longitud final " + lista.longitudLista());
        assertEquals(lista.longitudLista(), 1);
    }
}