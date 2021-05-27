package goose.game;

import java.util.List;

import static goose.game.Giocatore.getNumeroGiocatori;
import static goose.game.Giocatore.prossimoTurno;
import static goose.game.Giocatore.*;

public class Main {

    public static
    void main(String[] args)
    {
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();
        simulazione();

    }

    private static void simulazione() {
        List<Giocatore> listaGiocatori = creazioneGiocatori();

        int chiComincia = scegliGiocatoreIniziale(listaGiocatori);
        int turnoGiocatore = chiComincia;
        int turnoAttuale =1;

        while(isFlagGiocoFinito(listaGiocatori)){
            if(chiComincia==turnoGiocatore) System.out.println("Turno "+ turnoAttuale++);
            giocatoreAvanza(listaGiocatori.get(turnoGiocatore));
            turnoGiocatore = prossimoTurno(getNumeroGiocatori(listaGiocatori), turnoGiocatore);
        }
    }
}
