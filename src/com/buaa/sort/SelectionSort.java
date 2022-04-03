package com.buaa.sort;

public class SelectionSort {

    //选择排序：双重循环遍历数组，每经过一轮比较，找到最小元素的下标，将其交换至首位
    public void selectionSort(int[] arr){

    }

    public static void main(String[] args) {
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        SelectionSort selectionSort=new SelectionSort();
        selectionSort.selectionSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
