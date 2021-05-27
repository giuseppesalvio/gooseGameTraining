package ruba.mazzetto.asso.pija.tutto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Mazzo {
    private List<Integer> carte;

    public Mazzo() {
        List<Integer> carte = new ArrayList<>();
        for (int j=1; j<5; j++) {
            for (int i = 1; i < 11; i++) {
                carte.add(i);
            }
        }
        this.carte=carte;
    }

    public void mischia(){
        Collections.shuffle(this.carte);
    }

    public Integer pescaUnaCarta(){
        Integer carta = this.carte.get(0);
        this.carte.remove(0);
        return carta;
    }
}
