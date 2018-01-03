package tagval.u5;

import java.util.AbstractList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

    }

    static List<Integer> rangeList(int fromElement, int toElement) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index >= size()) {
                    throw new IndexOutOfBoundsException(Integer.toString(index));
                }
                return fromElement + index;
            }

            @Override
            public int size() {
                return toElement - fromElement;
            }
        };
    }
}
