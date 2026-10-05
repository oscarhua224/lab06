package ej2;

public class Item {
    private final String nombre;
    private int cantidad;
    private final String tipo;
    private final String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public boolean usarItem() {
        if (cantidad <= 0) {
            return false;
        }

        cantidad--;
        return true;
    }
    @Override
    public String toString() {
        return nombre + " | Tipo: " + tipo + " | Cantidad: " + cantidad;
    }
}