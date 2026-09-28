import java.util.Scanner;

/**
 * Clase Main - interfaz de consola de "Tree-Stock".
 * Solo se encarga de mostrar el menu y pedir datos al usuario;
 * toda la logica real vive en ArbolInventario.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        do {
            System.out.println("\n===== TREE-STOCK: Sistema de Inventario =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            // Validamos que el usuario escriba un numero
            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida. Ingrese un numero: ");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("ID invalido. Ingrese un numero: ");
                        sc.next();
                    }
                    int id = sc.nextInt();
                    sc.nextLine(); // limpiar el salto de linea pendiente
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();

                    inventario.insertar(id, nombre);
                    System.out.println(">> Producto registrado (si el ID no existia).");
                    break;

                case 2:
                    inventario.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("ID invalido. Ingrese un numero: ");
                        sc.next();
                    }
                    int idBuscado = sc.nextInt();

                    Producto encontrado = inventario.buscar(idBuscado);
                    if (encontrado != null) {
                        System.out.println(">> Producto encontrado -> " + encontrado);
                    } else {
                        System.out.println(">> No existe ningun producto con el ID " + idBuscado);
                    }
                    break;

                case 0:
                    System.out.println("Cerrando Tree-Stock. Hasta luego!");
                    break;

                default:
                    System.out.println(">> Opcion no valida, intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
