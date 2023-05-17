package nl.sogyo.javaopdrachten;

public class Fractions{
    final int numerator;
    final int denominator;

    public Fractions(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static void main(String[] args) {        
        Fractions userFraction12 = new Fractions(1, 2);
        
        
        System.out.println(toDecimalNotation(userFraction12));
        System.out.println(toString(userFraction12));
        
        int number = 1;
        Fractions userFraction32 = userFraction12.add(number, userFraction12);

        System.out.println(toString(userFraction32));
        System.out.println(toString(addFraction(userFraction12, userFraction32)));
        System.out.println(toString(subtract(userFraction32, number)));
        System.out.println(toDecimalNotation(subtractFraction(userFraction32, userFraction12)));
        
        Fractions userFraction56 = new Fractions(5, 6);
        number = 5;
        
        System.out.println(toString(multiply(number, userFraction56)));
        System.out.println(toString(multiplyFraction(userFraction12, userFraction56)));
        System.out.println(toString(divide(number, userFraction56)));
        System.out.println(toString(divideFraction(userFraction32, userFraction12)));
    }

    private static Fractions divide(int number, Fractions fraction) {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator * number;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionDivide = new Fractions(newNumerator, newDenominator);
        return userFractionDivide;
    }

    private static Fractions multiplyFraction(Fractions fractionA, Fractions fractionB) {
        int numerator = fractionA.numerator * fractionB.numerator;
        int denominator = fractionA.denominator * fractionB.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionMultiplyFraction = new Fractions(newNumerator, newDenominator);
        return userFractionMultiplyFraction;
    }

    private static Fractions divideFraction(Fractions fractionA, Fractions fractionB) {
        int numerator = fractionA.numerator * fractionB.denominator;
        int denominator = fractionA.denominator * fractionB.numerator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionDivideFraction = new Fractions(newNumerator, newDenominator);
        return userFractionDivideFraction;
    }

    private static Fractions multiply(int number, Fractions fraction) {
        int numerator = fraction.numerator * number;
        int denominator = fraction.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionMultiply = new Fractions(newNumerator, newDenominator);
        return userFractionMultiply;
    }

    private static Fractions subtractFraction(Fractions fractionA, Fractions fractionB) {
        int numerator = fractionA.numerator * fractionB.denominator - fractionB.numerator * fractionA.denominator;
        int denominator = fractionA.denominator * fractionB.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionSubtractFraction = new Fractions(newNumerator, newDenominator);
        return userFractionSubtractFraction;
    }

    private static Fractions subtract(Fractions fraction, int number) {
        int numerator = fraction.numerator - (number * fraction.denominator);
        int denominator = fraction.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionSubtract = new Fractions(newNumerator, newDenominator);
        return userFractionSubtract;
    }

    private static Fractions addFraction(Fractions fractionA, Fractions fractionB) {
        int numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        int denominator = fractionA.denominator * fractionB.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionAddFraction = new Fractions(newNumerator, newDenominator);
        return userFractionAddFraction;
    }

    private static int simplifyFraction(int numerator, int denominator) {
        int highest = denominator >= numerator ? numerator : denominator;
        for (int i = highest; i > 1; i--){
            if(numerator % i == 0 && denominator % i == 0){
                return i;
            }
        }
        return 1;
    }

    private Fractions add(int number, Fractions fraction) {
        int numerator = fraction.numerator + (number * fraction.denominator);
        int denominator = fraction.denominator;
        int newNumerator = numerator / simplifyFraction(numerator, denominator);
        int newDenominator = denominator / simplifyFraction(numerator, denominator);
        Fractions userFractionAdd = new Fractions(newNumerator, newDenominator);
        return userFractionAdd;
    }

    private static String toString(Fractions fraction) {
        String userFractionString = "\"" + fraction.numerator + "/" + fraction.denominator + "\"";
        return userFractionString;
    }

    private static double toDecimalNotation(Fractions fraction) {
        double decimalNotation = (double) fraction.numerator / fraction.denominator;
        return decimalNotation;
    }
}