package tagval.u6;


import com.sun.istack.internal.NotNull;

public class User implements Comparable<User> {
    private boolean valid;

    public User(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public int compareTo(@NotNull User o) {
        return Boolean.compare(valid,o.valid);
    }

    @Override
    public String toString() {
        return "User{" +
                "valid=" + valid +
                '}';
    }
}

