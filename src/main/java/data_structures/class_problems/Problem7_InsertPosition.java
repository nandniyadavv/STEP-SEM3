public class Problem7_InsertPosition {
    static int searchInsertPosition(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
    }
}