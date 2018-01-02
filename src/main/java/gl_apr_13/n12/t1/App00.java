package gl_apr_13.n12.t1;

import java.io.*;
import java.util.Arrays;

public class App00 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Entity n1 = new Entity(22, "n1");
        n1.setEntities(new Entity[]{n1,  new Entity(12, "ddd")});

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        try (
                ObjectOutput out = new ObjectOutputStream(buff)
        ) {
            out.writeObject(n1);
        }
        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);
        System.out.println(Arrays.toString(rawData));
        System.out.println(new String(rawData));
        System.out.println("==========================");
        ByteArrayInputStream inO = new ByteArrayInputStream(rawData);
        try (
                ObjectInputStream in = new ObjectInputStream(inO)
        ) {
            Entity entity = (Entity) in.readObject();
            System.out.println(entity);
        }
    }
}

class Entity implements Serializable {
    private final int age;
    private final String name;
    private Entity[] entities;

    public Entity(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s ="";
        for (Entity entity : entities) {
            s += "Entity{" +
                    "age=" + entity.age +
                    ", name='" + entity.name + '}';
        }
        return "Entity{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", entities=" + s +
                '}';
    }
}
