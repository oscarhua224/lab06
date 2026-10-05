package ej3;

import java.util.List;

public class Jugador {
    private final String nombre;
    private int salud;
    private int nivel;
    private final List<Item> inventario;
    private Item objetoEquipado;

    public Jugador(String nombre, int salud, int nivel, List<Item> inventario) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public Item getObjetoEquipado() {
        return objetoEquipado;
    }

    public void equipar(Item item) {
        if (item != null && "Arma".equalsIgnoreCase(item.getTipo())) {
            objetoEquipado = item;
        }
    }

    public int atacar() {
        if (objetoEquipado == null) {
            return 0;
        }
        return nivel * 5;
    }

    public boolean usarObjeto(String nombreObjeto) {
        for (Item item : inventario) {
            if (item.getNombre().equalsIgnoreCase(nombreObjeto)
                    && item.usarItem()) {
                return true;
            }
        }
        return false;
    }

    public void recibirDanio(int danio) {
        salud = Math.max(0, salud - danio);
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}