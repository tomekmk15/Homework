package pl.domowe.klasaDlaUlamkow;

import java.util.Objects;

public final class Fraction implements Comparable<Fraction> {
    private final long numerator;
    private final long denominator;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction HALF = new Fraction(1, 2);

    private Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        
        long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        long sign = denominator < 0 ? -1 : 1;

        this.numerator = sign * Math.abs(numerator) / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    public static Fraction of(long numerator, long denominator) {
        return new Fraction(numerator, denominator);
    }

    public static Fraction of(long number) {
        return new Fraction(number, 1);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Fraction shortened() {
        long gcd = gcd(Math.abs(numerator), denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public Fraction neg() {
        return new Fraction(-numerator, denominator);
    }

    public Fraction add(Fraction other) {
        long newNumerator = numerator * other.denominator + other.numerator * denominator;
        long newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).shortened();
    }

    public Fraction sub(Fraction other) {
        return add(other.neg());
    }

    public Fraction mul(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator).shortened();
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new Fraction(numerator * other.denominator, denominator * other.numerator).shortened();
    }

    public double getAsDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public int compareTo(Fraction other) {
        long diff = numerator * other.denominator - other.numerator * denominator;
        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
