public class TerzoEsempio {

    public static void main(String... args) {
        CiProvo ogg = new CiProvo();
        Data data= new Data(1,2,2015);
        ogg.cambiaValore(data);
        System.out.println("La variabile data contiene: " + data);
    }

    public static class CiProvo {
        public void cambiaValore(Data data) {
            data.giorno=29;
            data.mese=7 ;
        }
    }

    private static class Data {
        int giorno;
        int mese;
        int anno;

        public Data(int giorno, int mese, int anno) {
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "giorno=" + giorno +
                    ", mese=" + mese +
                    ", anno=" + anno +
                    '}';
        }
    }
}
