import java.util.HashSet;
import java.util.Set;

public class Problem5_PairWithTargetSum {
    static boolean hasPairWithSum(int[] numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int number : numbers) {
            if (seen.contains(target - number)) {
                return true;
            }
            seen.add(number);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
    }
}