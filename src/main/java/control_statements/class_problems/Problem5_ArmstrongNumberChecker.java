public class Problem5_ArmstrongNumberChecker {
    static void checkArmstrong(int number) {
        int origNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        if (sum == origNumber) {
            System.out.println("Is the number " + origNumber + " an Armstrong number? true");
        } else {
            System.out.println("Is the number " + origNumber + " an Armstrong number? false");
        }
    }

    public static void main(String[] args) {
        checkArmstrong(153);
        checkArmstrong(123);
    }
}