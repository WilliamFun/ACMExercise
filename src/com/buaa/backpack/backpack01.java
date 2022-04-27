package com.buaa.backpack;

import java.util.Scanner;

public class backpack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] v = new int[N+1];
            int[] w = new int[N+1];
            for (int i = 1;i<=N;i++){
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            //dp[i][j]表示容量为j时前i个物品的最大价值
//            int[][] dp = new int[N+1][M+1];
//            for (int i = 1;i<=N;i++){
//                //遍历每个物品
//                for (int j = 1;j<=M;j++){
//                    //从1开始遍历每个容量
//                    if(j<w[i]){
//                        //装不下，取前i-1个物品的最大值
//                        dp[i][j] = dp[i-1][j];
//                    }else{
//                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//                    }
//                }
//            }
//            System.out.println(dp[N][M]);
            //dp[i]表示容量为的最大价值
            int[] dp = new int[M+1];
            for (int i = 1;i<=N;i++){
                for (int j = M;j>0;j--){
                    if(j>=w[i]){
                        //装得下
                        dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
                    }
                }
            }
            System.out.println(dp[M]);
        }

    }

}
