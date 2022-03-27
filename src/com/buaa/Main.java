package com.buaa;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] rec = new int[n][m];
            for (int i = 0;i<n;i++){
                for (int j = 0;j<m;j++){
                    rec[i][j] = sc.nextInt();
                }
            }

            int ans = 0;

            for (int i = 0;i<n;i++){
                for (int j = 0;j<m;j++){
                    if(rec[i][j]==1){
                        continue;
                    }
                    ans += score(i,j,rec,n,m);
                }
            }
            System.out.println(ans);
        }


    }

    public static int score(int x,int y,int[][] rec,int n,int m){
        int ans = 0;
        //shang
        for (int i = x-1;i>=0;i--){
            if(rec[i][y]==1){
                ans++;
                break;
            }
        }
        //xia
        for (int i = x+1;i<n;i++){
            if(rec[i][y]==1){
                ans++;
                break;
            }
        }
        //zuo
        for (int i = y-1;i>=0;i--){
            if(rec[x][i]==1){
                ans++;
                break;
            }
        }
        //you
        for (int i = y+1;i<m;i++){
            if(rec[x][i]==1){
                ans++;
                break;
            }
        }
        return ans;
    }


}
