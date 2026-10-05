package ej3;

import java.util.Random;

public class CombateControlador {
    private final Jugador jugador;
    private final Enemigo enemigo;
    private final CombateVista vista;
    private final Random random = new Random();

    public CombateControlador(
            Jugador jugador,
            Enemigo enemigo,
            CombateVista vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("El combate comienza");

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstado(jugador, enemigo);
            turnoJugador();

            if (!enemigo.estaVivo()) {
                break;
            }

            turnoEnemigo();
        }

        vista.mostrarEstado(jugador, enemigo);

        if (jugador.estaVivo()) {
            vista.mostrarMensaje("¡" + jugador.getNombre() + " ganó!");
        } else {
            vista.mostrarMensaje("El enemigo ganó. " + jugador.getNombre()
                    + " fue derrotado.");
        }
    }

    private void turnoJugador() {
        int danio = jugador.atacar();

        if (danio == 0) {
            vista.mostrarMensaje("No tienes un arma equipada y no puedes atacar.");
            return;
        }

        enemigo.recibirDanio(danio);
        vista.mostrarMensaje(jugador.getNombre() + " ataca con "
                + jugador.getObjetoEquipado().getNombre()
                + " e inflige " + danio + " de daño.");
    }

    private void turnoEnemigo() {
        int accion = random.nextInt(2);

        if (accion == 0) {
            int danio = enemigo.atacar();
            jugador.recibirDanio(danio);
            vista.mostrarMensaje(enemigo.getNombre()
                    + " ataca e inflige " + danio + " de daño.");
        } else {
            vista.mostrarMensaje(enemigo.getNombre() + " descansa este turno.");
        }
    }
}