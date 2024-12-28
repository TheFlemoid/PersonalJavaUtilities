package com.dobby.utils.struct;

/**
 * Structure containing a key-value pair of Objects.
 * Created by Franklyn Dahlberg, III, 2024.
 */

public class Pair<K, V> {
    
    private final K key;
    private final V value;

    public static <K, V> Pair<K, V> createPair(final K key, final V value) {
        return new Pair<K, V>(key, value);
    }

    public Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
