import java.util.Arrays;

public class Problem10_RemoveDuplicatesInPlace {
    static int removeDuplicates(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int writeIndex = 1;
        for (int readIndex = 1; readIndex < numbers.length; readIndex++) {
            if (numbers[readIndex] != numbers[writeIndex - 1]) {
                numbers[writeIndex++] = numbers[readIndex];
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(numbers);
        System.out.println("length=" + length + ", values="
                + Arrays.toString(Arrays.copyOf(numbers, length)));
    }
}