import domain.Giocatore;

import java.util.List;

import static domain.Giocatore.getNumeroGiocatori;
import static domain.Giocatore.prossimoTurno;
import static domain.Giocatore.*;

public class Main {

    public static
    void main(String[] args)
    {
        List<Giocatore> listaGiocatori = creazioneGiocatori();

        int turnoGiocatore = scegliGiocatoreIniziale(listaGiocatori);

        while(isFlagGiocoFinito(listaGiocatori)){
            giocatoreAvanza(listaGiocatori.get(turnoGiocatore));
            turnoGiocatore = prossimoTurno(getNumeroGiocatori(listaGiocatori), turnoGiocatore);
        }
    }
}
