public class SecondoEsempio {

    public static void main(String... args) {
        CiProvo ogg = new CiProvo();
        int numero = 10;
        ogg.cambiaValore(numero);
        System.out.println("il valore del numero è " + numero);
    }

    public static class CiProvo {
        public void cambiaValore(int valore) {
            valore = 1000;
        }
    }
}
