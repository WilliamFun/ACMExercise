package com.buaa.writtentest.baidu;

public class LcmandGcd {
    public static void main(String[] args) {
        int t = 2;
        int[] input = new int[]{16,2021};
        for (int i = 0;i<t;i++){
            int num = input[i];
            int count = 0;
            for (int j = 1;j<Math.sqrt(num);j++){
                if(j*(num/j)!=num){
                    continue;
                }
                if(gcd(j,num/j)==1){
                    count++;
                }
            }
            System.out.println(count);
        }


    }
    public static int gcd(int a,int b){
        int ans = 0;
        if(a<b){
            int temp = b;
            b = a;
            a = temp;
        }
        if(a%b==0){
            return b;
        }
        while (a%b>0){
            a = a%b;
            if(a<b){
                int temp = b;
                b = a;
                a = temp;
            }
            if(a%b==0){
                ans = b;
            }
        }
        return ans;

    }

}
