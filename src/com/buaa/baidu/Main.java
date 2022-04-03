package com.buaa.baidu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 9;
        int k = 8;
        int[] record = new int[k];
        for (int i = 0;i<k;i++){
            record[i] = reverse(n*(i+1));
        }
        Arrays.sort(record);
        System.out.println(record[k-1]);
    }
    public static int reverse(int num){
        if(num<10){
            return num;
        }
        Queue<Integer> qu = new LinkedList<>();
        while(num!=0){
            qu.offer(num%10);
            num = num/10;
        }
        int ans = 0;
        while(!qu.isEmpty()){
            ans *= 10;
            ans += qu.poll();
        }
        return ans;
    }

}
