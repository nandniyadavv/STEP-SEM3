import java.util.*;

public class Problem3_DeliveryFeeCalculator {
    static abstract class Delivery {
        double weight, distance;
        Delivery(double w,double d){weight=w;distance=d;}
        abstract double fee();
    }
    static class Standard extends Delivery { Standard(double w,double d){super(w,d);} double fee(){return 5+0.50*weight+0.10*distance;} }
    static class Express extends Delivery { Express(double w,double d){super(w,d);} double fee(){return 15+weight+0.20*distance;} }
    static class International extends Delivery {
        double customs;
        International(double w,double d,double c){super(w,d);customs=c;}
        double fee(){return 25+2*weight+0.50*distance+customs;}
    }
    static Delivery create(String type,double w,double d,double c){
        if(type.equals("STANDARD"))return new Standard(w,d);
        if(type.equals("EXPRESS"))return new Express(w,d);
        return new International(w,d,c);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); double w=sc.nextDouble(), d=sc.nextDouble(); double c=0;
            if(type.equals("INTERNATIONAL")) c=sc.nextDouble();
            Delivery x=create(type,w,d,c); double f=x.fee(); total+=f;
            System.out.printf("%s: %.2f%n",type,f);
        }
        System.out.printf("Total: %.2f%n",total);
    }
}