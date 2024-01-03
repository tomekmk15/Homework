package pl.domowe.klasaDlaUlamkow;

public class FractionTest {
    public static void main(String[] args) {
        Fraction fraction1 = Fraction.of(3, 4);
        Fraction fraction2 = Fraction.of(6, 8);
        
        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);
        

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Sum: " + sum);
        
        Fraction difference = fraction1.sub(fraction2);
        System.out.println("Difference: " + difference);
        
        Fraction product = fraction1.mul(fraction2);
        System.out.println("Product: " + product);
        
        Fraction quotient = fraction1.div(fraction2);
        System.out.println("Quotient: " + quotient);
        
        System.out.println("Comparison: " + fraction1.compareTo(fraction2));
        
        System.out.println("As double: " + fraction1.getAsDouble());
    }
}
