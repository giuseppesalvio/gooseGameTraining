package goose.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Giocatore {
    String nickName;
    int posizione;

    public static List<Giocatore> creazioneGiocatori() {
        List<Giocatore> listaGiocatori = new ArrayList<>();
        int randomQuantitaGiocatore = new Random().nextInt(3) + 2;
        for (int i = 0; i < randomQuantitaGiocatore; i++) {
            listaGiocatori.add(new Giocatore("P_" + i, 1));
        }
        return listaGiocatori;
    }

    public static boolean isFlagGiocoFinito(List<Giocatore> listaGiocatori) {
        for (Giocatore giocatore : listaGiocatori) {
            if (giocatore.getPosizione() == 100) {
                return false;
            }
        }
        return true;
    }

    public static void giocatoreAvanza(Giocatore giocatoreAttuale) {
        int tiroDado1 = new Random().nextInt(6) + 1;
        int tiroDado2 = new Random().nextInt(6) + 1;
        int tiroDado = tiroDado1 + tiroDado2;
        int nuovaPosizione = giocatoreAttuale.getPosizione() + tiroDado;
        nuovaPosizione = checkSeTornareIndietro(nuovaPosizione);
        print(giocatoreAttuale, tiroDado1, tiroDado2, tiroDado, nuovaPosizione,giocatoreAttuale.getPosizione() + tiroDado);
        giocatoreAttuale.setPosizione(nuovaPosizione);
    }

    private static void print(Giocatore giocatoreAttuale, int tiroDado1, int tiroDado2, int tiroDado, int nuovaPosizione, int posizioneSenzaTornareIndietro) {
        String posizioneOltre100 = "";
        if(posizioneSenzaTornareIndietro>100){
            posizioneOltre100 = " Non arriva precisamente a 100 quindi torna indietro";
        }


        System.out.println("il giocatore - " + giocatoreAttuale.getNickName()
                + " che si trova sulla casella " + giocatoreAttuale.getPosizione()
                + " lancia " + tiroDado1 + " + " + tiroDado2 + " = " + tiroDado
                + posizioneOltre100
                + " ora si trova sulla casella " + nuovaPosizione);
    }

    private static int checkSeTornareIndietro(int nuovaPosizione) {
        if (nuovaPosizione > 100) {
            int scarto = nuovaPosizione - 100;
            nuovaPosizione = 100 - scarto;
        }
        return nuovaPosizione;
    }

    public static int getNumeroGiocatori(List<Giocatore> listaGiocatori) {
        return listaGiocatori.size() - 1;
    }

    public static int prossimoTurno(int numeroGiocatori, int turno) {
        return turno + 1 > numeroGiocatori ? 0 : turno + 1;
    }

    public static int scegliGiocatoreIniziale(List<Giocatore> listaGiocatori) {
        return new Random().nextInt(getNumeroGiocatori(listaGiocatori));
    }
}
