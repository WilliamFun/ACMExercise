package com.buaa.writtentest.tasla;

import java.util.Arrays;

public class smallopt {

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};

        Arrays.sort(A);
        int cur = 1;
        for(int i = 0;i<A.length;i++){
            if(A[i]==cur){
                cur++;
            }
            if(A[i]>cur){
                break;
            }
        }
        System.out.println(cur);
    }
}
