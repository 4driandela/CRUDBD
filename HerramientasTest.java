import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerramientasTest {
    /*Para pedirInt y pedirString no pude realizar la prueba porque no deja escribir por consola o no he logrado
     *saber como hacerlo*/
    @Test
    void convertirAMinus() {
        String palabraMay = "HolA";
        String palabraMin;

        palabraMin = Herramientas.convertirAMinus(palabraMay);
        /* Convierto la palabra inicial que contiene mayus
        y en principio después de la conversión, la comparación
        debe ser cierta
         */
        assertEquals(palabraMin, "hola");
        assertTrue(palabraMin != palabraMay);
    }

}