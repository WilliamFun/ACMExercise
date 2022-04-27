package com.buaa.writtentest.wangyi;

public class zhaoze {

    public static void main(String[] args) {

    }

    static int minPath = Integer.MAX_VALUE;
    static int end = 0;
    static int[] mark;
    static int[][] edge;
    public static void findPath(int n,int m,int[] matrix){
        end = n*m-1;
        mark = new int[m*n];
        edge = new int[m*n][m*n];
        for (int i = 0;i<m*n;i++){
            for (int j = 0;j<=i;j++){
                if(i==j){
                    edge[i][j] = 0;
                }
            }

        }


    }

    public static void dfs(int cur,int dst){
        if(minPath < dst) return;//当前走过路径大于之前最短路径，没必要再走下去
        if(cur == end){//临界条件
            if(minPath > dst) minPath = dst;
        }
        else{
            for(int i = 1; i <= end; i++){
                if(edge[cur][i] != -1 && edge[cur][i] != 0 && mark[i] == 0){
                    mark[i] = 1;
                    dfs(i, dst+edge[cur][i]);
                    mark[i] = 0;  //需要在深度遍历返回时将访问标志置0
                }
            }
        }
    }

}
