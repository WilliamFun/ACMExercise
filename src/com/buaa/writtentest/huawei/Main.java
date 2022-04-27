package com.buaa.writtentest.huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

        }
    }

    public static int solution(int n,int[] first,int[] second){
        int f = 0;
        int s = 0;
        int ans = -1;

        while (f<n&&s<n){
            if(first[f]==second[s]){
                f++;
                s++;
                continue;
            }
            if(f+1<n&&first[f+1]==second[s]){
                ans = s;
                s++;
            }

            if(s+1<n&&first[f]==second[s+1]){
                ans = f;
                s++;
            }
            break;
        }
        return ans;
    }


}
