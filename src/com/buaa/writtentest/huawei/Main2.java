package com.buaa.writtentest.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] input = sc.nextLine().split(",");
            int[] tree = new int[input.length];
            for (int i = 0;i<input.length;i++){
                if(i==0){
                    tree[i] = Integer.parseInt(input[i].substring(1));
                }else if(i==input.length-1){
                    tree[i] = Integer.parseInt(input[i].substring(0,1));
                }else {
                    tree[i] = Integer.parseInt(input[i]);
                }
            }
            String[] input2 = sc.nextLine().split("/");
            int[] path = new int[input2.length-1];
            for (int i = 0;i<path.length;i++){
                path[i] = Integer.parseInt(input2[i+1]);
            }
            int index = 0;
            int i = 0;
            while (index< tree.length&&i< path.length){
                if(tree[index]==path[i]){
                    i++;
                    if(i>= path.length) break;
                    if(2*index+1 < tree.length&&tree[2*index+1]==path[i]){
                        index = 2*index+1;
                    }else if(2*index+2< tree.length&&tree[2*index+2]==path[i]){
                        index = 2*index+2;
                    }
                }else {
                    break;
                }
            }
            String[] input3 = sc.nextLine().split(",");
            int[] subtree = new int[input3.length];
            for (int j = 0;j<input3.length;j++){
                if(j==0){
                    subtree[j] = Integer.parseInt(input3[j].substring(1));
                }else if(j==input3.length-1){
                    subtree[j] = Integer.parseInt(input3[j].substring(0,1));
                }else {
                    subtree[j] = Integer.parseInt(input3[j]);
                }
            }
            int flag = 0;
            for (int j = 0;j< subtree.length;){
                tree[index] = subtree[j];
                if(flag==0){
                    index = 2*index+1;
                    j = 2*j+1;
                    flag=1;
                }else {
                    index++;
                    j++;
                    flag = 0;
                }
            }
            int size = 0;
            for (int j = 0;j< tree.length;j++){
                if(tree[j]!=0){
                    size++;
                }
            }
            int[] ans = new int[size];
            int ai = 0;
            for (int j = 0;j< tree.length;j++){
                if(tree[j]!=0){
                    ans[ai] = tree[j];
                    ai++;
                }
            }
            System.out.print("[");
            for (int j = 0;j< tree.length-1;j++){
                System.out.print(ans[j]+",");
            }
            System.out.print(ans[ans.length-1]);
            System.out.print("]");
        }
    }

}
