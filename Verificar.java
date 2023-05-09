/**
 * Verificar es la clase que contiene los métodos que arroja información para saber si se cumplen las condiciones que le indicamos.
 *
 * @author Adriandela
 */
public class Verificar {
    //€

    /**
     * verificarInt es un método estático que comprueba si el número que le aportamos está dentro del rango de valores que le definimos.
     *
     * @param minimo int que recoge el límite inferior del rango, este incluido.
     * @param maximo int que recoge el límite superior del rango, este incluido.
     * @param numero int que recoge el número a evaluar.
     * @return correcto: Un valor booleano que es true si el número se encuentra dentro del rango y false si no lo está.
     * @author Adriandela
     */

    public static boolean verificarInt(int minimo, int maximo, int numero) {
        boolean correcto = false;
        try {
            if (numero >= minimo && numero <= maximo) {
                correcto = true;
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un problema, con la verificación €00");
        }
        return correcto;
    }

    /**
     * verificarListVacia es un método estático que comprueba si el ArrayList tiene contenido o está vacío.
     *
     * @param lista Objeto de la clase Galeria que alberga un ArrayList<Pelicula>.
     * @return vacio: Un valor booleano que es true si la lista no contiene ningún item y falso si contiene alguno.
     * @author Adriandela
     */
    public static boolean verificarListVacia(Galeria lista) {
        int longitud = lista.longitudLista();
        boolean vacio = false;

        try {
            if (longitud <= 0) {
                vacio = true;
            }
        } catch (Exception e) {
            System.out.println("Lo sentimos hemos tenido un error en el programa €10");
        }
        return vacio;
    }
}
