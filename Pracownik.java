package pl.domowe.FirmaWyplaty;

import java.util.Scanner;

public class Pracownik {
    public int stawkaGodzinowa;
    public int przepracowaneGodziny;

    public Pracownik(int stawka) {
        this.stawkaGodzinowa = stawka;
        this.przepracowaneGodziny = 0;
    }

    public void praca(int godziny) {
        if (godziny > 8) {
            int nadgodziny = godziny - 8;
            this.przepracowaneGodziny += 8 * stawkaGodzinowa + nadgodziny * 2 * stawkaGodzinowa;
        } else {
            this.przepracowaneGodziny += godziny * stawkaGodzinowa;
        }
    }

    public int wyplata() {
        int wyplata = this.przepracowaneGodziny;
        this.przepracowaneGodziny = 0; // Zerowanie licznika po wypłacie
        return wyplata;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pracownik p1 = new Pracownik(100);
        Pracownik p2 = new Pracownik(100);
        PracownikZPremia p3 = new PracownikZPremia(200);
        System.out.println("Podaj  nad godziny p1: ");
        p1.praca(sc.nextInt());
        System.out.println("Podaj nad godziny p2: ");
        p2.praca(sc.nextInt());

        int x = p1.wyplata();
        int x1  = p2.wyplata();

        System.out.println("Wynik x: " + x);
        System.out.println("Wynik x1: " + x1);

        System.out.println("Podaj regularne godzinny p1: ");
        p1.praca(sc.nextInt());
        System.out.println("Podaj regularne godzinny p2: ");
        p2.praca(sc.nextInt());

        int y = p1.wyplata();
        System.out.println("Wynik y: " + y);

        int y1 = p2.wyplata();
        System.out.println("Wynik y1: " + y1);
        System.out.println();
        System.out.println("podaj kwote premi: ");
        int z = p3.premia(sc.nextInt()) + x;


        System.out.println("wyplata: " + " " +  z);
    }
}
