import java.util.*;

public class Problem5_TravelBookingWithCommonFee {
    static abstract class Booking {
        static final double BOOKING_FEE = 50.0;
        double distance;

        Booking(double distance) { this.distance = distance; }
        abstract double baseFare();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }

        abstract String mode();
    }

    static class Bus extends Booking {
        Bus(double distance) { super(distance); }
        double baseFare() { return distance * 2.0; }
        String mode() { return "BUS"; }
    }

    static class Train extends Booking {
        Train(double distance) { super(distance); }
        double baseFare() { return distance * 1.5; }
        String mode() { return "TRAIN"; }
    }

    static class Flight extends Booking {
        Flight(double distance) { super(distance); }
        double baseFare() { return 2500 + distance * 4.0; }
        String mode() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            if (type.equals("BUS")) booking = new Bus(distance);
            else if (type.equals("TRAIN")) booking = new Train(distance);
            else booking = new Flight(distance);

            System.out.printf("%s: %.2f%n", booking.mode(), booking.totalFare());
        }
    }
}