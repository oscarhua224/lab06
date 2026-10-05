package ej3;

import java.util.List;

public class InventarioVista {
    public void mostrarInventario(List<Item> items) {
        System.out.println("\n--- Inventario ---");
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item == null) {
            mostrarMensaje("No se encontró el ítem.");
            return;
        }
        System.out.println("\n--- Detalles del ítem ---");
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripción: " + item.getDescripcion());
    }
}