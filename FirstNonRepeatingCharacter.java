import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc", "programming", "x"};

        for (String text : inputs) {
            System.out.print("\"" + text + "\" -> ");
            try {
                char result = findFirstNonRepeatingChar(text);
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } catch (IllegalStateException e) {
                System.out.println("No Non-Repeating Character Found");
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }

        throw new IllegalStateException("No Non-Repeating Character Found");
    }
}
