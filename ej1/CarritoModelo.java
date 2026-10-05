package ej1;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private final List<Producto> productos = new ArrayList<>();
    private final List<Producto> carrito = new ArrayList<>();
    private final List<Compra> historial = new ArrayList<>();
    private int siguienteId = 1;

    public CarritoModelo() {
        agregarProducto("Cuaderno", 8.50);
        agregarProducto("Mochila", 75.00);
        agregarProducto("Lapicero", 2.00);
    }

    public void agregarProducto(String nombre, double precio) {
        productos.add(new Producto(siguienteId++, nombre, precio));
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public List<Producto> getCarrito() {
        return new ArrayList<>(carrito);
    }

    public List<Compra> getHistorial() {
        return new ArrayList<>(historial);
    }

    public Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public boolean agregarAlCarrito(int id) {
        Producto producto = buscarProducto(id);
        if (producto == null) {
            return false;
        }
        carrito.add(producto);
        return true;
    }

    public boolean eliminarDelCarrito(int numero) {
        if (numero < 1 || numero > carrito.size()) {
            return false;
        }
        carrito.remove(numero - 1);
        return true;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : carrito) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public double calcularDescuento() {
        int bloquesDeCien = (int) (calcularSubtotal() / 100);
        double porcentaje = Math.min(bloquesDeCien * 0.05, 0.20);
        return calcularSubtotal() * porcentaje;
    }

    public double calcularEnvio() {
        double totalConDescuento = calcularSubtotal() - calcularDescuento();
        return totalConDescuento >= 200 ? 0 : 10;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularEnvio();
    }

    public boolean realizarCompra() {
        if (carrito.isEmpty()) {
            return false;
        }

        StringBuilder resumen = new StringBuilder();
        for (Producto producto : carrito) {
            if (resumen.length() > 0) {
                resumen.append(", ");
            }
            resumen.append(producto.getNombre());
        }

        historial.add(new Compra(resumen.toString(), calcularTotal()));
        carrito.clear();
        return true;
    }
}