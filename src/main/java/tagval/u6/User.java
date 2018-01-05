package tagval.u6;


public class User implements Comparable<User> {
    private boolean valid;

    public User(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public int compareTo( User o) {
        return Boolean.compare(valid,o.valid);
    }

    @Override
    public String toString() {
        return "User{" +
                "valid=" + valid +
                '}';
    }
}

