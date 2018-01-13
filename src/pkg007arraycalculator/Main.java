package pkg007arraycalculator;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static int respuesta;
    static String repeticion;
    static double media = 0;
    static double max = 0;
    static double min = 0;

    static ArrayList <Double> precios = new ArrayList();
    //Para las ArrayList se necesitan clases envoltorio, por eso en el tipo de ArrayList pongo Double en vez de double


    public static void main(String[] args) {

        do {
            System.out.println("Por favor, elija una opción");
            System.out.println("1) Añadir nuevo precio");
            System.out.println("2) Averiguar precio medio");
            System.out.println("3) Averiguar precio máximo");
            System.out.println("4) Averiguar precio mínimo");
            System.out.println("5) Mostrar todos los precios");
            System.out.println("0) Salir");
            respuesta = sc.nextInt();


            switch (respuesta) {
                case 0:
                    System.out.println("Has pulsado la tecla 0");
                    break;

                case 1:
                    System.out.println("");
                    System.out.println("Usted ha elegido la opción: " + respuesta + "\n");
                    addPrecio();
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("Usted ha elegido la opción: " + respuesta + "\n");
                    medPrecio();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Usted ha elegido la opción: " + respuesta + "\n");
                    maxPrecio();
                    System.out.println("El mayor número de la lista es: " + max + " € \n");
                    max = 0;
                    /*Inicializamos a 0 pues si no volvera a dar un error en la operación*/
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Usted ha elegido la opción: " + respuesta + "\n");
                    minPrecio();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Usted ha elegido la opción: " + respuesta + "\n");
                    verPrecio();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Usted no ha elegido una opción validad");
                    System.out.println("");
            }
        } while (respuesta != 0); {
            System.out.println("Gracias, esperamos haberle sido de ayuda");
        }


    }

    public static void addPrecio () {

        do {
            System.out.println("Por favor, añada, un nuevo precio");
            System.out.print("Nuevo precio: ");
            precios.add(sc.nextDouble());
            System.out.println("\n" + precios + "€ han sido ingresados" + "\n");

            System.out.print("¿Desea añadir otro más? (S/N)");
            repeticion = sc.next();
        } while(repeticion.equalsIgnoreCase("s")); {
            System.out.println("");
        }


    }

    public static void medPrecio () {
        if (precios.size() == 0) {
            /*Ponemos un IF en caso de que no existán elementos con los que hacer la media, y además iniciamos automaticamente
            * el metodo de añadir precio*/
            System.out.println("No tiene ningún precio añadido a su lista");
            addPrecio();
        }

        for (int i=0; i<precios.size(); i++) {
            media = media + precios.get(i);
            /*La media es la suma de todos los elementos y la división del numero total de los mismos
            * para ello hemos hecho un bucle que sirva para seleccionar la posición de cada elemento (i)
            * y una variable que guarde la suma de cada uno de los elementos.*/
        }

        media = media / precios.size();
        /*Dicha suma se dividira entre el numero de elementos totales de la lista*/
        System.out.println("La media de todos los precios guardados es de: " + media);
        media = 0;
        System.out.println("");
        /*Igualamos la media a 0 despues de dar el resultado pues si no lo hacemos al volver a repetir el bucle
        * tendrá el resultado anterior dando una media erronea*/

    }

    public static void maxPrecio () {
        if (precios.size() == 0) {
            System.out.println("No tiene ningún precio añadido a su lista");
            addPrecio();
        }

        for (int i = 0; i < precios.size(); i++) {
            if (precios.get(i) > max) {
                max = precios.get(i);

            /*Esta idea la cogi de mi compañero Sergio
            * Queremos seleccionar de los elementos de la lista, el número mas alto
            * Para ello recorremos un Array con un for como hemos hecho siempre, pero en esta ocasión
            * declaramos una condición (If) que se activara si el número anterior es mayor que el siguiente número
            * si se cumple esa condición, dicho numero sera guardada como variable y servira para realizar la siguiente
            * comprobación*/
            }
        }

        //System.out.println("El mayor número de la lista es: " + max + " €");
        /*Como el metodo sera usado en otros metodos, es mejor mover esta información al main*/
        min = max;
        /*Guardamos el valor del numero mas alto de la lista como el valor minimo para que mas adelante en el metodo
        * minPrecio nos ayude a averiguar cual es el valor mas bajo*/


    }

    public static void minPrecio() {
        maxPrecio();
        /*Obtenemos como referencia el precio máximo para que sirva de referencia como minimo*/
        for (int i = 0; i<precios.size(); i++) {
            if (min > precios.get(i)) {
                min = precios.get(i);
                /*Queremos saber el precio minimo, pero para ello necesitamos inicializar la variable min con un valor.
                * si ese valor es mayor que el numero siguiente de la lista, entonces lo guardara como nuevo valor.
                * Inicialmente no podemos poner 0 como valor del min como hemos hecho con otras variables
                * pues entonces siempre daria 0 como valor minimo, hay que saber primero cual es el valor maximo */
            }

        }

        System.out.println("El menor precio de la lista es: " + min + "\n");
    }

    public static void verPrecio() {
        if (precios.size() == 0) {
            System.out.println("No tiene ningún precio añadido a su lista");
            addPrecio();
        }
        System.out.println("Estas es la lista de tus precios: ");
        for (int i = 0; i<precios.size(); i++) {
         System.out.println(precios.get(i) + " €");
        }
        System.out.println("");
    }
}