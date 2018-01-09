package vlal.u7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<User> users = getAllUsers();
        System.out.println(users);
        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);
        users.removeIf(user -> user.getName().equals("d22"));
        System.out.println(users);
        List<String> s=new ArrayList<>();
        s.add("dcxv");
        s.add("ugj");
        s.add("wutyfbh");
        System.out.println(s);
        s.replaceAll(string -> {
            StringBuilder builder=new StringBuilder(string);
            return builder.reverse().toString();
        });
        System.out.println(s);
        System.out.println("=============================");

        new Main().example();
    }

    private  void example() {
        List<String> names = Arrays.asList("qwe", "asd", "zxc");
        System.out.println(names);
//        List<User> users2 =map(names, User::new);
//        System.out.println(users2);
    }

    public <S,T> List<T> map(List<S> names, Function<S,T> function) {
        List<T> result = new ArrayList<>(names.size());
        names.forEach(s -> result.add(function.apply(s)));
        return  result;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
//        users.add(new User("h1"));
//        users.add(new User("d22"));
//        users.add(new User("hd22"));
//        users.add(new User("e333"));

        return users;
    }
}
