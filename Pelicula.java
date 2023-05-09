/**
 * Clase objeto que recoge la información relativa a las películas.
 */
public class Pelicula {

    private String nombre;

    private String director;

    private String género;

    public Pelicula() {
    }

    public Pelicula(String nombre, String director, String género) {
        this.nombre = nombre;
        this.director = director;
        this.género = género;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGénero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", género='" + género + '\'' +
                '}';
    }
}
