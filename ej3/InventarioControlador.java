package ej3;

public class InventarioControlador {
    private final InventarioModelo modelo;
    private final InventarioVista vista;

    public InventarioControlador(InventarioModelo modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        if (item.getNombre().trim().isEmpty() || item.getCantidad() < 0) {
            vista.mostrarMensaje("El nombre o la cantidad no son válidos.");
            return;
        }

        modelo.agregarItem(item);
        vista.mostrarMensaje("Ítem agregado al inventario.");
    }

    public void eliminarItem(String nombre) {
        Item item = buscarItem(nombre);

        if (item == null) {
            vista.mostrarMensaje("No se encontró el ítem que quieres eliminar.");
            return;
        }

        modelo.eliminarItem(item);
        vista.mostrarMensaje("Ítem eliminado del inventario");
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public Item buscarItem(String nombre) {
        return modelo.buscarItem(nombre);
    }

    public void usarItem(String nombre) {
        Item item = buscarItem(nombre);

        if (item == null) {
            vista.mostrarMensaje("No se encontró el ítem.");
        } else if (item.usarItem()) {
            vista.mostrarMensaje("Usaste una unidad de " + item.getNombre() + ".");
        } else {
            vista.mostrarMensaje("No quedan unidades de " + item.getNombre() + ".");
        }
    }
}