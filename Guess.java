package zadania;

import java.util.Scanner;
import java.util.Random;

public class Guess {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(1000);
        int attempts = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zgadnij liczbę  od 0 do 999");

        while (true) {
            System.out.print("Podaj swoją liczbe: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println(" Zgadłes liczbe " + numberToGuess + " w " + attempts + " probie.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println(" Liczba jest za mała.");
            } else {
                System.out.println(" Liczba jest za duza.");
            }
        }


    }
}
