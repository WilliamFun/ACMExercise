package com.buaa.leetcodecontest;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[] can = new int[]{84,40,66,44,91,90,1,14,73,51,47,35,18,46,18,65,55,18,16,45,43,58,90,92,91,43,44,76,85,72,24,89,60,94,81,90,86,79,84,41,41,28,44};
        //System.out.println(1 & 100);
        System.out.println(largestCombination(can));

    }
    public static int largestCombination(int[] candidates) {
        //找到32位某一位1最多的数量
        int[] cha = new int[32];
        for (int c:candidates){
            for (int i = 0;i<32;i++){
                if((1<<i & c)>0) cha[i]++;
            }
        }
        Arrays.sort(cha);
        return cha[31];

    }


//    public static void backtrack(int[] candidates,int start,int res){
//        if(res==0) return;
//        if(path.size()>ans&&res>0){
//            ans = path.size();
//        }
//
//        for (int i = start;i<candidates.length;i++){
//            if((res & candidates[i])==0) continue;
//            path.add(candidates[i]);
//            if(res==-1) {
//                backtrack(candidates,i+1,candidates[i]);
//            }else {
//                backtrack(candidates,i+1,res & candidates[i]);
//            }
//            path.remove(path.size()-1);
//        }
//
//    }

//    public static boolean isValid(List<Integer> path){
//        int res = path.get(0);
//        for (int i = 1;i<path.size();i++){
//            res = res & path.get(i);
//        }
//        return res > 0;
//    }





}
