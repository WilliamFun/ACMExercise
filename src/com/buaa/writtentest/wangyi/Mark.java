package com.buaa.writtentest.wangyi;

public class Mark {
    public static void main(String[] args) {
        String s = "abbabb";
        System.out.println(markScore(s));
    }

    public static int markScore(String s){
        //记录从i开始相邻连个标记的话的得分
        int[] record = new int[s.length()];
        for (int i = 0;i<s.length();i++){
            if(i==s.length()-1){
                record[i] = 0;
                continue;
            }
            if(Math.abs(s.charAt(i)-s.charAt(i+1))<=1){
                record[i] = s.charAt(i)-'a'+1+s.charAt(i+1)-'a'+1;
            }else{
                record[i] = 0;
            }
        }
        //问题简化为求数组中不相邻数最大和
        int[] dp = new int[s.length()];
        dp[0] = record[0];
        dp[1] = record[1];
        dp[2] = record[0]+record[2];
        for (int i = 3;i<s.length();i++){
            dp[i] = record[i] + Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[s.length()-1],dp[s.length()-2]);
    }
}
