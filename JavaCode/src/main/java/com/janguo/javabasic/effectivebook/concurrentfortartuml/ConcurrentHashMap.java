package com.janguo.javabasic.effectivebook.concurrentfortartuml;


import java.util.AbstractMap;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> {

    private Segment<K, V> segment;


    static class Segment<K, V> extends ReentrantLock {
        private int count;
        private int modCount;
        private int threshold;
        private HashEntry<K, V> table;
        private int loadFactor;

        public V get() {
            return null;
        }

        public V put() {
            return null;
        }
    }

//    static class HashEntry<K, V> {
//        private HashEntry<K, V> next;
//        private K key;
//        private int segments;
//        private V value;
//    }


    public V get() {
        return null;
    }


    public V put() {
        return null;
    }

    public int size() {
        return 1;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public V remove() {
        return null;
    }

    public V putIfAbsent() {
        return null;
    }

}
