import java.util.Scanner;

public class Problem6_ClassAttendanceTracker {
    // Returns {number of present days, longest consecutive present streak}.
    static int[] attendanceSummary(int[] days) {
        int present = 0, currentStreak = 0, longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                if (currentStreak > longestStreak) longestStreak = currentStreak;
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) days[i] = sc.nextInt();

        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }
}