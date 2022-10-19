package src.org.sfsoft.carreracoches;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void lanzador(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        do {

            System.out.println("1. Opcion de N Caballos");
            System.out.println("2. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        Carrera.correr(args);
                        break;
                    case 2:
                        salir = true;
                        System.out.println("Gracias por utilizar nuestro código");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 2");
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
            }
            sn.close();
        }while(sn.nextInt()!=2);

    }

}