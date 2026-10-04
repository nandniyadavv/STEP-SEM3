import java.util.*;

public class Problem1_MovieTicketCounter {
    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20.0;
        int count;

        Ticket(int count) { this.count = count; }
        abstract double pricePerTicket();
        abstract String seatType();

        double amount() {
            return count * (pricePerTicket() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) { super(count); }
        double pricePerTicket() { return 150; }
        String seatType() { return "REGULAR"; }
    }

    static class Premium extends Ticket {
        Premium(int count) { super(count); }
        double pricePerTicket() { return 250; }
        String seatType() { return "PREMIUM"; }
    }

    static class Recliner extends Ticket {
        Recliner(int count) { super(count); }
        double pricePerTicket() { return 400; }
        String seatType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket ticket;

            if (type.equals("REGULAR")) ticket = new Regular(count);
            else if (type.equals("PREMIUM")) ticket = new Premium(count);
            else ticket = new Recliner(count);

            double amount = ticket.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.seatType(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}