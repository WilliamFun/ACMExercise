package com.buaa.writtentest.meituan;

public class Substring {
    public static void main(String[] args) {
        int n = 4;
        int[] lis = {1,1,-1,-1};
        int res;
        int count = 0;
        for (int i = 0;i<n;i++){//从i开始
            res = 1;
            for (int j = i;j<n;j++){
                if(lis[j]*res>0){
                    count++;
                }
                res = lis[j]*res;
            }
        }
        System.out.println(count);


    }
}
