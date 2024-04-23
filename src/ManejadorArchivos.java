import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManejadorArchivos {
    private File archivo;

    public ManejadorArchivos(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    public void crearArchivo() {
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    public void escribirArchivo(String contenido) {
        try (FileWriter escritor = new FileWriter(archivo, true)) {
            escritor.write(contenido + "\n");
            System.out.println("Contenido escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo.");
            e.printStackTrace();
        }
    }

    public void eliminarArchivo() {
        if (archivo.delete()) {
            System.out.println("Archivo eliminado: " + archivo.getName());
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }
    }
}