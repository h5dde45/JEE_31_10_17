package gl_22_01.p8;

import java.util.HashMap;
import java.util.Map;

public class App_01 {
    private Map<Integer, String> map = new HashMap<>();


    public synchronized String get(Object key) {
        return map.get(key);
    }

    public synchronized String put(Integer key, String value) {
        return map.put(key, value);
    }
}

class X {
    public static void main(String[] args) throws InterruptedException {
        App_01 map = null;
        synchronized (map) {
            while (true) {
                map.wait();
            }
        }
    }
}
