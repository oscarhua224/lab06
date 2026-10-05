package ej2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioModelo modelo = new InventarioModelo();
        InventarioVista vista = new InventarioVista();
        InventarioControlador controlador = new InventarioControlador(modelo, vista);

        controlador.agregarItem(
            new Item("Espada", 3, "Arma", "Una espada de acero.")
        );
        controlador.agregarItem(
            new Item("Poción", 5, "Consumible", "Recupera energía.")
        );

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Agregar ítem");
            System.out.println("2. Ver inventario");
            System.out.println("3. Buscar y ver detalles");
            System.out.println("4. Eliminar ítem");
            System.out.println("5. Usar ítem");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingresa un número: ");
                scanner.nextLine();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cantidad: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ingresa una cantidad entera: ");
                        scanner.nextLine();
                    }
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();

                    controlador.agregarItem(
                        new Item(nombre, cantidad, tipo, descripcion)
                    );
                    break;

                case 2:
                    controlador.verInventario();
                    break;

                case 3:
                    System.out.print("Nombre del ítem: ");
                    controlador.mostrarDetalles(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("Nombre del ítem a eliminar: ");
                    controlador.eliminarItem(scanner.nextLine());
                    break;

                case 5:
                    System.out.print("Nombre del ítem que usarás: ");
                    controlador.usarItem(scanner.nextLine());
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}