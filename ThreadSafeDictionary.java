package Threading;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeDictionary<K, V> {
    private ConcurrentHashMap<K, V> tome = new ConcurrentHashMap<>();

    public void put(K key, V value) {
        tome.put(key, value);
    }

    public V get(K key) {
        return tome.get(key);
    }
}
