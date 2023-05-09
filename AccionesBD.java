import java.sql.*;
import java.util.ArrayList;
public class AccionesBD {

        public static void volcarBDaLista(Galeria lista){

            ArrayList<String> datosBusqueda = new ArrayList<String>();


            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String datos;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();

                rs = sentencia.executeQuery("select * from peliculas"); //Ejecuta la sentencia y guarda los datos en el ResultSet;

                while(rs.next()){
                    lista.addPelicula(new Pelicula((rs.getInt(1)),(rs.getString(2)),(rs.getString(3)),(rs.getString(4))));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


        public static void modificarTitulo(String titulo, String newTitulo){
            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String sql;

            sql = "update peliculas set titulo = " + "'" + newTitulo + "'" + " where titulo = " + "'" + titulo + "'";


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        public static void modificarDirector(String titulo, String newDirector){
            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String sql;

            sql = "update peliculas set director = " + "'" + newDirector + "'" + " where titulo = " + "'" + titulo + "'";


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        public static void modificarGenero(String titulo, String newGenero){
            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String sql;

            sql = "update peliculas set genero = " + "'" + newGenero + "'" + " where titulo = " + "'" + titulo + "'";


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }public static void modificarTodo(String titulo, String newTitulo, String newDirector, String newGenero){
            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String sql;

            sql = "update peliculas set titulo = " + "'" + newTitulo + "'" +", set Director = " + "'" + newDirector + "'" +", set Genero = " + "'" + newGenero + "'" + " where titulo = " + "'" + titulo + "'";


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        public static void insertarBD(int posicion, Galeria lista, String sql){
            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();

                sentencia.executeUpdate(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        public static void buscarTitulo(String titulo) {



            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String datos;


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();

                rs = sentencia.executeQuery("select * from peliculas where titulo like " + "'" +titulo+ "'"); //Ejecuta la sentencia y guarda los datos en el ResultSet;

                if(rs.next()){
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
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


            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String datos;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();

                rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;

                if(rs.next()){
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
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


        Connection conexion=null;
        Statement sentencia = null;
        ResultSet rs = null;
        String datos;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

            sentencia = conexion.createStatement();

            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
        for(int i = 0; i < longitudLista; i++) {
            posicion = posiciones.get(i);
            sql = "select * from peliculas where idPelicula = " + "'" + posicion + "'" ;
            rs = sentencia.executeQuery(sql); //Ejecuta la sentencia y guarda los datos en el ResultSet;
            if (rs.next()) {
                System.out.println("Titulo: "+rs.getString(2)+", Director: "+(rs.getString(3)+", Género: " + rs.getString(4)));
            }
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

        /**
         * buscarDirector es un método estático que recorre el ArrayList en busca de coincidencias con el String director.
         *
         *
         * @param director String que recoge la palabra que se buscará en la lista.
         * @return encontrado: Boolean que es true si hay coincidencias o false si no la hay.
         * @author Adriandela
         */
        public static void buscarDirector(String director) {

            ArrayList<String> datosBusqueda = new ArrayList<String>();


            Connection conexion=null;
            Statement sentencia = null;
            ResultSet rs = null;
            String datos;


            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/crud bd", "root","");

                sentencia = conexion.createStatement();

                rs = sentencia.executeQuery("select * from peliculas where director like " + "'" +director+ "'"); //Ejecuta la sentencia y guarda los datos en el ResultSet;

                if(rs.next()){
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }
