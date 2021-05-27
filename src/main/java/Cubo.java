import java.util.Objects;

public class Cubo {
    private int lunghezza;
    private int larghezza;
    private int altezza;

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cubo cubo = (Cubo) o;
        return lunghezza == cubo.lunghezza && larghezza == cubo.larghezza && altezza == cubo.altezza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunghezza, larghezza, altezza);
    }
}
