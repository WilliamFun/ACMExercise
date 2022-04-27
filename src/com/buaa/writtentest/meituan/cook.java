package com.buaa.writtentest.meituan;

import java.util.*;

public class cook {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] costums = {{1, 2},{2, 3},{3, 4}};
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<n;i++){//从i开始,选i
            set.add(costums[i][0]);
            set.add(costums[i][1]);
            int count = 1;
            for (int j = i+1;j<n;j++){
                if(!set.contains(costums[j][0])&&!set.contains(costums[j][1])){
                    count++;
                    set.add(costums[j][0]);
                    set.add(costums[j][1]);
                }
            }
            max = Math.max(max,count);
            set.clear();
        }
        System.out.println(max);
    }
}
