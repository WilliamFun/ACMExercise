package com.buaa.baidu;

import java.util.Scanner;

public class ReverseABC {
    public static void main(String[] args) {
        int n = 5;
        int q = 1;
        for (int i = 0;i<q;i++){
            String s = "ABCBA";
            char[] chars = s.toCharArray();
            int cur = 1;
            int count = 0;
            int[] length = new int[n];
            length[0] = 1;
            while (cur<n){
                if(chars[cur]<=chars[0]&&length[cur-1]==1){
                    reverse(chars,cur-1);
                    count++;
                    cur = 1;
                    continue;
                }
                if(chars[0]!='A'&&cur==n-1){
                    reverse(chars,cur);
                    count++;
                    cur = 1;
                    continue;
                }
                if(chars[0]=='A'&&cur==n-1) break;
                if(chars[cur]>=chars[cur-1]&&length[cur-1]==1){
                    length[cur]=1;
                } else{
                    length[cur] = 0;
                }
                cur++;
            }
            System.out.println(count);
        }
    }

    public static void reverse(char[] chars,int cur){
        int l = 0;
        int r = cur;
        while (l<r){
            char temp = chars[r];
            chars[r] = chars[l];
            chars[l] = temp;
            l++;
            r--;
        }
    }

}
