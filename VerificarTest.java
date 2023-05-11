import static org.junit.jupiter.api.Assertions.*;

class VerificarTest {
    @org.junit.jupiter.api.Test
    void verificarInt() {
        int numero;
        boolean resultado;

        /*
        Devolverá true porque el número está entre los límites,
        estos incluidos.
         */
        numero = 6;
        resultado = Verificar.verificarInt(1, 6, numero);
        assertTrue(resultado);
        /*
        En este caso false, por ello también pasará el assert.
         */
        numero = 8;
        resultado = Verificar.verificarInt(1, 6, numero);
        assertFalse(resultado);
    }

    @org.junit.jupiter.api.Test
    void verificarListVacia() {
        boolean resultado;
        Galeria lista = new Galeria();
        /*
        Después de crear una lista vacía, vemos su tamaño y es cierto que está vacía, el método
        debe devolver true, por ello debe de pasar el assertTrue.
         */
        resultado = Verificar.verificarListVacia(lista);
        assertTrue(resultado);
        /*
        Después de introducir algún dato, en este caso devuelve false. Por eso también pasa el
        assertFalse
         */
        lista.addPelicula(new Pelicula(1,"Avatar", "James Cameron", "Aventura"));
        resultado = Verificar.verificarListVacia(lista);
        assertFalse(resultado);
    }

}