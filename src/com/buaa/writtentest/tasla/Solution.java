package com.buaa.writtentest.tasla;

class Solution {

    public static void main(String[] args) {
        int[] A = new int[]{6, 4, 4, 6};
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int flag = 0;
        for(int i = 0;i<A.length;i++){
            flag=0;
            for(int j = i+1;j<A.length;j++){
                if(A[i]==A[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0) return A[i];
        }
        return -1;

    }

}
