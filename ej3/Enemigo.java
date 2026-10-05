package ej3;

public class Enemigo {
    private final String nombre;
    private int salud;
    private final int nivel;
    private final String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public int atacar() {
        return nivel * 3;
    }

    public void recibirDanio(int danio) {
        salud = Math.max(0, salud - danio);
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}