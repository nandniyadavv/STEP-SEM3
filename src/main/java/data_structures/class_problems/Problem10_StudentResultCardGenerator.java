import java.util.Scanner;

public class Problem10_StudentResultCardGenerator {
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int total = 0;
            for (int mark : marks) total += mark;
            return total / (double) marks.length;
        }

        char grade() {
            double avg = average();
            if (avg >= 90) return 'A';
            if (avg >= 75) return 'B';
            if (avg >= 60) return 'C';
            if (avg >= 40) return 'D';
            return 'F';
        }

        void printResult() {
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < marks.length; j++) marks[j] = sc.nextInt();
            new Student(name, marks).printResult();
        }
    }
}