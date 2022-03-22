package com.buaa.sort;


import java.util.*;
import java.util.Map.Entry;


public class HashMapSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("c", 33333);
        map.put("a", 11111);
        map.put("d", 44444);
        map.put("e", 55555);
        map.put("b", 22222);

        //将map.entrySet()转换成list
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
        //降序排序
        Collections.sort(list, (o1, o2) -> {
            //return o1.getValue().compareTo(o2.getValue());
//                return o2.getValue().compareTo(o1.getValue());
            return o2.getValue()-o1.getValue();
        });

        for (Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

    }
}
