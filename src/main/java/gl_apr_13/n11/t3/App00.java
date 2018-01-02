package gl_apr_13.n11.t3;

import java.io.*;

public class App00 {
    public static void main(String[] args) throws IOException {
        write();
        System.out.println(read());
    }

    private static void write() throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(
                        new File(
                                "C:\\java_projects\\july2017\\" +
                                        "JEE_31_10_17\\src\\main\\" +
                                        "java\\gl_apr_13\\n11\\t3\\data.text"))
        ) {
            BusinessDataOutput out = new BusinessDataOutput(
                    new DataOutputStream(
                            outputStream
                    ));
            out.writeUser(new User("first", 34));
        }
    }

    private static User read() throws IOException {
        try (
                FileInputStream inputStream = new FileInputStream(
                        new File(
                                "C:\\java_projects\\july2017\\" +
                                        "JEE_31_10_17\\src\\main\\" +
                                        "java\\gl_apr_13\\n11\\t3\\data.text"))
        ) {
            BusinessDataInput in = new BusinessDataInput(
                    new DataInputStream(
                            inputStream
                    ));
            return in.readUser();
        }
    }
}

interface BusinessOutput {
    void writeUser(User user) throws IOException;
}

interface BusinessInput {
    User readUser() throws IOException;
}

class BusinessDataOutput implements BusinessOutput {
    private final DataOutput out;

    public BusinessDataOutput(DataOutput out) {
        this.out = out;
    }

    @Override
    public void writeUser(User user) throws IOException {
        out.writeUTF(user.getName());
        out.writeInt(user.getAge());
    }
}

class BusinessDataInput implements BusinessInput {
    private final DataInput in;

    public BusinessDataInput(DataInput in) {
        this.in = in;
    }

    @Override
    public User readUser() throws IOException {
        return new User(in.readUTF(), in.readInt());
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
