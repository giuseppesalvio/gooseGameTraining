package ruba.mazzetto.asso.pija.tutto;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        mazzo.mischia();
        Tavolo tavolo = new Tavolo();
        List<Giocatore> listaGiocatori = Giocatore.creazioneGiocatori();

        int chiComincia = Giocatore.scegliGiocatoreIniziale(listaGiocatori);
        int turnoGiocatore = chiComincia;
        int turnoAttuale = 1;

        caricaTavolo(tavolo,mazzo);

        while(!mazzo.getCarte().isEmpty() || !checkGiocatoriSenzaCarte(listaGiocatori) && !mazzo.getCarte().isEmpty()){
            if(checkGiocatoriSenzaCarte(listaGiocatori)){
                iGiocatoriPescanoTreCarte(listaGiocatori,mazzo);
            }
            Giocatore giocatoreAttuale = listaGiocatori.get(turnoGiocatore);
            System.out.print(giocatoreAttuale.getNickName()
                    + " - " + Arrays.toString(giocatoreAttuale.getMano().toArray())
            );

            Integer cartaGiocata = giocatoreAttuale.giocaDallaMano();
            Integer cartaTrovataSulTavolo = tavolo.calcolaGiocata(cartaGiocata);
            if(cartaTrovataSulTavolo == null) {
                tavolo.getCarte().add(cartaGiocata);
            }else{
                giocatoreAttuale.getMazzetto().add(cartaGiocata);
                giocatoreAttuale.getMazzetto().add(cartaTrovataSulTavolo);
            }

            System.out.println(" mazzetto : "+ Arrays.toString(giocatoreAttuale.getMazzetto().toArray()));

            System.out.println("Tavolo : " +Arrays.toString(tavolo.getCarte().toArray()));
            turnoGiocatore = Giocatore.prossimoTurno(Giocatore.getNumeroGiocatori(listaGiocatori), turnoGiocatore);
        }
        System.out.println("mazzo " + mazzo.getCarte().size());
        System.out.println("tavolo " + tavolo.getCarte().size());
        System.out.println("giocatore1 " + listaGiocatori.get(0).getMano().size());
        System.out.println("giocatore2 " + listaGiocatori.get(1).getMano().size());
    }

    private static void caricaTavolo(Tavolo tavolo, Mazzo mazzo) {
        tavolo.getCarte().add(mazzo.pescaUnaCarta());
        tavolo.getCarte().add(mazzo.pescaUnaCarta());
        tavolo.getCarte().add(mazzo.pescaUnaCarta());
        tavolo.getCarte().add(mazzo.pescaUnaCarta());
    }

    private static void iGiocatoriPescanoTreCarte(List<Giocatore> listaGiocatori, Mazzo mazzo) {
        for (Giocatore giocatore : listaGiocatori) {
            giocatore.aggiungiAllaMano(mazzo.pescaUnaCarta());
            giocatore.aggiungiAllaMano(mazzo.pescaUnaCarta());
            giocatore.aggiungiAllaMano(mazzo.pescaUnaCarta());
        }
    }

    private static boolean checkGiocatoriSenzaCarte(List<Giocatore> listaGiocatori) {
        int contaQuantiSonoSenzaCarte = 0;
        for (Giocatore giocatore : listaGiocatori) {
            if(giocatore.getMano().isEmpty()) contaQuantiSonoSenzaCarte++;
        }
        if (contaQuantiSonoSenzaCarte == listaGiocatori.size()){
            return true;
        }
        return false;

    }

}
