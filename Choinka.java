package zadania;

import java.util.Scanner;

public class Choinka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wysokosc choinki: ");

        int height = scanner.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");

            }

            for (int j = 0; j < 2 * i + 1; j++) {

                System.out.print("*");
            }
            System.out.println();


        }
    }
}