public class Problem5_BankTransactionReferenceValidator {
    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3)).append("] ");
        result.append("DATE: ");
        result.append(reference.substring(3, 5)).append("/");
        result.append(reference.substring(5, 7)).append("/");
        result.append(reference.substring(7, 9));
        result.append(" | SEQ: ").append(reference.substring(9));

        return result.toString();
    }

    public static void main(String[] args) {
        String valid = normalizeReference(" hdf03022600042 ");
        String invalid = normalizeReference("12F03022600042");

        System.out.println(validateAndFormat(valid));
        System.out.println(validateAndFormat(invalid));
    }
}
