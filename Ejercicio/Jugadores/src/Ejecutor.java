
import java.util.ArrayList;

public class Ejecutor {

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Atacante("Pancho Juan", 10, "1234567890",
                5, 10, 15));
        jugadores.add(new Defensor("Pancho Villa", 11, "12346753",
                9, 24, 20));
        jugadores.add(new Portero("Jonathan", 1, "12097634",
                3, 50));
        for (Jugador jugador : jugadores) {
            System.out.println("jugador: " + jugador.nombre + " Dorsal: " + jugador.numeroDorsal
                    + " rut: " + jugador.rut + " Valoración: " + jugador.calcularValor());
            /*
            if (jugador instanceof Atacante) {
                Atacante atacante = (Atacante) jugador;
                System.out.println("Goles: " + atacante.goles + ", Pases: " + atacante.pases + ", Recuperaciones: " + atacante.balonesRecuperados);
            } else if (jugador instanceof Defensor) {
                Defensor defensor = (Defensor) jugador;
                System.out.println("Goles: " + defensor.goles + ", Pases: " + defensor.pases + ", Recuperaciones: " + defensor.balonesRecuperados);
            } else if (jugador instanceof Portero) {
                Portero portero = (Portero) jugador;
                System.out.println("Goles: " + portero.goles + ", Paradas: " + portero.paradas);
            }
*/
        }

    }
}

abstract class Jugador {

    String nombre;
    int numeroDorsal;
    String rut;

    public Jugador(String nombre, int numeroDorsal, String rut) {
        this.nombre = nombre;
        this.numeroDorsal = numeroDorsal;
        this.rut = rut;
    }

    // metodo abstracto 
    public abstract int calcularValor();
}

class Atacante extends Jugador {

    int goles;
    int pases;
    int balonesRecuperados;

    public Atacante(String nombre, int numeroDorsal, String rut,
            int goles, int pases, int balonesRecuperados) {
        super(nombre, numeroDorsal, rut);
        this.goles = goles;
        this.pases = pases;
        this.balonesRecuperados = balonesRecuperados;
    }

    @Override
    public int calcularValor() {
        return (goles * 30) + (pases * 2) + (balonesRecuperados * 3);
    }
}

class Defensor extends Jugador {

    int goles;
    int pases;
    int balonesRecuperados;

    public Defensor(String nombre, int numeroDorsal, String rut,
            int goles, int pases, int balonesRecuperados) {
        super(nombre, numeroDorsal, rut);
        this.goles = goles;
        this.pases = pases;
        this.balonesRecuperados = balonesRecuperados;
    }

    @Override
    public int calcularValor() {
        return goles + pases + (balonesRecuperados * 4);
    }
}

class Portero extends Jugador {

    int goles;
    int paradas;

    public Portero(String nombre, int numeroDorsal, String rut,
            int goles, int paradas) {
        super(nombre, numeroDorsal, rut);
        this.goles = goles;
        this.paradas = paradas;
    }

    @Override
    public int calcularValor() {
        return goles + (paradas * 5);
    }
}
