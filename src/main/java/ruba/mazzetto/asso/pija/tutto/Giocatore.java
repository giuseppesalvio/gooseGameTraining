package ruba.mazzetto.asso.pija.tutto;

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
    List<Integer> mano;
    List<Integer> mazzetto;

    public static List<Giocatore> creazioneGiocatori() {
        List<Giocatore> listaGiocatori = new ArrayList<>();
        int randomQuantitaGiocatore = new Random().nextInt(3) + 2;
        for (int i = 0; i < randomQuantitaGiocatore; i++) {
            listaGiocatori.add(new Giocatore("P_" + i, new ArrayList<>(),new ArrayList<>()));
        }
        return listaGiocatori;
    }

    public static boolean isFlagGiocoFinito(List<Giocatore> listaGiocatori, Mazzo mazzo) {
        for (Giocatore giocatore : listaGiocatori) {
            if (giocatore.getMano().isEmpty() && mazzo.getCarte().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static int prossimoTurno(int numeroGiocatori, int turno) {
        return turno + 1 > numeroGiocatori ? 0 : turno + 1;
    }

    public static int getNumeroGiocatori(List<Giocatore> listaGiocatori) {
        return listaGiocatori.size() - 1;
    }

    public static int scegliGiocatoreIniziale(List<Giocatore> listaGiocatori) {
        return new Random().nextInt(getNumeroGiocatori(listaGiocatori));
    }

    public void aggiungiAllaMano(Integer cartaPescata) {
        this.mano.add(cartaPescata);
    }
    public Integer giocaDallaMano() {
        Integer carta = this.mano.get(0);
        this.mano.remove(0);
        return carta;
    }

}
