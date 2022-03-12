package com.buaa.meituan;

import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        System.out.println(hasTwoOne(11111));

    }
    public static boolean hasTwoOne(int n){
        int count = 0;
        int m = n%10;
        n = n/10;
        while(n>0){
            if(m==1){
                count++;
            }
            m = n%10;
            n = n/10;
        }
        if(m==1){
            count++;
        }
        if(count>=2){
            return true;
        }
        return false;
    }
}
