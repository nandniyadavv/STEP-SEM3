import java.util.*;

public class Problem2_CampusParkingChargeCalculator {
    static abstract class Vehicle { int hours; Vehicle(int h){hours=h;} abstract double charge(); }
    static class Bike extends Vehicle { Bike(int h){super(h);} double charge(){return 10*hours;} }
    static class Car extends Vehicle { Car(int h){super(h);} double charge(){return 30+20*(hours-1);} }
    static class Truck extends Vehicle { Truck(int h){super(h);} double charge(){return Math.max(100,50*hours);} }
    static Vehicle create(String type,int h){if(type.equals("BIKE"))return new Bike(h);if(type.equals("CAR"))return new Car(h);return new Truck(h);}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();int h=sc.nextInt();double v=create(type,h).charge();total+=v;System.out.printf("%s: %.2f%n",type,v);}System.out.printf("Total: %.2f%n",total);}
}