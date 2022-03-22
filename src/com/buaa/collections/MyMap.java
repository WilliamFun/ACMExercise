package com.buaa.collections;

public interface MyMap<K,V> {

    V put(K key,V value);

    V get(K key);

    interface Entry<K,V>{
        K getKey();
        V getValue();
        Entry<K,V> getNext();
    }

}
