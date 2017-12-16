package vld.p7;

public class User {
    private String fn;
    private String sn;

    public User(String fn) {
        this.fn = fn;
    }

    public User(String fn, String sn) {
        this.fn = fn;
        this.sn = sn;
    }

    public String getFn() {
        return fn;
    }

    public String getSn() {
        return sn;
    }

    @Override
    public String toString() {
        return "User{" +
                "fn='" + fn + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }

}
