public class Problem4_GCDUsingWhileLoop {
    static void findGCD(int number1, int number2) {
        int original1 = number1;
        int original2 = number2;

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        System.out.println("The GCD of " + original1 + " and " + original2 + " is " + number1);
    }

    public static void main(String[] args) {
        findGCD(48, 18);
    }
}