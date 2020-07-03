package com.janguo.javabasic.effectivebook.concurrentfortartuml;

import java.util.concurrent.locks.ReentrantLock;

public class HashEntry<K, V> extends ReentrantLock {
    private HashEntry<K,V> next;
    private K key;
    private int segments;
    private V value;
}
