package com.buaa.sort;

public class QuickSort {
    public void quickSort(int[] nums,int begin,int end){
        if(begin>end) return;
        int i=begin,j=end;//初始化两个哨兵
        int temp=nums[begin];//确定基准数据
        while (i<j){
            //右边开始找比基准数据小的数
            while (i<j&&nums[j]>=temp){
                j--;
            }
            //左边找比基准数据大的数
            while (i<j&&nums[i]<=temp){
                i++;
            }
            //找到后做交换
            if(i<j){
                int t=nums[j];
                nums[j]=nums[i];
                nums[i]=t;
            }
        }
        //重新确定基准数据
        nums[begin]=nums[j];
        nums[j]=temp;
        quickSort(nums,begin,j-1);//左边递归
        quickSort(nums,j+1,end);//右边递归
    }

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        int[] nums={1,5,6,2,3,4,8,9,2,1,0,6,158};
        quickSort.quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.println(i);
        }
    }
}