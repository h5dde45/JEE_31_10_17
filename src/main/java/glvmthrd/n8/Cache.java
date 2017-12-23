package glvmthrd.n8;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private Map<Integer, String> map =
            new ConcurrentHashMap<>(1024, 0.75f, 1024);

    public String get(Object key) {
        return map.get(key);
    }

    public String put(Integer key, String value) {
        return map.put(key, value);
    }

    public <K, V> Map<K, V> synchronizedMap(Map<K, V> m) {
        return new MyMap<K, V>(m) {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public V get(Object key) {
                return null;
            }

            @Override
            public V put(K key, V value) {
                return null;
            }

            @Override
            public V remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends K, ? extends V> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<K> keySet() {
                return null;
            }

            @Override
            public Collection<V> values() {
                return null;
            }

            @Override
            public Set<Entry<K, V>> entrySet() {
                return null;
            }
        };
    }

    private static class MyMap<T0, T1> implements Map<T0, T1> {
        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private final Lock rLock = readWriteLock.readLock();
        private final Lock wLock = readWriteLock.writeLock();
        private final Map<T0, T1> m;

        public MyMap(Map<T0, T1> m) {
            this.m = m;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public T1 get(Object key) {
            return null;
        }

        @Override
        public T1 put(T0 key, T1 value) {
            return null;
        }

        @Override
        public T1 remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends T0, ? extends T1> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<T0> keySet() {
            return null;
        }

        @Override
        public Collection<T1> values() {
            return null;
        }

        @Override
        public Set<Entry<T0, T1>> entrySet() {
            return null;
        }
    }
}

class TTT {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock r = readWriteLock.readLock();
        Lock w = readWriteLock.writeLock();

        new Thread(() -> {
            r.lock();
            System.out.println("0");
            while (true){

            }
        }).start();

        new Thread(() -> {
            w.lock();
            System.out.println("1");
            while (true){

            }
        }).start();
    }
}