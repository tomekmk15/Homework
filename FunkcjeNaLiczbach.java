package zadania;

import java.util.Scanner;

public class FunkcjeNaLiczbach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("podaj liczxby by obliczyc sume");
        long liczba = scanner.nextLong();
        int suma = sumaCyfr(liczba);
        System.out.println("Suma cyfr liczby " + liczba + " wynosi: " + suma);

        System.out.println("Podaj podstawe");
        long podstawa = scanner.nextLong();
        System.out.println("Podaj wykladnik");
        int wykladnik = scanner.nextInt();
        long wynikPotegi = potega(podstawa, wykladnik);
        System.out.println(podstawa + " do potęgi " + wykladnik + " wynosi: " + wynikPotegi);

        System.out.println("podaj liczbe zeby oblkiczyc silnie");
        int n = scanner.nextInt();
        long Silnia = silnia(n);
        System.out.println("Silnia z " + n + " wynosi: " + Silnia);

        System.out.println("podaj liczbe zeby obliczyc liczb fib");
        int fibNumber = scanner.nextInt();
        long fibResult = fib(fibNumber);
        System.out.println("Liczba fib  wynosi: " + fibResult);


        System.out.println("Podaj liczbe i sprawdz czy jest pierwsza");
        long numberToCheck = scanner.nextLong();
        boolean isPrime = czPierwsza(numberToCheck);
        if (isPrime) {
            System.out.println(numberToCheck + " jest liczbą pierwszą.");
        } else {
            System.out.println(numberToCheck + " nie jest liczbą pierwszą.");
        }
    }


    public static int sumaCyfr(long n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }


    public static long potega(long podstawa, int wykladnik) {
        if (wykladnik < 0) {
            throw new IllegalArgumentException("Wykladnik  nieujemny.");
        }

        long wynik = 1;
        for (int i = 0; i < wykladnik; i++) {
            wynik *= podstawa;
        }
        return wynik;
    }


    public static long silnia(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Nie moze byc ujemna.");
        }

        long wynik = 1;
        for (int i = 1; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }


    public static long fib(int n) {
        if (n <= 1) {
            return n;
        }

        long fib1 = 0;
        long fib2 = 1;
        long fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }

        return fib;
    }


    public static boolean czPierwsza(long liczba) {
        if (liczba <= 1) {
            return false;
        }

        if (liczba <= 3) {
            return true;
        }

        if (liczba % 2 == 0 || liczba % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= liczba; i += 6) {
            if (liczba % i == 0 || liczba % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
