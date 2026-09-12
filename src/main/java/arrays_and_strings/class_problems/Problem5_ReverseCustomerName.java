public class Problem5_ReverseCustomerName {
    static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();

        for (int i = 0; i < characters.length / 2; i++) {
            char temp = characters[i];
            characters[i] = characters[characters.length - 1 - i];
            characters[characters.length - 1 - i] = temp;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
