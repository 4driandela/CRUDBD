import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccionListTest {
    @Test
    void añadirPelLista() {
        String titulo = "Avatar";
        String director = "James Cameron";
        String genero = "Aventura";
        /*
        Con la lista recién creada comprobamos que su longitud es
        de 0, por lo que la condición del assertFalse no se
        cumplirá y pasará la prueba
         */
        Galeria lista = new Galeria();
        assertFalse(lista.longitudLista() > 0);
        /*
        Para comprobar que el método ha añadido el elemento,
        miramos que la longitud sea mayor que 0, como la
        condición se cumple pasa la prueba del assertTrue.
         */
        AccionList.añadirPelLista(lista, titulo, director, genero);
        assertTrue(lista.longitudLista() > 0);
    }

    @Test
    void buscarNombre() {
        Galeria lista = new Galeria();
        int resultado;
        int posEsperada;

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");
        /*
        Con varios elementos en la lista, le pasamos el título que queremos. En principio su posición
        debe ser 1, por haberse añadido en segundo lugar. Comparamos la posición esperada con la que
        devuelve el método y vemos que pasa la prueba.
         */
        posEsperada = 1;
        resultado = AccionList.buscarNombre(lista, "Capitan Fantástico");
        //Le resto 1 al resultado, porque la posición que sale es para la base de datos
        //De esta forma lo hago para que concuerde para las listas
        assertEquals(resultado -1, posEsperada);
        /*
        Ahora buscamos un título que no este y la posición que se espera es -1. Se vuelve a realizar
        la comparación y al no encontrar el título devuelve -1, pasando así la prueba.
         */
        //Aquí no hace falta, porque si no lo encuentra asigna -2, que al uno que le suma el método en el return
        //Devuelve la posición -1
        posEsperada = -1;
        resultado = AccionList.buscarNombre(lista, "SinCoincidencia");
        assertEquals(resultado, posEsperada);
    }

    @Test
    void buscarGeneros() {
        Galeria lista = new Galeria();
        ArrayList<Integer> aux = new ArrayList<Integer>();

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");


        //El método devuelve un arrayList de posiciones que coinciden con la búsqueda
       aux =  AccionList.buscarGeneros(lista, "Aventura");
        assertTrue(aux.size() >=1);
        //En este caso no debe de guardar posiciones porque no se encuentra en la lista ese género
        //Por lo que su tamaño es de cero.
        aux= AccionList.buscarGeneros(lista, "SinCoincidencia");
        assertFalse(aux.size() >= 1);

    }

    @Test
    void buscarDirectores() {
        Galeria lista = new Galeria();
        ArrayList<Integer> aux = new ArrayList<Integer>();

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");

        //El método devuelve un arrayList de posiciones que coinciden con la búsqueda
        aux =AccionList.buscarDirectores(lista, "Matt Ross");
        assertTrue(aux.size() >=1);
        //En este caso no debe de guardar posiciones porque no se encuentra en la lista ese género
        //Por lo que su tamaño es de cero.
        aux = AccionList.buscarDirectores(lista, "SinCoincidencia");
        assertFalse(aux.size() >= 1);
    }

    @Test
    void modificarNombre() {
        Galeria lista = new Galeria();

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");
        /*
        Comprobamos que en la posición 0, el título es Avatar, predecimos lo que saldrá, que la lista en
        esa posición es Avatar. Se cumple la condición y pasa el assertTrue.
         */
        assertTrue(lista.getCartelera().get(0).getNombre().equals("Avatar"));
        //Al igual que antes, el método modificarNombre funciona con la posición de la base de datos
        //Por lo que marco 1 en vez de cero, porque dentro del métotodo le restará 1 a la posición
        //y será la posición real en la lista
        AccionList.modificarNombre(lista, 1, "Avatar 2");
        /*
        Modificamos la posición a Avatar 2 y vemos que el assertFalse prediciendo que saldrá Avatar en la
        condición, es falsa, por lo que pasa la prueba.
        En el caso del assertTrue, predecimos que saldrá Avatar 2 y pasa la condición del assertTrue.
         */
        assertFalse(lista.getCartelera().get(0).getNombre().equals("Avatar"));
        assertTrue(lista.getCartelera().get(0).getNombre().equals("Avatar 2"));
    }

    @Test
    void modificarDirector() {
        Galeria lista = new Galeria();

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");
        /*
        Comprobamos que en la posición 1, el título es Matt Ross, predecimos lo que saldrá en la lista en
        esa posición es Matt Ross. Se cumple la condición y pasa el assertTrue.
         */
        assertTrue(lista.getCartelera().get(1).getDirector().equals("Matt Ross"));
        //Idéntico problema que en el anterior, sumo uno a la posición para que concuerde
        AccionList.modificarDirector(lista, 2, "Pepe & Lola");
        /*
        Modificamos la posición a Pepe & Lola y vemos que el assertFalse prediciendo que saldrá Matt Ross en la
        condición, es falsa, por lo que pasa la prueba.
        En el caso del assertTrue, predecimos que saldrá Pepe & Lola y pasa la condición del assertTrue.
         */
        assertFalse(lista.getCartelera().get(1).getDirector().equals("Matt Ross"));
        assertTrue(lista.getCartelera().get(1).getDirector().equals("Pepe & Lola"));
    }
    @Test
    void modificarGenero() {
        Galeria lista = new Galeria();

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");
        /*
        Comprobamos que en la posición 1, el título es Comedia, predecimos lo que saldrá de la lista en
        esa posición es Comedia. Se cumple la condición y pasa el assertTrue.
         */
        assertTrue(lista.getCartelera().get(1).getGénero().equals("Comedia"));
        //Idéntico problema que en el anterior, sumo uno a la posición para que concuerde
        AccionList.modificarGenero(lista, 2, "Drama");
        /*
        Modificamos la posición a Drama y vemos que el assertFalse prediciendo que saldrá Comedia en la
        condición, es falsa, por lo que pasa la prueba.
        En el caso del assertTrue, predecimos que saldrá Drama y pasa la condición del assertTrue.
         */
        assertFalse(lista.getCartelera().get(1).getGénero().equals("Comedia"));
        assertTrue(lista.getCartelera().get(1).getGénero().equals("Drama"));
    }

    @Test
    void borrarPelicula() {
        Galeria lista = new Galeria();
        int posicionBusquedaInicio;
        int posicionBusquedaFinal;

        AccionList.añadirPelLista(lista, "Avatar", "James Cameron", "Aventura");
        AccionList.añadirPelLista(lista, "Capitan Fantástico", "Matt Ross", "Comedia");

        posicionBusquedaInicio = AccionList.buscarNombre(lista, "Avatar");

        AccionList.borrarPelicula(lista, AccionList.buscarNombre(lista, "Avatar"));

        posicionBusquedaFinal = AccionList.buscarNombre(lista, "Avatar");

        System.out.println("posicionBusquedaFinal " + posicionBusquedaFinal);
        System.out.println("posicionBusquedaInicio " + posicionBusquedaInicio);
        /*
        Después de haber añadido datos, busco en la lista el título y guardo su posición, En este caso
        busco Avatar, por lo que su posición antes de borrarlo es 0, borro la película de la lista y la
        vuelvo a buscar, ahora al no estar la posición que devuelve buscarNombre es de -1. Comparo las
        posiciones y como no son iguales la condición no se cumple y pasa el assertFalse.
         */
        assertFalse(posicionBusquedaInicio == posicionBusquedaFinal);
        /*
        Después vuelvo a comparar la posición final, para saber que no está y que no ha cambiado
        de posición, la comparo a -1 que es cuando no se encuentra el valor. Se cumple la condición del
        assertTrue y pasa la prueba.
         */
        assertTrue(posicionBusquedaFinal == -1);

    }

}