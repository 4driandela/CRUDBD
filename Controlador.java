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
        try {
            do {
                eleccion = eleccionMenu(1, 6, Mensaje.mostrarMenu());

                switch (eleccion) {
                    case 1:
                        //Añade pelicula al ArrayList
                        añadirPelicula(lista);
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
                        lista.mostrarArrayList();
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
     * añadirPelicula es un método estático que nos pregunta tres valores de tipo String y los introduce dentro
     * de la lista como valores de un nuevo objeto de la clase Película.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void añadirPelicula(Galeria lista) {
        String titulo;
        String director;
        String genero;
        try {

            titulo = Herramientas.pedirString("¿Cuál es el título?");
            director = Herramientas.pedirString("¿Cuál es el director?");
            genero = Herramientas.pedirString("¿Cuál es el género?");

            AccionList.añadirPelLista(lista, titulo, director, genero);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $20");
        }
    }

    /**
     * buscarPelicula es un método estático que nos pide un número para la elección de las opciones y una palabra con
     * la que hacer la busqueda, imprime por pantalla un mensaje con el resultado de la busqueda.
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
        try {
            if (!Verificar.verificarListVacia(lista)) {
                eleccion = eleccionMenu(1, 3, Mensaje.mostrarMenuBusqueda());

                switch (eleccion) {
                    //Busca la primera coincidencia de título.
                    case 1:
                        titulo = Herramientas.pedirString("Dime el título que buscas");
                        AccionList.buscarNombre(lista, titulo);
                        break;
                    //Busca todas las coincidencias con el director.
                    case 2:
                        director = Herramientas.pedirString("Dime el director que buscas");
                        AccionList.buscarDirector(lista, director);
                        break;
                    //Busca todas las coincidencias con el género.
                    case 3:
                        genero = Herramientas.pedirString("Dime el género que buscas");
                        AccionList.buscarGenero(lista, genero);
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
     * modificarPosicion es un método estático que nos pide un número para la elección de su menú, el String para
     * realizar la busqueda dentro de la lista y el/los nuevo/s String para modificar la información en esa posición.
     * Previamente deben haber datos guardados para poder funcionar.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void modificarPosicion(Galeria lista) {
        //Debe de haber algún dato guardado para que realice la acción.
        int eleccion;
        int posicion;
        String titulo;
        String newTitulo;
        String newDirector;
        String newGenero;

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
                            AccionList.modificarNombre(lista, posicion, newTitulo);
                        }
                        break;
                    //Modifica sólo el director.
                    case 2:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newDirector = Herramientas.pedirString("Cuál es el nuevo valor para el director");
                            AccionList.modificarDirector(lista, posicion, newDirector);
                        }
                        break;
                    //Modifica sólo el género.
                    case 3:
                        titulo = Herramientas.pedirString("Dime la película que buscas");
                        posicion = AccionList.buscarNombre(lista, titulo);
                        if (posicion != -1) {
                            newGenero = Herramientas.pedirString("Cuál es el nuevo valor para el género");
                            AccionList.modificarGenero(lista, posicion, newGenero);
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
     * de la lista. Previamente deben haber datos guardados para poder funcionar.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @author Adriandela
     */
    public static void borrarPosicion(Galeria lista) {
        //Debe de haber algún dato guardado para que realice la acción.
        int posicion;
        String titulo;
        try {
            if (!Verificar.verificarListVacia(lista)) {
                titulo = Herramientas.pedirString("¿Que película quieres borrar?");
                posicion = AccionList.buscarNombre(lista, titulo);
                if (posicion != -1) {
                    AccionList.borrarPelicula(lista, posicion);
                }
            } else {
                Mensaje.advertenciaListVacia();
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa $50");
        }
    }
}