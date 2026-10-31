public class Problem2_WarehouseBinGridScan {
    static int[] warehouseSummary(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return new int[]{0, -1, -1};
        }

        int total = 0;
        int maximum = -1;
        int maxRow = 0;
        int maxColumn = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                total += grid[row][column];
                if (grid[row][column] > maximum) {
                    maximum = grid[row][column];
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }
        return new int[]{total, maxRow, maxColumn};
    }

    public static void main(String[] args) {
        int[] summary = warehouseSummary(new int[][]{
            {4, 9, 2}, {7, 1, 6}, {3, 12, 5}
        });
        System.out.println("total=" + summary[0] + ", maxCoordinate=("
                + summary[1] + ", " + summary[2] + ")");
    }
}