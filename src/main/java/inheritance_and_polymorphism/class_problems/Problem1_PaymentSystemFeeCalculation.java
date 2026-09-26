import java.util.*;

public class Problem1_PaymentSystemFeeCalculation {
    static abstract class Payment {
        protected double amount;
        Payment(double amount) { this.amount = amount; }
        abstract double adjustedAmount();
    }
    static class Card extends Payment { Card(double a) { super(a); } double adjustedAmount(){ return amount * 1.02; } }
    static class Wallet extends Payment { Wallet(double a) { super(a); } double adjustedAmount(){ return amount * 1.01; } }
    static class BankTransfer extends Payment { BankTransfer(double a) { super(a); } double adjustedAmount(){ return amount; } }

    static Payment create(String type, double amount) {
        if (type.equals("CARD")) return new Card(amount);
        if (type.equals("WALLET")) return new Wallet(amount);
        return new BankTransfer(amount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next(); double amount = sc.nextDouble();
            Payment p = create(type, amount); double value = p.adjustedAmount();
            total += value; System.out.printf("%s: %.2f%n", type, value);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}