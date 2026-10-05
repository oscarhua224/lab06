package ej1;

public class CarritoControlador {
    private final CarritoModelo modelo;
    private final CarritoVista vista;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    agregarProductoAlCatalogo();
                    break;
                case 2:
                    vista.mostrarProductos(modelo.getProductos());
                    break;
                case 3:
                    agregarProductoAlCarrito();
                    break;
                case 4:
                    mostrarCarrito();
                    break;
                case 5:
                    eliminarProductoDelCarrito();
                    break;
                case 6:
                    vista.mostrarHistorial(modelo.getHistorial());
                    break;
                case 7:
                    realizarCompra();
                    break;
                case 0:
                    vista.mostrarMensaje("Hasta luego");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 0);
    }

    private void agregarProductoAlCatalogo() {
        String nombre = vista.leerTexto("Nombre del producto: ");
        double precio = vista.leerDecimal("Precio: S/ ");
        if (nombre.trim().isEmpty() || precio <= 0) {
            vista.mostrarMensaje("Nombre o precio no valido");
            return;
        }
        modelo.agregarProducto(nombre, precio);
        vista.mostrarMensaje("Producto agregado al catalogo.");
    }

    private void agregarProductoAlCarrito() {
        vista.mostrarProductos(modelo.getProductos());
        int id = vista.leerEntero("ID del producto que agregarás: ");

        if (modelo.agregarAlCarrito(id)) {
            vista.mostrarMensaje("Producto agregado al carrito.");
        } else {
            vista.mostrarMensaje("No existe un producto con ese ID.");
        }
    }

    private void mostrarCarrito() {
        vista.mostrarCarrito(
            modelo.getCarrito(),
            modelo.calcularSubtotal(),
            modelo.calcularDescuento(),
            modelo.calcularEnvio(),
            modelo.calcularTotal()
        );
    }

    private void eliminarProductoDelCarrito() {
        mostrarCarrito();
        if (modelo.getCarrito().isEmpty()) {
            return;
        }

        int numero = vista.leerEntero("Número del producto que eliminarás: ");
        if (modelo.eliminarDelCarrito(numero)) {
            vista.mostrarMensaje("Producto eliminado.");
        } else {
            vista.mostrarMensaje("Número de producto no válido.");
        }
    }

    private void realizarCompra() {
        mostrarCarrito();
        if (modelo.realizarCompra()) {
            vista.mostrarMensaje("Compra realizada. Se guardó en el historial.");
        } else {
            vista.mostrarMensaje("Agrega productos antes de comprar.");
        }
    }
}