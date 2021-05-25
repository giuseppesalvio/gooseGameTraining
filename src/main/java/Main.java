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

        int turno = scegliTurnoInizialeDelGiocatore(listaGiocatori);

        while(isFlagGiocoFinito(listaGiocatori)){
            giocatoreAvanza(listaGiocatori, turno);
            turno = prossimoTurno(getNumeroGiocatori(listaGiocatori), turno);
        }

    }

}
