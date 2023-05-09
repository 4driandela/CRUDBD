import java.util.ArrayList;

/**
 * Métodos que acceden o modifican la información privada de los atributos de la clase.
 *
 * @author Adriandela
 */
public class Galeria {
    //*

    private ArrayList<Pelicula> cartelera = new ArrayList<Pelicula>();

    public ArrayList<Pelicula> getCartelera() {
        return cartelera;
    }

    public void setCartelera(ArrayList<Pelicula> cartelera) {
        this.cartelera = cartelera;
    }

    @Override
    public String toString() {
        return "Galería{" +
                "cartelera=" + cartelera +
                '}';
    }

    /**
     * addPelicula es un método que añade un objeto de la clase Pelicula al ArrayList<Pelicula> del objeto Galeria.
     *
     * @param pelicula Objeto de la clase pelicula que queremos añadir a la lista.
     * @author Adriandela
     */
    public void addPelicula(Pelicula pelicula) {
        try {
            cartelera.add(pelicula);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa *00");
        }
    }

    /**
     * removePelicula es un método que elimina un objeto de la clase Pelicula del ArrayList<Pelicula> del objeto Galeria
     *
     * @param posicion Int que hace referencia a la posición que queremos eliminar.
     * @author Adriandela
     */
    public void removePelicula(int posicion) {
        try {
            cartelera.remove(posicion);
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa *10");
        }
    }

    /**
     * longitudLista es un método que devuelve el tamaño de la lista.
     *
     * @return longitud: Devuelve un int con el tamaño de la lista.
     * @author Adriandela
     */
    public int longitudLista() {
        int longitud = -1;
        try {
            longitud = cartelera.size();
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa *20");
        }
        return longitud;
    }

    /**
     * mostrarArrayList es un método que recorre cada una de las posiciones de la lista imprimiendo la información que
     * contiene en cada una.
     *
     * @author Adriandela
     */
    public void mostrarArrayList() {
        try {
            for (Pelicula item : cartelera) {
                System.out.println("Título: " + item.getNombre() + "; Director: " + item.getDirector() + "; Género: " + item.getGénero());
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa *30");
        }

    }

}


