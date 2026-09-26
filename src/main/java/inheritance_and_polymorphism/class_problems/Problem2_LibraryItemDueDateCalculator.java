import java.time.LocalDate;
import java.util.*;

public class Problem2_LibraryItemDueDateCalculator {
    static abstract class LibraryItem {
        protected String title;
        LibraryItem(String title){ this.title = title; }
        abstract LocalDate dueDate();
    }
    static class Book extends LibraryItem { Book(String t){super(t);} LocalDate dueDate(){return LocalDate.of(2023,10,26).plusDays(14);} }
    static class DVD extends LibraryItem { DVD(String t){super(t);} LocalDate dueDate(){return LocalDate.of(2023,10,26).plusDays(7);} }
    static class Magazine extends LibraryItem { Magazine(String t){super(t);} LocalDate dueDate(){return LocalDate.of(2023,10,26).plusDays(3);} }

    static LibraryItem create(String type,String title){
        if(type.equals("BOOK")) return new Book(title);
        if(type.equals("DVD")) return new DVD(title);
        return new Magazine(title);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); sc.nextLine();
        for(int i=0;i<n;i++){
            String line=sc.nextLine().trim(); int first=line.indexOf(' ');
            String type=line.substring(0,first); String title=line.substring(first+1).replaceAll("\\\"","");
            LibraryItem item=create(type,title);
            System.out.println(item.title+": "+item.dueDate());
        }
    }
}