package tagval.u5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        nCopies("qwe", 5);

    }

    private static <T> Iterable<T> nCopies(T value, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("negative count:" + count);
        }
        return () -> new Iterator<T>() {
            int result = count;

            @Override
            public boolean hasNext() {
                return result > 0;
            }

            @Override
            public T next() {
                if (result == 0) {
                    throw new NoSuchElementException();
                }
                System.out.println(value);
                result--;
                return value;
            }
        };
    }
}
