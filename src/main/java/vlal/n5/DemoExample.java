package vlal.n5;

import java.lang.ref.WeakReference;

public class DemoExample {
    public static void main(String[] args) {
        WeakReference<Integer> weakReference=new WeakReference<>(128);
        System.out.printf("Before: %s\n",weakReference.get());

        for (int i = 1;weakReference.get() != null; i++) {
            System.gc();
            System.out.printf("After %d : %s\n",i,weakReference.get());
        }
    }
}
