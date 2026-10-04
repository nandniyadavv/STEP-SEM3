import java.util.*;

public class Problem2_ParcelShippingDesk {
    static abstract class Parcel {
        double weight, declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight; this.declaredValue = declaredValue;
        }

        abstract double shippingCharge();
        abstract String type();

        double insurance() { return 0.0; }

        double total() {
            return shippingCharge() + insurance();
        }
    }

    interface Insurable {
        double insuranceAmount();
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 40 + 10 * weight; }
        String type() { return "STANDARD"; }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 80 + 15 * weight; }
        double insuranceAmount() { return declaredValue * 0.02; }
        double insurance() { return insuranceAmount(); }
        String type() { return "EXPRESS"; }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) { super(weight, value); }
        double shippingCharge() { return 40 + 10 * weight + 50; }
        double insuranceAmount() { return declaredValue * 0.02; }
        double insurance() { return insuranceAmount(); }
        String type() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;

            if (type.equals("STANDARD")) parcel = new Standard(weight, value);
            else if (type.equals("EXPRESS")) parcel = new Express(weight, value);
            else parcel = new Fragile(weight, value);

            double charge = parcel.shippingCharge();
            double insurance = parcel.insurance();
            double total = parcel.total();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}