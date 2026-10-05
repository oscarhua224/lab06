package ej3;

public class CombateVista {
    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n--- Estado del combate ---");
        System.out.println(jugador.getNombre() + " - Salud: " + jugador.getSalud());
        System.out.println(enemigo.getNombre() + " - Salud: " + enemigo.getSalud());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}