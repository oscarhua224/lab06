package ej1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {
    private final String resumen;
    private final double total;
    private final LocalDateTime fecha;

    public Compra(String resumen, double total) {
        this.resumen = resumen;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String fechaTexto = fecha.format(
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        );
        return fechaTexto + " | " + resumen
            + " | Total: S/ " + String.format("%.2f", total);
    }
}