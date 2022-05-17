package com.buaa.writtentest.huawei;

import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        String s = "aaaa";
        String s1 = "bbbb";
        System.out.println(s.compareTo(s1));
        String[] sarr = new String[]{"aaaa","bbbb","aaaaa","bbbb"};

        Arrays.sort(sarr);

        System.out.println(Arrays.toString(sarr));
    }
}
