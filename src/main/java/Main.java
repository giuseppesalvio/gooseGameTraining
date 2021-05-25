import domain.Board;
import domain.Giocatore;

import java.util.List;
import java.util.Random;

import static domain.Board.getNumeroGiocatori;
import static domain.Board.prossimoTurno;
import static domain.Giocatore.*;

public class Main {

    public static
    void main(String[] args)
    {
        List<Giocatore> listaGiocatori = creazioneGiocatori();

        int numeroGiocatori = getNumeroGiocatori(listaGiocatori);
        int turno = new Random().nextInt(getNumeroGiocatori(listaGiocatori)) ;

        while(isFlagGiocoFinito(listaGiocatori)){
            giocatoreAvanza(listaGiocatori, turno);
            turno = prossimoTurno(numeroGiocatori, turno);
        }

    }

}
