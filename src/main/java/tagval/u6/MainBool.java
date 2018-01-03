package tagval.u6;

import java.util.Set;
import java.util.TreeSet;

public class MainBool {
    public static void main(String[] args) {
        Set<User> set = new TreeSet<>();
        User user = new User(true);
        set.add(user);
        set.add(user);
        System.out.println(set);
    }
}
