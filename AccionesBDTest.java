import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccionesBDTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void volcarBDaLista() {
        //En la base de datos hay dos registros guardados, inicializamos un objeto de la clase Galeria vacío
        int longitudLista;
        int tamañoInicio;
        int tamañoFinal;
        Galeria lista = new Galeria();

        tamañoInicio =  lista.longitudLista();
        System.out.println(tamañoInicio);

        AccionesBD.volcarBDaLista(lista);

        tamañoFinal = lista.longitudLista();
        System.out.println(lista.longitudLista());

        assertTrue(tamañoFinal > tamañoInicio);
    }

    @Test
    void borrarBD() {
        int posicion = 1;
        Galeria lista = new Galeria();
        int tamañoInicio;
        int tamañoFinal;
        String sql = "delete from peliculas where idPelicula = " + posicion;

        //Hay dos películas agregadas previamente, vuelca el contenido de la BD en la lista
        AccionesBD.volcarBDaLista(lista);
        tamañoInicio = lista.longitudLista();
        System.out.println(tamañoInicio);
        //Borramos la primera posicion.
        AccionesBD.borrarBD(1, sql);
        //Como sólo se ha borrado en la BD, la lista está desfasada, por lo que la borramos
        // y le volvemos a volcar el contenido
        Controlador.emparejarListayBD(lista);
        tamañoFinal = lista.longitudLista();
        System.out.println(tamañoFinal);

        assertTrue((tamañoInicio > tamañoFinal));
    }
    @Test
    void modificarBD() {
        String datoAntiguo;
        String datoNuevo;
        Galeria lista = new Galeria();
        int posicion = 1;
        String newTitulo = "Adiós Mundo";
        String sql = "update peliculas set titulo = " + "'" + newTitulo + "'" + " where idPelicula = " + +posicion + ";";

        AccionesBD.volcarBDaLista(lista);
        //Cargamos los datos de la base, y cogemos el que hay en la primera posición para guardarlo
        datoAntiguo = lista.getCartelera().get(posicion- 1).getNombre();
        System.out.println(datoAntiguo);

        AccionesBD.modificarBD(posicion, newTitulo,sql);
        //Después de modificar, emparejamos para que coincidan los datos de uno con el del otro y guardamos el nuevo
        //dato
        Controlador.emparejarListayBD(lista);
        datoNuevo = lista.getCartelera().get(posicion -1).getNombre();
        System.out.println(datoNuevo);
        //Los comparamos y no deben ser igual, por lo que el assert será true.
        assertFalse(datoAntiguo.equals(datoNuevo));

    }

    @Test
    void updateBD() {
        int idPelicula = 99; //Da igual el id porque despues de insertarlo, el metodo emparejar los corrige
        String titulo = "Mr.Pepe";
        String director = "";
        String genero= "";
        Galeria lista = new Galeria();
        int i = 1;
        String sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + lista.getCartelera().get(i - 1).getIdPelicula() + "," + "'" + lista.getCartelera().get(i - 1).getNombre() + "'," + "'" + lista.getCartelera().get(i - 1).getDirector() + "'," + "'" + lista.getCartelera().get(i - 1).getGénero() + "');";

        Controlador.emparejarListayBD(lista);
        lista.addPelicula(new Pelicula(idPelicula,titulo,director,genero));//Añadimos la película a la lista y la cargamos en la base
        AccionesBD.updateBD(lista, sql, 0);
        Controlador.emparejarListayBD(lista);

        //assertFalse(lista.getCartelera().get(i - 1).getNombre().equals() );
    }

    @Test
    void modificarTodoBD() {
        Pelicula antigua = new Pelicula();
        Pelicula nueva = new Pelicula();
        String datoNuevo;
        Galeria lista = new Galeria();
        int posicion = 1;
        String newTitulo = "Avatar"; String newDirector = "James"; String newGenero = "Aventura";
        String sql = "update peliculas set genero = " + "'" + newGenero + "'" + ", titulo = " + "'" + newTitulo +
                "'" + ", director = " + "'" + newDirector + "'" + " where idPelicula = " + posicion + ";";

        AccionesBD.volcarBDaLista(lista);
        //Cargamos los datos de la base, y cogemos el que hay en la primera posición para guardarlo
        antigua = (lista.getCartelera().get(posicion- 1));
        System.out.println(antigua.toString());

        AccionesBD.modificarTodoBD(posicion, newTitulo, newDirector,newGenero, sql);
        //Después de modificar, emparejamos para que coincidan los datos de uno con el del otro y guardamos el nuevo
        //dato
        Controlador.emparejarListayBD(lista);
       nueva = lista.getCartelera().get(posicion -1);
        System.out.println(nueva.toString());
        //Los comparamos y no deben ser igual, por lo que el assert será true.
        assertFalse(antigua.equals(nueva));
        assertTrue(nueva.getNombre().equals(newTitulo));
    }
    @Test
    void insertarBD() {
        Galeria lista = new Galeria();
        int tamañoInicial;
        int tamañoFinal;
        int posicion = 0;
        String sql;

        //Hay algún dato guardado en la BD, volcamos el contenido de la base a la lista y vemos el tamaño
        AccionesBD.volcarBDaLista(lista);
        tamañoInicial = lista.longitudLista();
        System.out.println(tamañoInicial);
        //Añadimos una pelicula y con su posición en la lista la insertamos en la base
        lista.addPelicula(new Pelicula(99,"La vida de pi", "Ni idea", "Aventura"));
        posicion = AccionList.buscarNombre(lista,"La vida de pi");
        sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + posicion + "," + "'" + lista.getCartelera().get(posicion - 1).getNombre() + "'," + "'" + lista.getCartelera().get(posicion - 1).getDirector() + "'," + "'" + lista.getCartelera().get(posicion - 1).getGénero() + "');";
        AccionesBD.insertarBD(posicion, lista, sql);
        //Volvemos a cuadrar la base de datos con la lista
        Controlador.emparejarListayBD(lista);
        tamañoFinal = lista.longitudLista();
        System.out.println(tamañoFinal);
        posicion = AccionList.buscarNombre(lista,"La vida de pi");

        assertTrue(tamañoFinal > tamañoInicial);
        assertTrue(lista.getCartelera().get(posicion -1).getNombre().equals("La vida de pi"));
    }
    @Test
    void buscarBD() {
        Galeria lista = new Galeria();
        int posicion = 0;
        String sql;

        lista.addPelicula(new Pelicula(99,"La vida de pi", "Ni idea", "Aventura"));
        Controlador.emparejarListayBD(lista);
        posicion = AccionList.buscarNombre(lista,"La vida de Pi");
        sql =  "select * from peliculas where idPelicula = " + "'" + posicion + "'";
        //Al devolver un booleano, si lo encuentra será true, por lo que pasará la prueba
        assertTrue(AccionesBD.buscarBD(posicion, sql));

        posicion = AccionList.buscarNombre(lista,"Monstruos S.A");
        sql =  "select * from peliculas where idPelicula = " + "'" + posicion + "'";
        //En este caso la película no está añadida
        assertFalse(AccionesBD.buscarBD(posicion, sql));
    }

    @Test
    void testBuscarBD() {
        Galeria lista = new Galeria();
        int posicion = 0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        String sql;
        //Añadimos las peliculas como en el caso anterior
        lista.addPelicula(new Pelicula(99,"Monstruos S.A", "Ni idea", "Animación"));
        posicion = AccionList.buscarNombre(lista,"Monstruos S.A");
        sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + posicion + "," + "'" + lista.getCartelera().get(posicion - 1).getNombre() + "'," + "'" + lista.getCartelera().get(posicion - 1).getDirector() + "'," + "'" + lista.getCartelera().get(posicion - 1).getGénero() + "');";
        AccionesBD.insertarBD(posicion, lista, sql);

        Controlador.emparejarListayBD(lista);
        lista.addPelicula(new Pelicula(99,"Los increíbles", "Ni idea", "Animación"));
        posicion = AccionList.buscarNombre(lista,"Los increíbles");
        sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + posicion + "," + "'" + lista.getCartelera().get(posicion - 1).getNombre() + "'," + "'" + lista.getCartelera().get(posicion - 1).getDirector() + "'," + "'" + lista.getCartelera().get(posicion - 1).getGénero() + "');";
        AccionesBD.insertarBD(posicion, lista, sql);
        Controlador.emparejarListayBD(lista);

        //El método devuelve un boolean, or lo que si encuentra el genero en la base de datos cumplirá el assert
        posiciones = AccionList.buscarGeneros(lista, "Animación");
        sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
        assertTrue(AccionesBD.buscarBD(posiciones, sql));
        //En este caso fallará
        posiciones = AccionList.buscarGeneros(lista, "Terror");
        sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
        assertFalse(AccionesBD.buscarBD(posiciones, sql));
    }

    @Test
    void mostrarBD() {
        //Si está vacía no ejecutará el bucle que tiene para imprimir
        //por lo que nunca el valor boleano nunca se ejecutara, en este caso tiene datos guardados

        assertTrue(AccionesBD.mostrarBD());
    }
}