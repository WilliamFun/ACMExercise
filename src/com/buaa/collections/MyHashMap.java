package com.buaa.collections;

import java.util.Map;

public class MyHashMap<K,V> implements MyMap<K,V>{

    private static final int DEFAULT_INIT_CAPACITY = 16;
    private int init_capacity = 0;
    private Entry<K,V>[] table = null;

    public MyHashMap(){
        this.init_capacity = DEFAULT_INIT_CAPACITY;
        //table = new Entry[this.init_capacity];
    }

    public MyHashMap(int init_capacity){
        this.init_capacity = init_capacity;
        //table = new Entry[this.init_capacity];
    }

    private int hash(K key){//hash函数计算方法
        if(key==null){
            return 0;
        }
        int h = key.hashCode();
        return Math.abs((h)^(h>>16));
    }



    @Override
    public V put(K key, V value) {
        if(table==null){
            table = new Entry[this.init_capacity];
        }
        //计算索引
        int index = hash(key)%init_capacity;
        if(table[index]!=null){
            //链表
            //遍历一下链表看有没有相同的key，若有则更新，若无则加在后面
            Entry<K,V> e = table[index];
            Entry<K,V> pre = null;
            while (e!=null){
                if(hash(e.getKey())==hash(key)&&e.getKey().equals(key)){
                    //有相同值，更新
                    e.value = value;
                    return value;
                }
                pre = e;
                e = e.next;
            }
            //没有找到相同值，直接加在后面
            Entry<K,V> ele = new Entry<>(key,value,index,null);
            pre.next = ele;
        }else {
            //直接存入数组
            Entry<K,V> ele = new Entry<>(key,value,index,null);
            table[index] = ele;
        }
        return value;
    }

    @Override
    public V get(K key) {
        int index = hash(key)%init_capacity;
        if(table[index]!=null){
            Entry<K,V> e = table[index];
            //遍历链表
            while (e!=null){
                if(e.getKey()==null&&key==null){
                    return e.getValue();
                }
                if(hash(e.getKey())==hash(key)&&e.getKey().equals(key)){
                    return e.getValue();
                }
                e = e.next;
            }

        }else{
            return null;
        }
        return null;

    }


    class Entry<K,V> implements MyMap.Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        int index;

        public Entry(K key,V value,int index,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
            this.index = index;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public MyMap.Entry<K, V> getNext() {
            return next;
        }
    }
}
