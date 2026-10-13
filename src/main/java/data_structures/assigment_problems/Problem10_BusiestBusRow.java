import java.util.Scanner;

public class Problem10_BusiestBusRow {
    // Returns {index of busiest row, total students in that row}.
    // If totals tie, the earliest (smallest index) row is kept.
    static int[] busiestRow(int[][] grid) {
        int bestIndex = 0;
        int bestTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int seats : grid[i]) total += seats;

            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = i;
            }
        }
        return new int[]{bestIndex, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] grid = new int[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                grid[i][j] = sc.nextInt();

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}