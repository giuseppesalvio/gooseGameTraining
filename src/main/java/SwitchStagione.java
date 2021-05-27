public class SwitchStagione {
    public static void main(String args[]) {
        int mese = 4;
        String stagione;
        switch (mese) {
            case 12:
            case 1:
            case 2:
                stagione = "inverno";
                break;
            case 3:
            case 4:
            case 5:
                stagione = "primavera";
                break; //senza questo break si ha estate
            case 6:
            case 7:
            case 8:
                stagione = "estate";
                break;
            case 9:
            case 10:
            case 11:
                stagione = "autunno";
                break;
            default: //la clausola default è opzionale
                stagione = "non identificabile";
        }
        System.out.println("La stagione e' " +
                stagione);
    }
}
