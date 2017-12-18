package slq.n199200;

import java.io.Serializable;

public class Stud implements Serializable{
    protected static String fclt;
    private String name;
    private int id;
    private transient String password;
    private static  final long serVersion= 1L;

    public Stud(String nameOfFclt, String name, int id, String password) {
        fclt=nameOfFclt;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Stud{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", fclt='" + fclt + '\'' +
                '}';
    }
}
