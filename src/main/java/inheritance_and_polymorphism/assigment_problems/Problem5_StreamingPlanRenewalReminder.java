import java.time.LocalDate;
import java.util.*;

public class Problem5_StreamingPlanRenewalReminder {
    static abstract class Plan { String name; LocalDate start; Plan(String n,LocalDate s){name=n;start=s;} abstract LocalDate renewalDate(); }
    static class Basic extends Plan { Basic(String n,LocalDate s){super(n,s);} LocalDate renewalDate(){return start.plusDays(30);} }
    static class Standard extends Plan { Standard(String n,LocalDate s){super(n,s);} LocalDate renewalDate(){return start.plusDays(90);} }
    static class Premium extends Plan { Premium(String n,LocalDate s){super(n,s);} LocalDate renewalDate(){return start.plusDays(365);} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();for(int i=0;i<n;i++){String type=sc.next(),name=sc.next(),date=sc.next();LocalDate d=LocalDate.parse(date);Plan p;if(type.equals("BASIC"))p=new Basic(name,d);else if(type.equals("STANDARD"))p=new Standard(name,d);else p=new Premium(name,d);System.out.println(name+": "+p.renewalDate());}}
}