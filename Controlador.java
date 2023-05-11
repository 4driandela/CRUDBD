import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase en la que se realiza la gestión del programa, los métodos empleados se conforman de la utilización de los
 * métodos de otras clases para realizar las funciones del programa.
 */
public class Controlador {
    /*
    Símbolos control de excepciones
        $ Controlador
        # Herramientas
        ~ AccionList
        € Verificar
        * Galeria
     */
    public static void main(String[] args) {
        int eleccion;
        Galeria lista = new Galeria();
        emparejarListayBD(lista);//Carga los datos de la base de datos en la lista.
        try {
            do {
                eleccion = eleccionMenu(1, 6, Mensaje.mostrarMenu());

                switch (eleccion) {
                    case 1:
                        //Añade
                        añadirPeliculaListaYBD(lista);
                        break;
                    case 2:
                        //Busqueda
                        buscarPelicula(lista);
                        break;

                    case 3:
                        //Modificación
                        modificarPosicion(lista);
                        break;
                    case 4:
                        //Borrar
                        borrarPosicion(lista);
                        break;
                    case 5:
                        //Vista general
                        mostrarListayBD(lista);
                        break;
                    default:
                        break;
                }
            } while (eleccion != 6);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $00");
        }
    }

    /**
     * eleccionMenu es un método estático que nos pide un número por teclado y nos garantiza que esté dentro de los
     * que queremos para nuestro programa, avisándonos si este se encuentre fuera de los límites y repitiénose hasta
     * que el número sea correcto.
     *
     * @param minimo int que marca el límite inferior para el rango del número de elección.
     * @param maximo int que marca el límite superior para el rango del número de elección.
     * @param texto  String que recoge el texto que se mostrará por pantalla.
     * @return eleccion: Devuelve que un int cuando supera las condiciones que le definimos.
     * @author Adriandela
     */

    public static int eleccionMenu(int minimo, int maximo, String texto) {
        int eleccion = 0;
        boolean numeroCorrecto = false;
        try {
            do {
                eleccion = Herramientas.pedirInt(texto);
                numeroCorrecto = Verificar.verificarInt(minimo, maximo, eleccion);

                if (!numeroCorrecto) {
                    System.out.println("Las opciones varían desde " + minimo + " hasta " + maximo + ", ambos incluidos.");
                }
            } while (!numeroCorrecto);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $10");
        }
        return eleccion;
    }

