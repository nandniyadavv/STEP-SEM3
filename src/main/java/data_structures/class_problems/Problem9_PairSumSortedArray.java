import java.util.Arrays;

public class Problem9_PairSumSortedArray {
    static int[] pairSumSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            long sum = (long) numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{numbers[left], numbers[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] pair = pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        System.out.println(pair == null ? "Not Found" : Arrays.toString(pair));
    }
}