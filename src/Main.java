import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManejadorArchivos manejador = new ManejadorArchivos("ejemplo.txt");
        int opcion;

        do {
            System.out.println("\n*** MENÚ ***");
            System.out.println("1) Crear archivo de texto");
            System.out.println("2) Eliminar archivo de texto");
            System.out.println("3) Escribir al archivo de texto");
            System.out.println("4) Leer archivo de texto");
            System.out.println("9) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    manejador.crearArchivo();
                    break;
                case 2:
                    manejador.eliminarArchivo();
                    break;
                case 3:
                    System.out.print("Ingrese el texto a escribir en el archivo: ");
                    String texto = scanner.nextLine();
                    manejador.escribirArchivo(texto);
                    break;
                case 4:
                    System.out.println("Contenido del archivo:");
                    manejador.leerArchivo();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}