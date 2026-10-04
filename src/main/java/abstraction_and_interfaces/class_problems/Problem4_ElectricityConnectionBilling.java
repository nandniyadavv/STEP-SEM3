import java.util.*;

public class Problem4_ElectricityConnectionBilling {
    static abstract class Connection {
        int units;
        Connection(int units) { this.units = units; }
        abstract double bill();
    }

    static class Home extends Connection {
        Home(int units) { super(units); }
        double bill() {
            if (units <= 100) return units * 5.0;
            return 500 + (units - 100) * 7.0;
        }
    }

    static class Shop extends Connection {
        Shop(int units) { super(units); }
        double bill() { return units * 8.0 + 100; }
    }

    static class Factory extends Connection {
        Factory(int units) { super(units); }
        double bill() { return Math.max(units * 6.0, 1000.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection connection;

            if (type.equals("HOME")) connection = new Home(units);
            else if (type.equals("SHOP")) connection = new Shop(units);
            else connection = new Factory(units);

            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}