package com.buaa.sort;
//将未排序的数字插入到排好序的数组中
public class InsertionSort {

    //交换法：在新数字插入过程中，不断与前面的数字交换，直到找到自己合适的位置。
    public void insertSort_swap(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int j = i;
            while (j>=1&&arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    //优化方案：让新插入的数字先进行比较，前面比它大的数字不断向后移动，直到找到适合这个新数字的位置后，新数字只做一次插入操作即可。
    //移动法：在新数字插入过程中，与前面的数字不断比较，前面的数字不断向后挪出位置，当新数字找到自己的位置后，插入一次即可
    public void insertSort_move(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int currentNum = arr[i];
            int j = i-1;
            while (j>0&&currentNum<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currentNum;
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //插入排序过程需要两层循环，时间复杂度为 O(n^2)
    //只需要常量级的临时变量，空间复杂度为 O(1)。

    public static void main(String[] args) {
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        InsertionSort selectionSort=new InsertionSort();
        selectionSort.insertSort_move(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
