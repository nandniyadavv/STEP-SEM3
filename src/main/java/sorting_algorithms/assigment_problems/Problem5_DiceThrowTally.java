import java.util.Arrays;

public class Problem5_DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] counts = new int[7];
        for (int roll : rolls) {
            if (roll < 1 || roll > 6) {
                throw new IllegalArgumentException("Roll must be from 1 to 6");
            }
            counts[roll]++;
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + counts[value] + " ");
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int value = 1; value <= 6; value++) {
            for (int count = 0; count < counts[value]; count++) {
                sorted[index++] = value;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
    }
}