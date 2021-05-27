package ruba.mazzetto.asso.pija.tutto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tavolo {
    private List<Integer> carte;

    public Tavolo() {
        this.carte = new ArrayList<>();
    }

    public Integer calcolaGiocata(Integer cartaGiocata) {
        Integer cartaTrovataSulTavolo = null;
        for (int i=0; i<carte.size();i++) {
            if(carte.get(i) == cartaGiocata){
               cartaTrovataSulTavolo=carte.get(i);
                carte.remove(i);
               return cartaTrovataSulTavolo;
            }
        }
        return cartaTrovataSulTavolo;
    }
}
