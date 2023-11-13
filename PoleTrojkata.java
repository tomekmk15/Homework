import java.util.Scanner;

public class PoleTrojkata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dlugosc pierwszego boku");
        double a = scanner.nextDouble();

        System.out.println("Podaj dlugosc drugiego boku");
        double b = scanner.nextDouble();

        System.out.println("Podajdlugosc trzeciego boku");
        double c = scanner.nextDouble();

        if (czyMoznaUlozycTrojkat(a, b, c)) {
            double pole = obliczPoleTojkata(a, b, c);
            System.out.println("Mozna obliczyc pole Trojkata");
            System.out.println("Pole Ttojkata wynosi " + pole);

        } else {
            System.out.println("MIe mozna obilczyc poole Trojkata ");

        }


    }

    private static double obliczPoleTojkata(double a, double b, double c) {
        double p =(a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static boolean czyMoznaUlozycTrojkat(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
