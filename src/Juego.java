import java.util.Random;
import java.util.Scanner;

public class Juego {
    private char[][] tablero;

    private Jugador jugador1;

    private Jugador jugador2;

    private Boolean esJegoContraPC = Boolean.FALSE;

    private Scanner sc;

    public Juego(Scanner sc) {
        this.sc = sc;
    }

    public void iniciarJuego() {
        cargarDatos();
        cargarJugador();
        iniciarTablero();
        correrJuego();
        finalizarJuego();
        finalizarJuego();
    }

    public void finalizarJuego() {
        System.out.println("*** JUEGO FINALIZADO ***");
        return;
    }

    public void cargarDatos() {
        System.out.println("*** BIENVENIDOS AL DESOXIDANTE TA-TE-TI ***");
        System.out.println(" - Elija una opcion: \n Jugar contra la PC: ('1') \n Contra otro Jugador: ('2') \n Salir: (Q)");
        char opcion = getSc().next().charAt(0);
        if (opcion != '1' && opcion != '2') {
            finalizarJuego();
        }
        if (opcion == '1') {
            esJegoContraPC = Boolean.TRUE;
        }
    }

    public void correrJuego() {
        Boolean hayGanador = Boolean.FALSE;
        while (!hayGanador) {
            cargarJugada(jugador1);
            dibujaTablero();
            if (verificarGanador()) {
                System.out.println("*** El Ganador es: "+jugador1.getNombre()+ "***");
            }
            cargarJugada(jugador2);
            dibujaTablero();
            if (verificarGanador()) {
                System.out.println("*** El Ganador es: "+jugador2.getNombre()+ "***");
            }
        }
    }

    private void iniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    private void dibujaTablero() {
        System.out.println(" ");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private void cargarJugador() {
        System.out.println("Ingrese el Nombre del Jugador: ");
        jugador1.setNombre(sc.nextLine());
        if (!esJegoContraPC) {
            System.out.println("Ingrese el Nombre del 2do Jugador: ");
            jugador2.setNombre(sc.nextLine());
        } else {
            jugador2.setNombre("PC");
        }
        jugador1.setFicha(Ficha.X);
        jugador2.setFicha(Ficha.O);
        jugador2.setEsPC(esJegoContraPC);
    }

    private int getPosicionX() {
        int x;
        do {
            System.out.println("Cargue una cordenada del 1 al 3");
            System.out.println("Ingrese Fila: ");
            x = sc.nextInt() - 1;
        } while (x >= tablero.length);
        return x;
    }

    private int getPosicionY() {
        int y;
        do {
            System.out.println("Cargue una cordenada del 1 al 3");
            System.out.println("Ingrese Columna: ");
            y = sc.nextInt() - 1;
        } while (y >= tablero.length);
        return y;
    }

    private int getRandomPosition() {
        Random ran = new Random();
        int n = ran.nextInt(2) + 0;
        return n;
    }

    private void cargarJugada(Jugador jugador) {
        boolean posicionLibre;
        int f, c;
        do {
            if (!jugador.isEsPC()) {
                f = getPosicionX();
                c = getPosicionY();
            } else {
                f = getRandomPosition();
                c = getRandomPosition();
            }
            if (tablero[f][c] == '_') {
                tablero[f][c] = jugador.getFicha().getSimbolo();
                posicionLibre = true;
            } else {
                posicionLibre = false;
                System.out.println("Posición Ocupada:");
            }
        } while (!posicionLibre);
    }

    private boolean esPosicionVacia(int x, int y) {
        return true;
    }

    private boolean verificarGanador() {
        if ((tablero[0][0] != '_') && (tablero[0][0] == tablero[0][1]) && (tablero[0][1] == tablero[0][2])) {
            return (true);
        }
        if ((tablero[1][0] != '_') && (tablero[1][0] == tablero[1][1]) && (tablero[1][1] == tablero[1][2])) {
            return (true);
        }
        if ((tablero[2][0] != '_') && (tablero[2][0] == tablero[2][1]) && (tablero[2][1] == tablero[2][2])) {
            return (true);
        }
        if ((tablero[0][0] != '_') && (tablero[0][0] == tablero[1][0]) && (tablero[1][0] == tablero[2][0])) {
            return (true);
        }
        if ((tablero[0][1] != '_') && (tablero[0][1] == tablero[1][1]) && (tablero[1][1] == tablero[2][1])) {
            return (true);
        }
        if ((tablero[0][2] != '_') && (tablero[0][2] == tablero[1][2]) && (tablero[1][2] == tablero[2][2])) {
            return (true);
        }
        if ((tablero[0][0] != '_') && (tablero[0][0] == tablero[1][1]) && (tablero[1][1] == tablero[2][2])) {
            return (true);
        }
        if ((tablero[2][0] != '_') && (tablero[2][0] == tablero[1][1]) && (tablero[1][1] == tablero[0][2])) {
            return (true);
        }
        return (false);
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Boolean getEsJegoContraPC() {
        return esJegoContraPC;
    }

    public Scanner getSc() {
        return sc;
    }
}
