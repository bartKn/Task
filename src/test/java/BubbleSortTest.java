import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    public static Collection<Object[]> inputProvider() {
        List<Comparable<?>> list1 = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 8, 3, 8));
        List<Comparable<?>> list1result = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 8, 8));

        List<Comparable<?>> list2 = new ArrayList<>(Arrays.asList(-9.3, 0.2, 4.0, 0.1, 5.0, 9.0));
        List<Comparable<?>> list2result = new ArrayList<>(Arrays.asList(-9.3, 0.1, 0.2, 4.0, 5.0, 9.0));

        List<Comparable<?>> list3 = new ArrayList<>();
        List<Comparable<?>> list3result = new ArrayList<>();

        List<Comparable<?>> list4 = new ArrayList<>(Arrays.asList(null, 5.0001));
        List<Comparable<?>> list4result = new ArrayList<>(Arrays.asList(5.0001));

        return Arrays.asList(new Object[][] {
                { list1, list1result },
                { list2, list2result },
                { list3, list3result },
                { list4, list4result}
        });
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void parTest(List input, List result) {
        BubbleSort bubbleSort = new BubbleSort();
        assertEquals(bubbleSort.sort(input), result);
    }

    @Test
    public void testNullInput() {
        assertThrows(RuntimeException.class, () -> {
            BubbleSort bubbleSort = new BubbleSort();
            assertNull(bubbleSort.sort(null));
        });
    }
}
