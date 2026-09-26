import java.util.*;

public class Problem3_HostelElectricityBill {
    static abstract class Room { double units; Room(double u){units=u;} abstract double bill(); }
    static class Single extends Room { Single(double u){super(u);} double bill(){return 8*units;} }
    static class Shared extends Room { int occupants; Shared(double u,int o){super(u);occupants=o;} double bill(){return 6*units/occupants;} }
    static class AC extends Room { AC(double u){super(u);} double bill(){return 10*units+200;} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();double u=sc.nextDouble();Room r;if(type.equals("SINGLE"))r=new Single(u);else if(type.equals("SHARED"))r=new Shared(u,sc.nextInt());else r=new AC(u);double v=r.bill();total+=v;System.out.printf("%s: %.2f%n",type,v);}System.out.printf("Total: %.2f%n",total);}
}