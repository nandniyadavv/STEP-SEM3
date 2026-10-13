import java.util.Scanner;

public class Problem1_VowelAndConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else consonants++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}