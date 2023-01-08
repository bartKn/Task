import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class BalancedWordsCounter {

    public int count(String input) {
        if (input.length() == 0) {
            return 0;
        }

        if (!Pattern.matches("[a-zA-Z]+", input))
            throw new RuntimeException();

        int result = 0;

        int n = 1;
        int index = 0;

        while (n <= input.length()) {
            while (index + n <= input.length()) {
                HashMap<Character, Long> charNums = new HashMap<>();
                String substr = input.substring(index, index + n);
                System.out.println(substr);
                for (Character c: substr.toCharArray()) {
                    charNums.put(c, substr.chars().filter(ch -> ch == c).count());
                }

                if (checkValues(charNums)) {
                    result += 1;
                }

                index += 1;
            }

            n += 1;
            index = 0;
        }

        return result;
    }

    private boolean checkValues(HashMap<Character, Long> charNums) {
        List<Long> values = new ArrayList<>(charNums.values());

        return values.stream().allMatch(values.get(0)::equals);
    }
}
