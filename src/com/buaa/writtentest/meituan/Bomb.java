package com.buaa.writtentest.meituan;

import java.util.Scanner;

public class Bomb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int m = 10;
        int[] bob = {2,3,1,3,2,1,1,2,3,1};
        int[] record = new int[n];
        int count = 0;
        int cur = 0;
        while (cur<m) {
            if (bob[cur] == 1 && count == 0) {
                count++;
                record[0] = 1;
            }
            if(count>0&&record[bob[cur]-1]==0){
                record[bob[cur]-1] = 1;
            }
            if (noWay(record)) {
                count++;
                record = clearre(record);
            }
            cur++;
        }
        System.out.println(count);


    }
    public static boolean noWay(int[] record){
        for (int i = 0;i<record.length;i++){
            if(record[i]==0){
                return false;
            }
        }
        return true;
    }
    public static int[] clearre (int[] record){
        for (int i = 0;i<record.length;i++){
            record[i] = 0;
        }
        return record;
    }
}
