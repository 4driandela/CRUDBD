import java.sql.*;
import java.util.ArrayList;

/**
 * AccionesBD es la clase que contiene los métodos que manipulan la base de datos,
 */
public class AccionesBD {
    /**
     * volcarBDaLista es un método estático que recibe todos los datos almacenados en la base de datos y los introduce
     * en un ArrayList<Pelicula>
     *
     * @param lista arrayList<Pelicula> que almacena objetos de la clase Pelicula.
     * @author Adriandela
     */
    public static void volcarBDaLista(Galeria lista) {
        ArrayList<String> datosBusqueda = new ArrayList<String>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("select * from peliculas"); //Ejecuta la sentencia y guarda los datos en el ResultSet;

            while (rs.next()) {
                lista.addPelicula(new Pelicula((rs.getInt(1)), (rs.getString(2)), (rs.getString(3)), (rs.getString(4))));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * borrarBD es un método estático que borra una posición dentro de la base de datos.
     *
     * @param posicion int que guarda la posición que se quiere borrar
     * @param sql      String que guarda la sentencia sql a ejecutar
     * @author Adriandela
     */
    public static void borrarBD(int posicion, String sql) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * borrarBD es un método estático que borra una posición dentro de la base de datos.
     *
     * @param sql String que guarda la sentencia sql a ejecutar
     * @author Adriandela
     */
    public static void borrarBD(String sql) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * modificarBD es un método estático que a través de la posición proporcionada modifica en la base de datos el registro
     * que tenga el mismo valor en idPelicula, sustituyendo el nuevo dato por el antiguo.
     *
     * @param posicion int que guarda la posición que se quiere modificar
     * @param newDato  String que guarda el nuevo valor
     * @param sql      String que guarda la sentencia sql a ejecutar
     */
    public static void modificarBD(int posicion, String newDato, String sql) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * updateBD es un método estático que vuelca el contenido de la lista a la base de datos, proporcionado un nuevo
     * idPelicula que comienza en 1 para el primer registro y que va aumentando en 1 para el resto de registros.
     *
     * @param lista    arrayList<Pelicula> que almacena objetos de la clase Pelicula.
     * @param sql      String que guarda la sentencia sql a ejecutar
     * @param posicion int que guarda el nuevo valor para idPelicula en la base de datos
     */
    public static void updateBD(Galeria lista, String sql, int posicion) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * modificarTodoBD es un método estático que a través de la posición proporcionada modifica en la base de datos el registro
     * que tenga el mismo valor en idPelicula, sustituyendo cada uno de los antiguos valores por los nuevos.
     *
     * @param posicion    int que guarda la posición que se quiere modificar
     * @param newTitulo   String que guarda el nuevo valor para título
     * @param newDirector String que guarda el nuevo valor para director
     * @param newGenero   String que guarda el nuevo valor para género
     * @param sql         String que guarda la sentencia sql a ejecutar
     */
    public static void modificarTodoBD(int posicion, String newTitulo, String newDirector, String newGenero, String sql) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * insertarBD es un método estático que inserta un nuevo registro dentro de la base de datos
     *
     * @param posicion int que guarda el valor para idPelicula y el elemento a seleccionar dentro de la lista
     * @param lista    arrayList<Pelicula> que almacena objetos de la clase Pelicula
     * @param sql      String que guarda la sentencia sql a ejecutar
     */
    public static void insertarBD(int posicion, Galeria lista, String sql) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();

            sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * buscarBD es un método estático que busca e imprime por pantalla la posición que le pasamos como parámetro,
     * si encuentra el dato devuelve un true
     *
     * @param posicion int que guarda la posición que se quiere buscar dentro de la base de datos
     * @param sql      String que guarda la sentencia sql a ejecutar
     * @return encontrado Valor booleano que es true si ha encontrado el registro y false si no lo encuentra
     */
    public static boolean buscarBD(int posicion, String sql) {
        ArrayList<String> datosBusqueda = new ArrayList<String>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        String datos;
        boolean encontrado = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();

            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;

            if (rs.next()) {
                encontrado = true;
                System.out.println("Titulo: " + rs.getString(2) + ", Director: " + (rs.getString(3) + ", Género: " + rs.getString(4)));

            } else {
                encontrado = false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return encontrado;
    }

    /**
     * buscarBD es un método estático que busca e imprime por pantalla las posiciones que alberga el arrayList<Integer>posiciones
     * si encuentra alguno de los datos devuelve un true
     *
     * @param posiciones ArrayList<Integer> que almacena las posiciones que debe buscar el método
     * @param sql        String que guarda la sentencia sql a ejecutar
     * @return encontrado Valor booleano que es true si ha encontrado alguno de los registros y false si no encuentra
     */
    public static boolean buscarBD(ArrayList<Integer> posiciones, String sql) {
        int posicion;
        int longitudLista = posiciones.size();
        boolean encontrado = false;

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        String datos;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();

            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            for (int i = 1; i <= longitudLista; i++) {
                posicion = posiciones.get(i - 1);
                sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'";
                rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
                if (rs.next()) {
                    encontrado = true;
                    System.out.println("Titulo: " + rs.getString(2) + ", Director: " + (rs.getString(3) + ", Género: " + rs.getString(4)));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return encontrado;
    }

    /**
     * mostrarBD es un método estático que imprimer por pantalla todos los registros de la base de datos
     *
     * @return activado Valor booleano que es true si ha impreso algún valor y false si no la hecho
     */
    public static boolean mostrarBD() {
        int posicion;
        boolean activado = false;

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        int i = 1;
        String sql;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();
            sql = "select * from peliculas";
            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;

            while (rs.next()) {
                activado = true;
                System.out.println("BD Titulo: " + rs.getString(2) + ", Director: " + (rs.getString(3) + ", Género: " + rs.getString(4)));
                i++;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return activado;
    }
}
