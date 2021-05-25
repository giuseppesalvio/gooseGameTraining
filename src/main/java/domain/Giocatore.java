package domain;

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
        int randomQuantitaGiocatore = new Random().nextInt(2) + 2;
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

    public static void giocatoreAvanza(List<Giocatore> listaGiocatori, int turno) {
        int tiroDado = getTiroDado();
        Giocatore giocatoreAttuale = listaGiocatori.get(turno);
        int nuovaPosizione = giocatoreAttuale.getPosizione() + tiroDado;
        nuovaPosizione = checkSeTornareIndietro(nuovaPosizione);
        System.out.println("il giocatore - " + giocatoreAttuale.getNickName()
                + " che si trova sulla casella " + giocatoreAttuale.getPosizione()
                + " lancia " + tiroDado
                + " ora si trova sulla casella " + nuovaPosizione);
        giocatoreAttuale.setPosizione(nuovaPosizione);
    }

    private static int getTiroDado() {
        int tiroDado = new Random().nextInt(5) + 1;
        tiroDado += new Random().nextInt(5) + 1;
        return tiroDado;
    }

    private static int checkSeTornareIndietro(int nuovaPosizione) {
        if (nuovaPosizione > 100) {
            int scarto = nuovaPosizione - 100;
            nuovaPosizione = 100 - scarto;
        }
        return nuovaPosizione;
    }
}
