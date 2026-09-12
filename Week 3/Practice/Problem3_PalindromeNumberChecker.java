public class Problem3_PalindromeNumberChecker {
    static void checkPalindrome(int number) {
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        boolean isPalindrome = reversedNumber == origNumber;
        System.out.println("Is the number " + origNumber + " a Palindrome? " + isPalindrome);
    }

    public static void main(String[] args) {
        checkPalindrome(121);
        checkPalindrome(123);
    }
}