import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalancedWordsCounterTest {
    public static Collection<Object[]> inputsProvider() {
        return Arrays.asList(new Object[][] {
                { "aabbabcccba", 28 },
                { "", 0 }
        });
    }

    @ParameterizedTest
    @MethodSource("inputsProvider")
    public void parTest(String input, int result) {
        BalancedWordsCounter wordCounter = new BalancedWordsCounter();
        assertEquals(wordCounter.count(input), result);
    }

    @Test
    public void testNullInput() {
        BalancedWordsCounter wordCounter = new BalancedWordsCounter();
        assertThrows(RuntimeException.class, () -> assertEquals(wordCounter.count(null), 0));
    }

    @Test
    public void incorrectInput() {
        BalancedWordsCounter wordCounter = new BalancedWordsCounter();
        assertThrows(RuntimeException.class, () -> assertEquals(wordCounter.count("abababa1"), 0));
    }
}