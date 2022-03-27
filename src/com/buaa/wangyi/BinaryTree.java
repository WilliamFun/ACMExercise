package com.buaa.wangyi;

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        Treecreate(7);
    }

    public static void Treecreate(int n){
        int[] treerecord = new int[n+1];
        for (int i = 1;i<=n;i++){
            treerecord[i] = i;
        }
        for (int i = 1;i<=n;i++){
            if(2*i<=n){
                swap(treerecord,i,2*i);
            }
        }
        for (int i = 1;i<=n;i++){
            System.out.print(treerecord[i]+" ");
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
