import domain.Casella;
import domain.Giocatore;

import java.util.List;
import java.util.Random;

import static domain.Casella.inizializzaBoard;
import static domain.Giocatore.*;

public class Main {

    public static
    void main(String[] args)
    {
        List<Casella> board = inizializzaBoard();
        List<Giocatore> listaGiocatori = creazioneGiocatori();


        //si GIOCA
        // come si vince ? quando finisce il gioco ?
        int numeroGiocatori = listaGiocatori.size()-1;
        int turno = new Random().nextInt(listaGiocatori.size()-1) ;

        boolean flagGiocoFinito = true;
        while(flagGiocoFinito){

            Giocatore giocatoreAttuale = listaGiocatori.get(turno);
            giocatoreAvanza(listaGiocatori, turno);
            turno = prossimoTurno(numeroGiocatori, turno);

            flagGiocoFinito = isFlagGiocoFinito(listaGiocatori);


            System.out.println("il giocatore - " + giocatoreAttuale.getNickName() + " si trova sulla casella "+ giocatoreAttuale.getPosizione());
        }








    }

    private static int prossimoTurno(int numeroGiocatori, int turno) {
        return turno + 1 > numeroGiocatori ? 0 : turno + 1;
    }

}
