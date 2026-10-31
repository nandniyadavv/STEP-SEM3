import java.util.HashSet;
import java.util.Set;

public class Problem3_TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new String[]{"TXN1", "TXN2", "TXN1"}));
    }
}