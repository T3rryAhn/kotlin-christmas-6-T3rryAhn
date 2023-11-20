package christmas.util;

public class StringUtil {
    public static int countMatches(String input, char target) {
        int count = 0;

        for (char i : input.toCharArray()) {
            if (i == target) {
                count++;
            }
        }

        return count;
    }
}
