import java.sql.*;
import java.util.ArrayList;

public class AccionesBD {

    public static void volcarBDaLista(Galeria lista) {

        ArrayList<String> datosBusqueda = new ArrayList<String>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        String datos;

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

    public static void updateBD(Galeria lista, String sql, int posicion) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();


            sentencia.executeUpdate(sql);

            //Ejecuta la sentencia y guarda los datos en el ResultSet;
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

    public static void buscarBD(int posicion, Galeria lista, String sql) {

        ArrayList<String> datosBusqueda = new ArrayList<String>();


        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        String datos;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root", "");

            sentencia = conexion.createStatement();

            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;

            if (rs.next()) {
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
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

    public static void buscarBD(ArrayList<Integer> posiciones, Galeria lista, String sql) {
        int posicion;
        int longitudLista = posiciones.size();

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
    }

    public static void mostrarBD() {
        int posicion;

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
    }
}
