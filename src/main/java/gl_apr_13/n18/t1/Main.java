package gl_apr_13.n18.t1;

import java.util.Collection;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Collection<String> a=new ArrayList<>();
//        Collection<String> a=new HashSet<>();
        Collection<String> a=new TreeSet<>();
        a.add("rlma");
        a.add("kzfb");
        a.add("dc");
//        Collection<String> b=new ArrayList<>();
        Collection<String> b=new TreeSet<>();
        b.add("kzfb");
        b.add("dc");
        b.add("d");

        System.out.println(a);
        System.out.println(b);
        a.addAll(b);
        System.out.println(a);

    }
}
