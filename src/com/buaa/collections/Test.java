package com.buaa.collections;

public class Test {
    public static void main(String[] args) {
        MyMap<String, Object> map = new MyHashMap<>();
        map.put("name", "zuozhen");
        map.put("age", 23);
        map.put("weight", 75);
        map.put(null, "zuozhen2");

        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.get("weight"));
        System.out.println(map.get(null));

        map.put("name", "zuozhen1");
        System.out.println(map.get("name"));
    }
}