    /**
     * añadirPeliculaYBD es un método estático que nos pregunta tres valores de tipo String y los introduce dentro
     * de la lista como valores de un nuevo objeto de la clase Película, en paralelo también añade esos datos a la
     * tabla que hay en la base de datos
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void añadirPeliculaListaYBD(Galeria lista) {
        String titulo;
        String director;
        String genero;
        int posicion;
        String sql;

        try {

            titulo = Herramientas.pedirString("¿Cuál es el título?");
            director = Herramientas.pedirString("¿Cuál es el director?");
            genero = Herramientas.pedirString("¿Cuál es el género?");

            AccionList.añadirPelLista(lista, titulo, director, genero);
            posicion = AccionList.buscarNombre(lista, titulo);
            sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + posicion + "," + "'" + lista.getCartelera().get(posicion - 1).getNombre() + "'," + "'" + lista.getCartelera().get(posicion - 1).getDirector() + "'," + "'" + lista.getCartelera().get(posicion - 1).getGénero() + "');";
            AccionesBD.insertarBD(posicion, lista, sql);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $20");
        }
    }

    /**
     * buscarPelicula es un método estático que nos pide un número para la elección de las opciones y una palabra con
     * la que hacer la busqueda, busca la posición en la lista para luego pasársela a la sentencia sql e imprimir por
     * pantalla el resultado de la base de datos
     * Previamente deben haber datos guardados para poder funcionar.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void buscarPelicula(Galeria lista) {
        //Debe de haber algún dato guardado para que realice la acción.
        int eleccion;
        String titulo;
        String genero;
        String director;
        int posicion = 0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        String sql;

        try {
            if (!Verificar.verificarListVacia(lista)) {
                eleccion = eleccionMenu(1, 3, Mensaje.mostrarMenuBusqueda());

                switch (eleccion) {
                    //Busca la primera coincidencia de título.
                    case 1:
                        titulo = Herramientas.pedirString("Dime el título que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
                        AccionesBD.buscarBD(posicion, sql);
                        break;
                    //Busca todas las coincidencias con el director.
                    case 2:
                        director = Herramientas.pedirString("Dime el director que buscas");
                        posiciones = AccionList.buscarDirectores(lista, director);
                        System.out.println(posiciones.toString());
                        sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
                        AccionesBD.buscarBD(posiciones, sql);
                        break;

                    case 3:
                        genero = Herramientas.pedirString("Dime el género que buscas");
                        posiciones = AccionList.buscarGeneros(lista, genero);
                        System.out.println(posiciones.toString());
                        sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
                        AccionesBD.buscarBD(posiciones, sql);
                        break;
                }
            } else {
                Mensaje.advertenciaListVacia();
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $30");
        }
    }

    /**
     * modificarPosicion es un método estático que modifica una posición en concreto de la base de datos, así como de la
     * lista que tiene asociada.
     *
     * @param lista
     */
    public static void modificarPosicion(Galeria lista) {
        //Debe de haber algún dato guardado para que realice la acción.
        int eleccion;
        int posicion;
        String titulo;
        String newTitulo;
        String newDirector;
        String newGenero;
        String sql;
        try {
            if (!Verificar.verificarListVacia(lista)) {
                eleccion = eleccionMenu(1, 4, Mensaje.mostrarMenuModificar());

                switch (eleccion) {
                    //En todos los casos emplea siempre el título para encontrar la película.
                    //Modifica sólo el título.
                    case 1:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newTitulo = Herramientas.pedirString("Cuál es el nuevo valor para el título");
                            sql = "update peliculas set titulo = " + "'" + newTitulo + "'" + " where idPelicula = " + +posicion + ";";
                            AccionList.modificarNombre(lista, posicion, newTitulo);
                            AccionesBD.modificarBD(posicion, newTitulo, sql);
                        }
                        break;
                    //Modifica sólo el director.
                    case 2:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newDirector = Herramientas.pedirString("Cuál es el nuevo valor para el director");
                            sql = "update peliculas set director = " + "'" + newDirector + "'" + " where idPelicula = " + +posicion + ";";
                            AccionList.modificarDirector(lista, posicion, newDirector);
                            AccionesBD.modificarBD(posicion, newDirector, sql);
                        }
                        break;
                    //Modifica sólo el género.
                    case 3:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newGenero = Herramientas.pedirString("Cuál es el nuevo valor para el género");
                            sql = "update peliculas set genero = " + "'" + newGenero + "'" + " where idPelicula = " + +posicion + ";";
                            AccionList.modificarGenero(lista, posicion, newGenero);
                            AccionesBD.modificarBD(posicion, newGenero, sql);
                        }
                        break;
                    //Modifica el título, género y director.
                    case 4:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newTitulo = Herramientas.pedirString("Cuál es el nuevo valor para el título");
                            AccionList.modificarNombre(lista, posicion, newTitulo);

                            newDirector = Herramientas.pedirString("Cuál es el nuevo valor para el director");
                            AccionList.modificarDirector(lista, posicion, newDirector);

                            newGenero = Herramientas.pedirString("Cuál es el nuevo valor para el género");
                            AccionList.modificarGenero(lista, posicion, newGenero);
                            sql = "update peliculas set genero = " + "'" + newGenero + "'" + ", titulo = " + "'" + newTitulo + "'" + ", director = " + "'" + newDirector + "'" + " where idPelicula = " + posicion + ";";
                            AccionesBD.modificarTodoBD(posicion, newTitulo, newDirector, newGenero, sql);


                        }
                        break;
                }
            } else {
                Mensaje.advertenciaListVacia();
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $40");
        }
    }

    /**
     * borrarPosicion es un método estático que encuentra la posición que coincide con el valor de búsqueda y la elimina
     * de la lista y de la base de datos. Previamente deben haber datos guardados para poder funcionar.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void borrarPosicion(Galeria lista) {
        //Debe de haber algún dato guardado para que realice la acción.
        int posicion;
        String titulo;
        String sql;
        try {
            if (!Verificar.verificarListVacia(lista)) {
                titulo = Herramientas.pedirString("¿Que película quieres borrar?");
                posicion = AccionList.buscarNombre(lista, titulo);
                if (posicion != -1) {
                    AccionList.borrarPelicula(lista, posicion);
                    sql = "delete from peliculas where idPelicula = " + posicion;
                    AccionesBD.borrarBD(posicion, sql);
                    emparejarListayBD(lista);

                }
            } else {
                Mensaje.advertenciaListVacia();
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $50");
        }
    }

    /**
     * emparejarListayBD es un método, que recoge la tabla de la base de datos, la vuelva en una lista y la ordena para
     * luego volver a volcarla en la base de datos, de esta forma se ordenan y colocan los datos de forma idéntica.
     *
     * @param lista
     */
    public static void emparejarListayBD(Galeria lista) {
        int longitudLista;
        Galeria listaAux = new Galeria();
        String sql;
        try {
            AccionesBD.volcarBDaLista(listaAux);//Coge los registros de la BD
            longitudLista = listaAux.longitudLista();
            listaAux.ordenarLista();//Al idPelicula le asigna un 1 para el primer registro y le suma 1 al siguiente registro, ordenándolos
            sql = "delete from peliculas";//Vacía la bd
            AccionesBD.borrarBD(sql);
            for (int i = 1; i <= longitudLista; i++) {
                sql = "insert into peliculas (idPelicula, Titulo, Director, Genero) values (" + listaAux.getCartelera().get(i - 1).getIdPelicula() + "," + "'" + listaAux.getCartelera().get(i - 1).getNombre() + "'," + "'" + listaAux.getCartelera().get(i - 1).getDirector() + "'," + "'" + listaAux.getCartelera().get(i - 1).getGénero() + "');";
                AccionesBD.updateBD(lista, sql, i);//Vuelve a introducir la lista ya ordenada
            }
            lista.removeALLPelicula();//Borra la lista principal
            AccionesBD.volcarBDaLista(lista);//La llena con los datos ordenados
            listaAux.removeALLPelicula();//Vacía la lista aux
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * mostrarListayBD es un método estático que muestra por pantalla todo el contenido de la base de datos y de la lista
     *
     * @param lista
     */
    public static void mostrarListayBD(Galeria lista) {
        try {
            lista.mostrarArrayList();
            System.out.println("");
            AccionesBD.mostrarBD();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}