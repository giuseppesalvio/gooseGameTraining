package domain;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;

public class Board {


    public static int prossimoTurno(int numeroGiocatori, int turno) {
        return turno + 1 > numeroGiocatori ? 0 : turno + 1;
    }

    public static int getNumeroGiocatori(List<Giocatore> listaGiocatori) {
        return listaGiocatori.size() - 1;
    }
}
