/**
 * Clase objeto que recoge la información relativa a las películas.
 */
public class Pelicula {

    private int idPelicula;
    private String nombre;

    private String director;

    private String género;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String nombre, String director, String género) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.director = director;
        this.género = género;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
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
