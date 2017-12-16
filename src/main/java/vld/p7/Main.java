package vld.p7;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<User> users = getAllUsers();
        System.out.println(users);

//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User user1, User user2) {
//                return user1.getFn().compareTo(user2.getFn());
//            }
//        });
//        Collections.sort(users, (user1, user2) -> user1.getFn().compareTo(user2.getFn()));
        Collections.sort(users, Comparator.comparing(User::getFn));
        System.out.println(users);
        users.forEach((user) -> System.out.print(user.getSn() + ", "));
        System.out.println();
        users.removeIf(user -> user.getSn().equals("2rty"));
        System.out.println(users);
        users.replaceAll(user -> {
            StringBuilder builder = new StringBuilder(user.getFn());
            return new User(builder.reverse().toString(), user.getSn());
        });
        System.out.println(users);
        users.forEach(System.out::println);

        List<User> users2 = Arrays.asList(new User("3", "4"), new User("5", "2"));
        users2.forEach(System.out::println);

        List<String> names = Arrays.asList("rt", "p[", "dfv");
        List<User> users3 = map(names, User::new);
        users3.forEach(System.out::println);
        System.out.println("===============================");

        List<Person> people = getAllPersons();
        people.forEach(System.out::println);
        System.out.println("===============================");

        people.stream()
                .filter(person -> person.getAge() > 50)
                .sorted(Comparator.comparing(Person::getAge))
                .limit(2)
                .forEach(System.out::println);
        System.out.println("===============================");
        people.forEach(System.out::println);

    }

    private static List<Person> getAllPersons() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("dfg", 73));
        people.add(new Person("yhf", 53));
        people.add(new Person("sad", 63));
        people.add(new Person("edx", 33));
        return people;


    }

    private static <S, T> List<T> map(List<S> names, Function<S, T> function) {
        List<T> result = new ArrayList<>(names.size());
        names.forEach(s -> result.add(function.apply(s)));
        return result;
    }

    private static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        User user = new User("kqsd", "1rty");
        users.add(user);
        User user2 = new User("yqsd", "2rty");
        users.add(user2);
        User user3 = new User("gqsd", "3rty");
        users.add(user3);
        User user4 = new User("dqsd", "4rty");
        users.add(user4);
        return users;
    }
}
