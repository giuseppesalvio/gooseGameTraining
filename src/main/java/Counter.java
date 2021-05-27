public class Counter {
    private int valore;
    private int valoreMassimo;
    private boolean errore;

    public Counter(int valoreMassimo) {
        this.valoreMassimo = valoreMassimo;
        this.errore=false;
        this.valore=0;
    }

    public int getValore() {
        return valore;
    }

    public void incrementa() {
        this.valore++;
    }

    public void reset() {
        this.valore=0;
        this.errore=false;
    }

    public boolean isErrore() {
        return errore;
    }
}
