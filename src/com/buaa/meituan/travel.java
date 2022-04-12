package com.buaa.meituan;

import java.util.Scanner;

public class travel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");
            int[][] paths = new int[2][m];
            for (int i = 0;i<2;i++){
                for (int j = 0;j<m;j++){
                    if(i==0){
                        paths[i][j] = Integer.parseInt(s1[j]);
                    }else {
                        paths[i][j] = Integer.parseInt(s2[j]);
                    }
                }
            }
            int[][] matrix = new int[n][n];
            for (int i = 0;i<m;i++){
                if(matrix[paths[0][i]-1][paths[1][i]-1]==1) continue;
                matrix[paths[0][i]-1][paths[1][i]-1] = 1;
                matrix[paths[1][i]-1][paths[0][i]-1] = 1;
            }
            int q = sc.nextInt();
            sc.nextLine();
            for (int i = 0;i<q;i++){
                String[] s = sc.nextLine().split(" ");
                int x = Integer.parseInt(s[0])-1;
                int y = Integer.parseInt(s[1])-1;
                if(matrix[x][y]==1){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }



}
