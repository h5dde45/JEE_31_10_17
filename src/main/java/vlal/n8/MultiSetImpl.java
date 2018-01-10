package vlal.n8;

import java.util.AbstractCollection;
import java.util.Iterator;

public class MultiSetImpl<E> extends AbstractCollection<E> implements MultiSet<E> {
    private Object[] store;

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }
}
