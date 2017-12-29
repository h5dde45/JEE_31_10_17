package gl_apr_13.n19.t2;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Entity> entitySet=new HashSet<>();
        entitySet.add(new Entity("111",111));
        entitySet.add(new Entity("222",222));
        entitySet.add(new Entity("333",333));
        entitySet.add(new Entity("222",222));

        System.out.println(entitySet);
        System.out.println(entitySet.contains(new Entity("333",333)));
    }
}
class Entity{
    private String name;
    private int age;

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        if (age != entity.age) return false;
        return name != null ? name.equals(entity.name) : entity.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}