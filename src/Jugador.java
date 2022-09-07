public class Jugador {
    private String nombre;

    private Ficha ficha;

    private boolean esPC;

    Jugador(String nombre, Ficha ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public boolean isEsPC() {
        return esPC;
    }

    public void setEsPC(boolean esPC) {
        this.esPC = esPC;
    }
}
