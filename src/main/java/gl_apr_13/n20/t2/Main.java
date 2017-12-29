package gl_apr_13.n20.t2;

import java.util.Iterator;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Iterator<Integer> iterator = asList(1, 2, 3).iterator();
        Iterator<Integer> iterator2 = asList(1, 2, 3).iterator();

        for (Iterator<Integer> iterator1 =  iterator; iterator.hasNext(); ) {
            System.out.print(iterator.next()+" ");
        }
    }
}
