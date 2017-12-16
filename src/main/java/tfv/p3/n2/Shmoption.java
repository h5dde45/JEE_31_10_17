package tfv.p3.n2;

import java.util.NoSuchElementException;

public class Shmoption<T> {
    T value;

    public Shmoption(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public boolean isPresent() {
        return value != null;
    }
}
