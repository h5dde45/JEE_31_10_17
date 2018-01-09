package vlal.u7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LamdaStream {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("4etg",34),
                new User("wr",56),
                new User("jwr",156),
                new User("cwr",356),
                new User("yu",14));
        System.out.println(users);

        users.stream()
                .filter(user -> user.getAge()>20)
                .sorted(Comparator.comparing(User::getName))
                .limit(3)
                .forEach(System.out::println);

    }
}
