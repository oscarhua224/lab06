package ej1;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== CARRITO DE COMPRAS ===");
        System.out.println("1. Agregar producto al catálogo");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Ver historial de compras");
        System.out.println("7. Realizar compra");
        System.out.println("0. Salir");
        return leerEntero("Elige una opción: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido");
            }
        }
    }

    public double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un precio valido");
            }
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- Catalogo ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos");
            return;
        }
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void mostrarCarrito(List<Producto> carrito,
                               double subtotal,
                               double descuento,
                               double envio,
                               double total) {
        System.out.println("\n--- Carrito ---");
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacio");
            return;
        }

        for (int i = 0; i < carrito.size(); i++) {
            System.out.println((i + 1) + ". " + carrito.get(i));
        }

        System.out.printf("Subtotal:  S/ %.2f%n", subtotal);
        System.out.printf("Descuento: S/ %.2f%n", descuento);
        System.out.printf("Envío:     S/ %.2f%n", envio);
        System.out.printf("Total:     S/ %.2f%n", total);
    }

    public void mostrarHistorial(List<Compra> historial) {
        System.out.println("\n--- Historial de compras ---");
        if (historial.isEmpty()) {
            System.out.println("Todavía no hay compras");
            return;
        }
        for (Compra compra : historial) {
            System.out.println(compra);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}