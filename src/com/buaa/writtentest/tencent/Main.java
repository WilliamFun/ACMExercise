package com.buaa.writtentest.tencent;

public class Main {

    private static int count = 0;
    public static void main(String[] args) {
        //System.out.println(Factorial(9,1));
        backtrack(3,1,0,1,0);
        System.out.println(count);
        //System.out.println(ksize(3, 1));

    }

    public static int ksize(int n,int k){
        if(n<2*k){
            return 0;
        }
        return (int) (Factorial(n-1,n-k)*26*Math.pow(25,k-1))%1000000;
    }

    public static long Factorial(int start,int end){
        long ans = start;
        for (int i = start-1;i>=end;i--){
            ans *= i;
        }
        return ans;
    }

    public static void backtrack(int end,int current,int pre,int k,int num){
        if(num==k){
            if (current-pre<=1) return;
            if(current!=end) return;
            count++;
            return;
        }

        for (int i = current+1;i<=end;i++){
            if(i-pre>1){
                backtrack(end,i,i,k,num+1);
            }
        }
    }






}
