public class PalindromeChecker {

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello", "racecar", "Java"};

        for (String text : inputs) {
            boolean iterative = isPalindromeIterative(text);
            boolean recursive = isPalindromeRecursive(text);
            boolean arrayReversal = isPalindromeArrayReversal(text);

            System.out.println("\"" + text + "\" ->");
            System.out.println("  Iterative:     " + toLabel(iterative));
            System.out.println("  Recursive:     " + toLabel(recursive));
            System.out.println("  Array Reversal: " + toLabel(arrayReversal));
            System.out.println("  All approaches agree: " + (iterative == recursive && recursive == arrayReversal));
            System.out.println();
        }
    }

    private static String toLabel(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }
}
