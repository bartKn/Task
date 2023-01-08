import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> {

    public List<T> sort(List<T> input) {
        if (input == null) {
            throw new RuntimeException();
        }

        input.removeAll(Collections.singleton(null));

        int n = input.size() - 1;
        boolean swapFlag;

        do {
            swapFlag = false;
            for(int i = 0; i < n; i++){
                if (input.get(i).compareTo(input.get(i + 1)) > 0) {
                    Collections.swap(input, i, i + 1);
                    swapFlag = true;
                }
            }
            n--;
        } while(swapFlag);

        return input;
    }
}
