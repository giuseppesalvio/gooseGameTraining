public class PrimoEsempio {

    public static void main(String... args) {
        Counter c = new Counter();
        System.out.println("Oggettmo inizializzato: " + c.getCounter());
        c.incrementaCounter();
        System.out.println("Oggettmo inizializzato: " + c.getCounter());
        c.incrementaCounter(9);
        System.out.println("Oggettmo inizializzato: " + c.getCounter());
    }

    public static class Counter {
        private int counter;

        public Counter() {
            counter = 0;
        }

        public void incrementaCounter() {
            counter++;
        }

        public void incrementaCounter(int incremento) {
            counter = incremento;
        }

        public int getCounter() {
            return counter;
        }
    }
}
