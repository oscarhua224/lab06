package ej3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> inventarioJugador = new ArrayList<>();

        Item espada = new Item("Espada", 1, "Arma", "Una espada de acero.");
        Item pocion = new Item("Poción", 2, "Consumible", "Una poción.");

        inventarioJugador.add(espada);
        inventarioJugador.add(pocion);

        Jugador jugador = new Jugador(
            "Aventurero", 100, 2, inventarioJugador
        );
        jugador.equipar(espada);

        Enemigo enemigo = new Enemigo("Duende", 50, 2, "Monstruo");

        CombateVista vistaCombate = new CombateVista();
        CombateControlador combate = new CombateControlador(
            jugador, enemigo, vistaCombate
        );

        combate.iniciarCombate();
    }
}