package tfv.p5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

    }

    static <T> Iterable<T> nCopies(T value, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Negative count: " + count);
        }
        return () -> new Iterator<T>() {
            int rest = count;

            @Override
            public boolean hasNext() {
                return rest > 0;
            }

            @Override
            public T next() {
                if (rest == 0) {
                    throw new NoSuchElementException();
                }
                rest--;
                return value;
            }
        };
    }
}
