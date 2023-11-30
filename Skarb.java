package zadania;

import java.util.Scanner;

public class Skarb {
    public static void main(String[] args) {
        final int PLANSZA_ROZMIAR = 10;
        char[][] tablica = new char[PLANSZA_ROZMIAR][PLANSZA_ROZMIAR];


        initBoard(tablica, PLANSZA_ROZMIAR);


        int[] treasurePos = generateRandomPosition(PLANSZA_ROZMIAR);
        int[] playerPos = generateRandomPosition(PLANSZA_ROZMIAR);


        tablica[treasurePos[0]][treasurePos[1]] = 'T';
        tablica[playerPos[0]][playerPos[1]] = 'P';

        Scanner scanner = new Scanner(System.in);
        int moves = 0;


        while (true) {

            printBoard(tablica);


            if (playerPos[0] == treasurePos[0] && playerPos[1] == treasurePos[1]) {
                System.out.println(" Znalazles skarb po " + moves + " ruchach.");
                break;
            } else if (playerPos[0] < 0 || playerPos[0] >= PLANSZA_ROZMIAR || playerPos[1] < 0 || playerPos[1] >= PLANSZA_ROZMIAR) {
                System.out.println("Poza plansza. Koniec gry.");
                break;
            }


            System.out.print("Podaj kierunek (U - UP, D - DOWN, L - LEFT, R - RIGHT): ");
            char direction = scanner.nextLine().toUpperCase().charAt(0);

            int[] move = getMove(direction);
            int[] newPlayerPos = {playerPos[0] + move[0], playerPos[1] + move[1]};


            int distanceBefore = calculateDistance(playerPos, treasurePos);
            int distanceAfter = calculateDistance(newPlayerPos, treasurePos);

            if (distanceAfter < distanceBefore) {
                System.out.println("Zbliżasz się do skarbu!");
            } else if (distanceAfter > distanceBefore) {
                System.out.println("Oddalasz się od skarbu.");
            } else {
                System.out.println("Jesteś w tym samym miejscu.");
            }


            playerPos = newPlayerPos;
            tablica[playerPos[0]][playerPos[1]] = 'P';
            moves++;
        }

        scanner.close();
    }

    public static void initBoard(char[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }


    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    public static int[] generateRandomPosition(int size) {
        int[] position = new int[2];
        position[0] = (int) (Math.random() * size);
        position[1] = (int) (Math.random() * size);
        return position;
    }


    public static int[] getMove(char direction) {
        int[] move = {0, 0};
        switch (direction) {
            case 'U':
                move[0] = -1;
                break;
            case 'D':
                move[0] = 1;
                break;
            case 'L':
                move[1] = -1;
                break;
            case 'R':
                move[1] = 1;
                break;
        }
        return move;
    }


    public static int calculateDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}
