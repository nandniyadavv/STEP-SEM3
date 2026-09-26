import java.util.*;

public class Problem5_PublicTransportFareCalculator {
    static abstract class Transport { double distance; Transport(double d){distance=d;} abstract double fare(); }
    static class Bus extends Transport { Bus(double d){super(d);} double fare(){return Math.min(10,2+0.10*distance);} }
    static class Train extends Transport { Train(double d){super(d);} double fare(){return 3+0.15*distance;} }
    static class Metro extends Transport { double factor; Metro(double d,double f){super(d);factor=f;} double fare(){return (1.50+0.20*distance)*factor;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); double d=sc.nextDouble(); Transport t;
            if(type.equals("BUS"))t=new Bus(d); else if(type.equals("TRAIN"))t=new Train(d); else t=new Metro(d,sc.nextDouble());
            double f=t.fare(); total+=f; System.out.printf("%s: %.2f%n",type,f);
        }
        System.out.printf("Total: %.2f%n",total);
    }
}