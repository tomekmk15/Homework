package zadania;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Podaj działanie: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("closed.");
                running = false;
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                System.out.println("Incorrect operation. Try again.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(tokens[0]);
                String operator = tokens[1];
                double num2 = Double.parseDouble(tokens[2]);

                double result = calculate(num1, operator, num2);
                if (Double.isNaN(result)) {
                    System.out.println("Incorrect operation. Try again.");
                } else {
                    System.out.println("result: " + result);
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect operation. Try again.");
            }
        }

        scanner.close();
    }

    public static double calculate(double num1, String operator, double num2) {
        double result = Double.NaN;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                }
                break;

            case "^":
                result = Math.pow(num1, num2);
                break;
            case "sqrt":
                result = Math.sqrt(num1);
                break;

            default:
                break;
        }

        return result;
    }
}
