import java.util.*;

public class Problem1_CanteenBillingCounter {
    static abstract class Customer { double amount; Customer(double a){amount=a;} abstract double finalAmount(); }
    static class Student extends Customer { Student(double a){super(a);} double finalAmount(){return amount*0.90;} }
    static class Staff extends Customer { Staff(double a){super(a);} double finalAmount(){return amount*0.95;} }
    static class Guest extends Customer { Guest(double a){super(a);} double finalAmount(){return amount+10;} }
    static Customer create(String type,double a){if(type.equals("STUDENT"))return new Student(a);if(type.equals("STAFF"))return new Staff(a);return new Guest(a);}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();double a=sc.nextDouble();double v=create(type,a).finalAmount();total+=v;System.out.printf("%s: %.2f%n",type,v);}System.out.printf("Total: %.2f%n",total);}
}