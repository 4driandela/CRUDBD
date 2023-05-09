import java.util.Scanner;

/**
 * Herramientas contiene métodos útiles que pueden aprovechar el resto de clases.
 *
 * @author Adriandela
 */
public class Herramientas {
    //#

    /**
     * pedirInt es un método estático que recoge por teclado un número y lo devuelve ese número entero.
     *
     * @param texto String que recoge la frase que mostrará por pantalla el método.
     * @return numero: Int que devuelve el número introducido por teclado.
     * @author Adriandela
     */
    public static int pedirInt(String texto) {
        int numero = 0;
        try {
            System.out.println(texto);
            Scanner lector = new Scanner(System.in);
            numero = lector.nextInt();
            lector.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Hemos tenido un error con la elección, por favor vuelva a introducir el número #00");
        } catch (Exception e) {
            System.out.println("Hemos tenido un error con la elección, por favor vuelva a introducir el número #01");
        }
        return numero;
    }

    /**
     * pedirString es un método estático que recoge por teclado una cadena de texto(String) y la devuelve posteriormente.
     *
     * @param texto String que recoge la frase que mostrará por pantalla el método
     * @return palabra: String que recoge la palabra introducida por teclado.
     * @author Adriandela
     */
    public static String pedirString(String texto) {
        String palabra = "";
        try {
            System.out.println(texto);
            Scanner lector = new Scanner(System.in);
            palabra = lector.nextLine();

        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa #10");
        }
        return palabra;
    }

    /**
     * convertirAMinus es un método estático que convierte a minúsculas todas las letras que contiene la cadena y la devuelve posteriormente.
     *
     * @param palabra String que contiene la palabra a convertir a minúsculas
     * @return minus: String convertido a minúsculas.
     * @author Adriandela
     */
    public static String convertirAMinus(String palabra) {
        //No es requerido, pero me ayuda a la hora buscar las palabras al no tener que distinguir Mayus de Minus.
        String minus = "";
        try {
            minus = palabra.toLowerCase();

        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa #20");
        }
        return minus;
    }

}
