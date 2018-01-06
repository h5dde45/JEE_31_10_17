package alma;

 class Person implements Comparable<Person> {
    private String name;

    @Override
    public int compareTo(Person o) {
        return 0;
    }

//    public int compareTo(Object o) {
//        return toString().compareTo(o.toString());
//    }
}
