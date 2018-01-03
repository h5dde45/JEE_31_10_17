package tagval.u5;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        System.out.println(rangeSet(10,20).contains(10));
        System.out.println(rangeSet(10,20).contains(20));
        long startTime = System.nanoTime();
        System.out.println(rangeSet(0,Integer.MAX_VALUE).contains(-1));
        System.out.println((System.nanoTime()-startTime)/1000_000);
        System.out.println(rangeSet(10,20));

    }
    static Set<Integer> rangeSet(int fromInclusive, int toInclusive){
        return new AbstractSet<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int next=fromInclusive;
                    @Override
                    public boolean hasNext() {
                        return next!=toInclusive;
                    }

                    @Override
                    public Integer next() {
                        if(next==toInclusive){
                            throw new NoSuchElementException();
                        }
                        return next++;
                    }
                };
            }

            @Override
            public int size() {
                return toInclusive-fromInclusive;
            }
        };
    }
}
